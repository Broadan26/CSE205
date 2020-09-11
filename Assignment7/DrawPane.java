// Assignment #: Arizona State University CSE205 #7
//         Name: Brandon
//    StudentID: 
//      Lecture: T/TH 4:30-5:45pm
//  Description: The DrawPane class creates a canvas where we can use
//               mouse key to draw either a Rectangle or a Circle with different
//               colors. We can also use the the two buttons to erase the last
//		 drawn shape or clear them all.

import javafx.scene.layout.Pane;
import javafx.scene.layout.BorderPane;
import javafx.scene.shape.Shape;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Circle;
import javafx.scene.paint.Color;
import javafx.geometry.Insets;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import java.util.ArrayList;
import javafx.collections.FXCollections;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import static javafx.scene.layout.Region.USE_PREF_SIZE;
import javafx.scene.layout.RowConstraints;
import javafx.scene.layout.VBox;

public class DrawPane extends BorderPane
{
    //Declare nodes and variables
    private ArrayList<Shape> shapeList;
    private HBox hBox;
    private Button undo, erase;
    private VBox vBox;
    private GridPane gp;
    private ColumnConstraints cc1, cc2, cc3;
    private RowConstraints rc1, rc2, rc3;
    private RadioButton circlebtn, rectanglebtn;
    private ComboBox comboBox;
    private Pane canvas;
    private ToggleGroup tGroup;
    private String colors[] = {"Black", "Blue", "Green", "Red", "Yellow", "Orange", "Pink"};
    private String clrSelect, shapeSelect;
    private Circle circle;
    private Rectangle rectangle, clipRect;

