// Assignment #: 4
// Name        : Brandon
// StudentID   : 
// Lecture     : T/TH 4:30pm - 5:45pm
// Description : Laptop class uses a combination of mutators and accessor
//               methods to set the attributes for Brand Name, Model and price.
//               It also calls upon the Model class for additional information
//               and makes changes to it.

import java.text.DecimalFormat;

public class Laptop 
{
    //Creation of class global variables
    private String brandName;
    private Model model = new Model();
    private double price = 0.0;
    
    //Currency Formatter for price
    private DecimalFormat currency= new DecimalFormat("$0.00");
    
    //Constructor method
    public Laptop()
    {
        
    }
    //Get the brand name
    public String getBrand()
    {
        return brandName;
    }
    //Set a new brand name
    public void setBrand(String newBrand)
    {
        brandName = newBrand;
    }
    //Get the model information from Model class
    public Model getModel()
    {
        return model;
    }
    //Set the model information for Model class
    public void setModel(String newModel, double newCPU, int newRAM)
    {
        model.setModel(newModel);
        model.setCPU(newCPU);
        model.setRam(newRAM);
    }
    //Get the price for the laptop
    public double getPrice()
    {
        return price;
    }
    //Set the price for the laptop
    public void setPrice(double newPrice)
    {
        price = newPrice;
    }
    //Return the information about the laptop to Assignment4 Class
    public String toString()
    {
        return "\nBrand:\t" + brandName + "\n"
             + model.toString()
             + "Price:\t" + currency.format(price) + "\n\n";
    }
}