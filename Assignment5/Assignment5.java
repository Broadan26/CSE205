// Assignment #: 5
//         Name: Brandon
//    StudentID: 
//      Lecture: T/TH 4:30pm - 5:45pm
//  Description: The Assignment 5 class displays a menu of choices
//               (add a product, compute the total cost, search a product, list product,
//               quit, display menu) to a user.
//               Then it performs the chosen task. It will keep asking a user to
//               enter the next choice until the choice of 'Q' (Quit) is
//               entered.

import java.io.*;         //to use InputStreamReader and BufferedReader
import java.util.*;       //to use ArrayList

public class Assignment5
{
   public static void main (String[] args)
   {
      char input1;
      String inputInfo = new String();
      String line = new String();
      boolean found = false;

     // ArrayList object is used to store drink objects
      ArrayList<Product> productList = new ArrayList<Product>();

      try
      {
         printMenu();     // print out menu

       // Create a BufferedReader object to read input from a keyboard
         InputStreamReader isr = new InputStreamReader (System.in);
         BufferedReader stdin = new BufferedReader (isr);

         do
         {
            System.out.print("What action would you like to perform?\n");
            line = stdin.readLine().trim();
            input1 = line.charAt(0);
            input1 = Character.toUpperCase(input1);

            if (line.length() == 1)
            {
               switch (input1)
               {
                  case 'A':   //Add Product
                     System.out.print("Please enter a product information to add:\n");
                     inputInfo = stdin.readLine().trim();
                     
                     //Creates an object from a child class and adds it to the productList ArrayList
                     Product p = ProductParser.parseStringToProduct(inputInfo);
                     productList.add(p);

                     break;

                  case 'C':   //Compute Total Costs
                      
                      //Runs productList to compute the total cost of all the objects in the list
                     for (int i = 0; i < productList.size(); i++)
                     {
                        productList.get(i).computeTotalCost();
                     }
                     System.out.println("total costs computed");
                     break;

                  case 'S':   //Search for a product
                     System.out.print("Please enter a productId to search:\n");
                     inputInfo = stdin.readLine().trim();
                     
                     //Searches productList for the productId and checks it against the input
                     for (int i = 0; i < productList.size(); i++) 
                     {
                         if (productList.get(i).getProductId().equals(inputInfo)) 
                         {
                             found = true;
                             break;
                         }
                         else
                             found = false;
                     }
                     
                     //Check if found is true to return product being found        
                     if (found == true)
                     {
                         System.out.print("product found\n");
                     }
                     else 
                        System.out.print("product not found\n");
                     break;

                  case 'L':   //List Products
                      
                      //Prints all the product objects in productList or returns no product if empty
                     if (productList.size() > 0) 
                     {
                        for (int i = 0; i < productList.size(); i++) 
                        {
                           System.out.print(productList.get(i).toString());
                        }
                     }
                     else
                         System.out.print("no product\n");
                     
                     break;

                  case 'Q':   //Quit
                     break;
                  case '?':   //Display Menu
                     printMenu();
                     break;
                  default:
                     System.out.print("Unknown action\n");
                     break;
               }
            }
            else
            {
               System.out.print("Unknown action\n");
            }
         } while (input1 != 'Q'); // stop the loop when Q is read
      }
      catch (IOException exception)
      {
         System.out.println("IO Exception");
      }
   }

  /** The method printMenu displays the menu to a use **/
   public static void printMenu()
   {
      System.out.print("Choice\t\tAction\n" +
                      "------\t\t------\n" +
                      "A\t\tAdd Product\n" +
                      "C\t\tCompute Total Costs\n" +
                      "S\t\tSearch for Product\n" +
                      "L\t\tList Products\n" +
                      "Q\t\tQuit\n" +
                      "?\t\tDisplay Help\n\n");
   }
}