     //Constructor
    public DrawPane()
    {
        //Instantiate nodes and Variables
        shapeList = new ArrayList<Shape>();
        hBox = new HBox();
        undo = new Button();
        erase = new Button();
        vBox = new VBox();
        gp = new GridPane();
        cc1 = new ColumnConstraints();
        cc2 = new ColumnConstraints();
        cc3 = new ColumnConstraints();
        rc1 = new RowConstraints();
        rc2 = new RowConstraints();
        rc3 = new RowConstraints();
        circlebtn = new RadioButton();
        rectanglebtn = new RadioButton();
        comboBox = new ComboBox(FXCollections.observableArrayList(colors));
        canvas = new Pane();
        tGroup = new ToggleGroup();
        clrSelect = "BLACK";
        
        //Create Rectangle and Circle Objects
        rectangle = new Rectangle(0,0,0,0);
        rectangle.setVisible(false);
        rectangle.setFill(Color.WHITE);
        rectangle.setStroke(Color.BLACK);
        circle = new Circle(0,0,0);
        circle.setVisible(false);
        circle.setFill(Color.WHITE);
        circle.setStroke(Color.BLACK);
        
        //Give the scene height dimensions based off Assignment7
        setMaxHeight(USE_PREF_SIZE);
        setMaxWidth(USE_PREF_SIZE);
        setMinHeight(USE_PREF_SIZE);
        setMinWidth(USE_PREF_SIZE);

        //Create the HBox for the buttons
        BorderPane.setAlignment(hBox, javafx.geometry.Pos.CENTER);
        hBox.setAlignment(javafx.geometry.Pos.CENTER);
        hBox.setPrefHeight(49.0);
        hBox.setPrefWidth(600.0);
        hBox.setSpacing(15.0);
        hBox.setOpaqueInsets(new Insets(10.0));
        BorderPane.setMargin(hBox, new Insets(0.0));
        setBottom(hBox);
        
        //Create the Undo Button
        undo.setMnemonicParsing(false);
        undo.setText("Undo");
        undo.setTextAlignment(javafx.scene.text.TextAlignment.CENTER);
        undo.setPadding(new Insets(5.0, 20.0, 5.0, 20.0));
        undo.setOnAction(new ButtonHandler());

        //Create the Erase Button
        erase.setMnemonicParsing(false);
        erase.setText("Erase");
        erase.setPadding(new Insets(5.0, 20.0, 5.0, 20.0));
        erase.setOnAction(new ButtonHandler());
        
        //Create the VBox for Gridpane
        BorderPane.setAlignment(vBox, javafx.geometry.Pos.CENTER);
        vBox.setAlignment(javafx.geometry.Pos.TOP_CENTER);
        vBox.setPrefHeight(351.0);
        vBox.setPrefWidth(142.0);
        
        //GridPane Constraints
        gp.setAlignment(javafx.geometry.Pos.CENTER);
        gp.setPrefHeight(135.0);
        gp.setPrefWidth(142.0);

        //GridPane Column Constraints
        //Column0
        cc1.setHgrow(javafx.scene.layout.Priority.SOMETIMES);
        cc1.setMaxWidth(68.0);
        cc1.setMinWidth(0.0);
        cc1.setPrefWidth(13.0);
        //Column1
        cc2.setHgrow(javafx.scene.layout.Priority.SOMETIMES);
        cc2.setMaxWidth(142.0);
        cc2.setMinWidth(10.0);
        cc2.setPrefWidth(129.0);
        //Column2
        cc3.setHgrow(javafx.scene.layout.Priority.SOMETIMES);
        cc3.setMaxWidth(42.0);
        cc3.setMinWidth(0.0);
        cc3.setPrefWidth(0.0);

        //GridPane Row Constraints
        //Row0
        rc1.setMaxHeight(247.0);
        rc1.setMinHeight(10.0);
        rc1.setPrefHeight(53.0);
        rc1.setValignment(javafx.geometry.VPos.CENTER);
        rc1.setVgrow(javafx.scene.layout.Priority.ALWAYS);
        //Row1
        rc2.setMaxHeight(243.0);
        rc2.setMinHeight(10.0);
        rc2.setPrefHeight(42.0);
        rc2.setValignment(javafx.geometry.VPos.CENTER);
        rc2.setVgrow(javafx.scene.layout.Priority.SOMETIMES);
        //Row2
        rc3.setMaxHeight(221.0);
        rc3.setMinHeight(10.0);
        rc3.setPrefHeight(43.0);
        rc3.setValignment(javafx.geometry.VPos.CENTER);
        rc3.setVgrow(javafx.scene.layout.Priority.SOMETIMES);

        //Add Circle RadioButton to GridPane and create it
        GridPane.setColumnIndex(circlebtn, 1);
        GridPane.setRowIndex(circlebtn, 1);
        circlebtn.setMnemonicParsing(false);
        circlebtn.setText("Circle");
        circlebtn.setTextAlignment(javafx.scene.text.TextAlignment.CENTER);
        circlebtn.setSelected(true);
        shapeSelect = "Circle";

        //Add Rectangle RadioButton to GridPane and create it
        GridPane.setColumnIndex(rectanglebtn, 1);
        GridPane.setRowIndex(rectanglebtn, 2);
        rectanglebtn.setMnemonicParsing(false);
        rectanglebtn.setText("Rectangle");
        
        //Add Rectangle and Circle to ToggleGroup
        circlebtn.setToggleGroup(tGroup);
        rectanglebtn.setToggleGroup(tGroup);
        circlebtn.setOnAction(new ShapeHandler());
        rectanglebtn.setOnAction(new ShapeHandler());

        //Add ComboBox to GridPane and create it
        GridPane.setColumnIndex(comboBox, 1);
        comboBox.setPrefHeight(25.0);
        comboBox.setPrefWidth(127.0);
        vBox.setOpaqueInsets(new Insets(10.0));
        setLeft(vBox);
        comboBox.setValue("Black");
        comboBox.setOnAction(new ColorHandler());

        //Align canvas and flesh it out
        BorderPane.setAlignment(canvas, javafx.geometry.Pos.CENTER);
        canvas.setStyle("-fx-background-color: beige;");
        canvas.setPrefHeight(200.0);
        canvas.setPrefWidth(200.0);
        canvas.getChildren().addAll(shapeList);
        setCenter(canvas);
        clipRect = new Rectangle(500, 350);
        canvas.setClip(clipRect);
        
        //Canvas Mouse Command Calls
        canvas.setOnMousePressed(new MouseHandler());
        canvas.setOnMouseDragged(new MouseHandler());
        canvas.setOnMouseReleased(new MouseHandler());
        
        //Add nodes to gridpane and containers
        hBox.getChildren().addAll(undo,erase);
        gp.getColumnConstraints().addAll(cc1,cc2,cc3);
        gp.getRowConstraints().addAll(rc1,rc2,rc3);
        gp.getChildren().addAll(circlebtn,rectanglebtn,comboBox);
        vBox.getChildren().add(gp);
    }

