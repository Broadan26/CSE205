// Assignment #: 5
//         Name: Brandon
//    StudentID: 
//      Lecture: T/TH 4:30pm - 5:45pm
//  Description: The Product class is an abstract class and the parent class to
//               the Food and Clothing classes. It stores the variables for 
//               productId, quantity, and unitPrice for both children.
//               It uses the abstract method computeTotalCost() to run
//               calculations unique to each child class.
//               

import java.text.DecimalFormat;

public abstract class Product
{
    //Declare protected variables
    protected String productId = "?";
    protected int quantity = 0;
    protected double unitPrice = 0.0;
    protected double totalCost = 0.0;
    
    //Currency Formatter for cost and price
    private DecimalFormat currency = new DecimalFormat("$0.00");
    
    //Constructor for parent class Product, sets new variables
    public Product(String pID, int qty, double uPrice)
    {
        productId = pID;
        quantity = qty;
        unitPrice = uPrice;
    }
    
    //Returns productId when called
    public String getProductId()
    {
        return productId;
    }
    
    //Abstract method that forces computeTotalCost into subclasses
    public abstract void computeTotalCost();
    
    //Base toString() for child subclasses
    public String toString()
    {
        return "\nProduct ID:\t\t" + productId + "\n"
             + "Quantity:\t\t" + quantity + "\n"
             + "Unit Price:\t\t" + currency.format(unitPrice) + "\n"
             + "Total Cost:\t\t" + currency.format(totalCost) + "\n";
    }
}
