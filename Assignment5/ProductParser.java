// Assignment #: 5
//         Name: Brandon
//    StudentID: 
//      Lecture: T/TH 4:30pm - 5:45pm
//  Description: The ProductParser class receives the input from Assignment5 class
//               and breaks up the input into small chunks and assigns them to variables.
//               These variables are then checked against the class they go to.
//               The object for that class is then created, the variables are passed and
//               the object is returned to productList in Assignment5 class.
//               

public class ProductParser 
{
    public static Product parseStringToProduct(String lineToParse) 
    {
        //Split up the lineToParse into Strings in an array
        String delims = "[/]";
        String variables[] = lineToParse.split(delims);
        
        //Check for Clothing
        if (variables[0].equals("Clothing"))
        {
            //Assign values to pass to Constructor for Clothing subclass
            String productId = variables[1];
            int quantity = Integer.parseInt(variables[2]);
            double unitPrice = Double.parseDouble(variables[3]);
            String size = variables[4];
            String color = variables[5];
            
            //Create Clothing subclass
            Clothing clothing = new Clothing(productId, quantity, unitPrice, size, color);
            
            //Return the Clothing subclass to the ArrayList in Assignment5
            return clothing;
        }
        
        //Check for Food
        else if (variables[0].equals("Food")) 
        {
            //Assign values to pass to Constructor for Food subclass
            String productId = variables[1];
            int quantity = Integer.parseInt(variables[2]);
            double unitPrice = Double.parseDouble(variables[3]);
            String name = variables[4];
            double damageRate = Double.parseDouble(variables[5]);
            String expirationDate = variables[6];
            
            //Create Food subclass
            Food food = new Food(productId, quantity, unitPrice, name, damageRate, expirationDate);
            
            //Return the Food subclass to the ArrayList in Assignment5
            return food;
        }
        
        //Default in case what is entered is invalid
        else
            return null;
    }
}
