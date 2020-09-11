// Assignment #: 5
//         Name: Brandon
//    StudentID: 
//      Lecture: T/TH 4:30pm - 5:45pm
//  Description: The Food class is a child of the Product class.
//               It holds the variables name, damageRate and expirationDate as
//               unique values. This class is called by ProductParser to create
//               objects for productList in Assignment5 class.
//               

import java.text.DecimalFormat;

public class Food extends Product
{
    //Declared private variables
    private String name;
    private double damageRate = 0.0;
    private String expirationDate = "08.20.2015";
    
    //Percentage formatter for Damage Rate
    private DecimalFormat percentage= new DecimalFormat("0.00%");
    
    //Constructor for Clothing, assigns class variables, sends other variables to parent class Product
    public Food(String pID, int qty, double uPrice, String nm, double dRate, String exDate)
    {
        //Invoking parent class product
        super(pID, qty, uPrice);
        name = nm;
        damageRate = dRate;
        expirationDate = exDate;
    }
    
    //Makes use of abstract method in Product to calculate totalCost
    public void computeTotalCost()
    {
        totalCost = (unitPrice*quantity) * (1+damageRate);
    }
    
    //Makes use of the toString() in the Product class to convey information
    public String toString()
    {
        return "\nFood:"
             + super.toString()
             + "Food Name:\t\t" + name+ "\n"
             + "Damage Rate:\t\t" + percentage.format(damageRate) + "\n"
             + "Expiration date:\t" + expirationDate + "\n\n";
    }
}