    //Step #2(A) - MouseHandler
    private class MouseHandler implements EventHandler<MouseEvent>
    {
        @Override
        public void handle(MouseEvent event)
        {
            try {
                //For Rectangle
                if(shapeSelect.equals("Rectangle"))
                {
                    //Use initial click to add object to shapeList & get coordinates
                    if(event.getEventType() == MouseEvent.MOUSE_PRESSED)
                    {
                        shapeList.add(rectangle);
                        int track = 0;
                        for (int i = 0; i < shapeList.size();i++)
                        {
                        track = i;
                        }
                        canvas.getChildren().add(shapeList.get(track));
                        rectangle.setVisible(true);
                        rectangle.setTranslateX(event.getX());
                        rectangle.setTranslateY(event.getY());
                    }
                    //Set Dimensions of shape to Mouse Drag
                    if(event.getEventType() == MouseEvent.MOUSE_DRAGGED && rectangle.isVisible())
                    {
                        rectangle.setWidth(event.getX() - rectangle.getTranslateX());
                        rectangle.setHeight(event.getY() - rectangle.getTranslateY());
                    }
                    //Fill shape, Reset object for shapeList
                    if(event.getEventType() == MouseEvent.MOUSE_RELEASED)
                    {
                        rectangle.setFill(Color.valueOf(clrSelect));
                        rectangle = new Rectangle(0,0,0,0);
                        rectangle.setVisible(false);
                        rectangle.setFill(Color.WHITE);
                        rectangle.setStroke(Color.BLACK);
                    }
                }
                //For Circle
                else if (shapeSelect.equals("Circle"))
                {
                    //Use initial click to add object to shapeList & get coordinates
                    if(event.getEventType() == MouseEvent.MOUSE_PRESSED)
                    {
                        shapeList.add(circle);
                        int track = 0;
                        for (int i = 0; i < shapeList.size();i++)
                        {
                        track = i;
                        }
                        canvas.getChildren().add(shapeList.get(track));
                        circle.setVisible(true);
                        circle.setCenterX(event.getX());
                        circle.setCenterY(event.getY());
                    }
                    if(event.getEventType() == MouseEvent.MOUSE_DRAGGED && circle.isVisible())
                    {
                        double x = Math.pow(event.getX() - circle.getCenterX(),2);
                        double y = Math.pow(event.getY() - circle.getCenterY(),2);
                        circle.setRadius(Math.sqrt(x + y));
                    }
                    if(event.getEventType() == MouseEvent.MOUSE_RELEASED)
                    {
                        circle.setFill(Color.valueOf(clrSelect));
                        circle = new Circle(0,0,0);
                        circle.setVisible(false);
                        circle.setFill(Color.WHITE);
                        circle.setStroke(Color.BLACK);
                    }
                }
            }
            catch (NullPointerException exception)
            {
                //Attempted to add a shape that wasn't selected
            }
        }//end handle()
    }//end MouseHandler

    //Handles Undo and Erase Buttons
    private class ButtonHandler implements EventHandler<ActionEvent>
    {
        @Override
        public void handle(ActionEvent event)
        {
            //Looking for OutOfBoundsException
            try {
                //Remove every added shape
                if(event.getSource() == erase)
                {
                    shapeList.clear();
                    canvas.getChildren().removeAll(shapeList);
                    canvas.getChildren().clear();
                    canvas.getChildren().addAll(shapeList);
                }
                //Remove last added shape if there are shapes
                else if(event.getSource() == undo && shapeList.size() > 0)
                {
                    shapeList.remove(shapeList.size() - 1);
                    canvas.getChildren().removeAll(shapeList);
                    canvas.getChildren().clear();
                    canvas.getChildren().addAll(shapeList);
                }
            }
            catch(ArrayIndexOutOfBoundsException exception)
            {
                //Attempted to remove shapes that aren't there yet
            }
          }
    }//end ButtonHandler

    //Handles Circle and Rectangle Radio Buttons
    private class ShapeHandler implements EventHandler<ActionEvent>
    {
        @Override
        public void handle(ActionEvent event)
        {
            //Check for circle
            if(event.getSource() == circlebtn)
            {
                shapeSelect = "Circle";
            }
            //Check for rectangle
            else if(event.getSource() == rectanglebtn)
            {
                shapeSelect = "Rectangle";
            }
        }
    }//end ShapeHandler

    //Handles Colors from ComboBox
    private class ColorHandler implements EventHandler<ActionEvent>
    {
        @Override
        public void handle(ActionEvent event)
        {
            clrSelect = (String) comboBox.getValue();
            clrSelect = clrSelect.toUpperCase();
        }
    }//end ColorHandler
}//end class DrawPane