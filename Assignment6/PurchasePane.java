// Assignment #: Arizona State University CSE205 #6
//         Name: Brandon
//    StudentID: 
//      Lecture: T/TH 4:30pm-5:45pm
//  Description: InputPane generates a pane where a user can enter
//  a laptop information and create a list of available laptops.

//Necessary JavaFX imports
import javafx.scene.layout.*;
import java.util.ArrayList;
import javafx.event.*;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;

public class InputPane extends HBox
{
    //GUI components/Global Fields
    private ArrayList<Laptop> laptopList;
    private Label message, brand, model, cpu, ram, price;
    private TextField brandf, modelf, cpuf, ramf, pricef;
    private Button laptopInfo;
    private TextArea info;
    private ScrollPane scroll;
    private GridPane gridPane;

    //The relationship between InputPane and PurchasePane is Aggregation
    private PurchasePane purchasePane;

	//constructor
	public InputPane(ArrayList<Laptop> list, PurchasePane pPane)
	{
		this.laptopList = list;
		this.purchasePane = pPane;

		//Step #1: initialize each instance variable and set up the layout

                //Confirmation Text
                message = new Label("");
                message.setVisible(false);
                
                //Labels
                brand = new Label("Brand");
                model = new Label("Model");
                cpu = new Label("CPU(GHz)");
                ram = new Label("RAM(GB)");
                price = new Label("Price($)");
                
                //TextFields
                brandf = new TextField();
                modelf = new TextField();
                cpuf = new TextField();
                ramf = new TextField();
                pricef = new TextField();
                
                //The Great Button
                laptopInfo = new Button("Enter Laptop Info");
                laptopInfo.setOnAction(new ButtonHandler());

		//Create a GridPane to hold those labels & text fields
                gridPane = new GridPane();
                gridPane.setGridLinesVisible(false);
                gridPane.setPadding(new Insets(10,10,10,10));
                gridPane.setHgap(10);
                gridPane.setVgap(10);
                
   		//GridPane for Labels and TextFields
                gridPane.add(message,0,0,2,1);
                GridPane.setFillWidth(message, true);
                gridPane.addRow(1, brand, brandf);
                gridPane.setHalignment(brand, HPos.CENTER);
                gridPane.addRow(2, model, modelf);
                gridPane.setHalignment(model, HPos.CENTER);
                gridPane.addRow(3, cpu, cpuf);
                gridPane.setHalignment(cpu, HPos.CENTER);
                gridPane.addRow(4, ram, ramf);
                gridPane.setHalignment(ram, HPos.CENTER);
                gridPane.addRow(5, price, pricef);
                gridPane.setHalignment(price, HPos.CENTER);
                gridPane.add(laptopInfo,1,6);
                GridPane.setFillWidth(laptopInfo, true);
                gridPane.setHalignment(laptopInfo, HPos.CENTER);
                gridPane.getColumnConstraints().add(new ColumnConstraints(100));
                gridPane.getColumnConstraints().add(new ColumnConstraints(150));
                gridPane.getRowConstraints().add(new RowConstraints(25));

                //TextArea to show current laptops added
                info = new TextArea();
                info.setText("No Laptops");
                info.setEditable(false);
                info.setWrapText(true);
                info.setPrefWidth(318);
                info.setPrefHeight(365);
                scroll = new ScrollPane(info);
                
                //Add the GridPane and TextArea to the scene
                this.getChildren().addAll(gridPane, scroll);
                
	} //end of constructor

  //ButtonHandler listens to see if the buttont "Enter Laptop Info." is pushed or not,
  //When the event occurs, it get a laptop's brand, model, CPU, RAM and price
  //information from the relevant text fields, then create a new Laptop object and add it inside
  //the laptopList. Meanwhile it will display the laptop's information inside the text area.
  //It also does error checking in case any of the textfields are empty or wrong data was entered.
    private class ButtonHandler implements EventHandler<ActionEvent>
    {
   	//Override the abstact method handle()
        @Override
   	public void handle(ActionEvent e)
        {
            //declare any necessary local variables here
            //---
            String brand, model, cpu, ram, price;
            brand = brandf.getText();
            model = modelf.getText();
            cpu = cpuf.getText();
            ram = ramf.getText();
            price = pricef.getText();

            //when a text field is empty and the button is pushed
            if (brand.equals("") || model.equals("") || cpu.equals("") || ram.equals("") || price.equals(""))
            {
                message.setText("Please fill in all fields");
                message.setTextFill(Color.RED);
                message.setVisible(true);
            }
            else //for all other cases
            {
                //Try-Catch Block for NumberFormat Exception
                try
                {
                    //Parse fields and create new laptop object
                    double cpuD = Double.parseDouble(cpu);
                    double ramD = Double.parseDouble(ram);
                    double priceD = Double.parseDouble(price);
                    Laptop lap = new Laptop(brand, model, cpuD, ramD, priceD);
                    
                    //Empties TextArea when field is first filled
                    if(info.getText().equalsIgnoreCase("No Laptops"))
                    {
                        info.setText("");
                    }
                    
                    //Temporary duplicate checker
                    boolean temp = false;
                    
                    //Prime the temporary duplicate checker by comparing toStrings
                    if(laptopList.size() > 0)
                    {
                        for(int i = 0; i < laptopList.size();i++) 
                        {
                            if (laptopList.get(i).toString().equals(lap.toString()))
                                temp = true;
                        }
                    }
                    
                    //If not a duplicate add to list and perform normal functions
                    if (temp == false)
                    {
                        //Add new laptop to ArrayList
                        laptopList.add(lap);
                        
                        //Temp Concatenation String
                        String add = "";

                        //Add Laptop Information to TextField
                        for (int i = 0; i < laptopList.size();i++) 
                        {
                            add = add + laptopList.get(i).toString();
                        }
                        info.setText(add);
                        
                        //Confirmation Text Update
                        message.setText("Laptop Added!");
                        message.setTextFill(Color.BLUE);
                        message.setVisible(true);

                        //Reset textfields
                        brandf.setText("");
                        modelf.setText("");
                        cpuf.setText("");
                        ramf.setText("");
                        pricef.setText("");
                        
                        //Send new Laptop Object to PurchasePanel
                        purchasePane.updateLaptopList(lap);
                    }
                    //If a duplicate return a duplicate message
                    else
                    {
                        message.setText("Laptop not added - Duplicate");
                        message.setTextFill(Color.RED);
                        message.setVisible(true);
                    }    
                }
                //Catch block for NumberFormat Exception
                catch (NumberFormatException except)
                {
                    message.setText("Incorrect data format");
                    message.setTextFill(Color.RED);
                    message.setVisible(true);
                }
            }
        } //end of handle() method
    } //end of ButtonHandler class
}