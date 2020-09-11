// Assignment #: 5
//         Name: Brandon
//    StudentID: 
//      Lecture: T/TH 4:30pm - 5:45pm
//  Description: The Clothing class is a child of the Product class.
//               It holds the variables size and color as unique values
//               This class is called by ProductParser to create objects for
//               productList in Assignment5 class.
//               

public class Clothing extends Product
{
    //Declared private variables
    private String size;
    private String color;
    
    //Constructor for Clothing, assigns class variables, sends other variables to parent class Product
    public Clothing(String pID, int qty, double uPrice, String sz, String clr)
    {
        //Invoking parent class Product
        super(pID, qty, uPrice);
        size = sz;
        color = clr;
    }
    
    //Makes use of abstract method in Product to calculate totalCost
    public void computeTotalCost()
    {
        totalCost = unitPrice * quantity;
    }
    
    //Makes use of the toString() in the Product class to convey information
    public String toString()
    {
        return "\nClothing:"
             + super.toString()
             + "Size:\t\t\t" + size + "\n"
             + "Color:\t\t\t" + color + "\n\n";
    }
}
