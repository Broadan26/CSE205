// Assignment #: Arizona State University CSE205 #8
//         Name: Brandon
//    StudentID: 
//      Lecture: T/TH 4:30 - 5:45pm
//  Description: The Assignment 8 class displays a menu of choices to a user
//               and performs the chosen task. It will keep asking a user to
//               enter the next choice until the choice of 'Q' (Quit) is
//               entered.

import java.io.*;
import java.util.*;

public class Assignment8
{
    public static void main (String[] args)
    {
        char input1;
        String category, name, idStr;
        int id;
        boolean operation = false;
        int operation2 = 0;
        String line;
        String filename;

        // create a GroceryStore object. This is used throughout this class.
        GroceryStore store1 = new GroceryStore();

        try
        {
            // print out the menu
            printMenu();

            // create a BufferedReader object to read input from a keyboard
            InputStreamReader isr = new InputStreamReader (System.in);
            BufferedReader stdin = new BufferedReader (isr);

            do
            {
                System.out.print("What action would you like to perform?\n");
                line = stdin.readLine().trim();  //read a line
                input1 = line.charAt(0);
                input1 = Character.toUpperCase(input1);

                if (line.length() == 1)          //check if a user entered only one character
                {
                    switch (input1)
                    {
                    case 'A':   //Add Food
                        try
                        {
                            System.out.print("Please enter the food category to add:\n");
                            category = stdin.readLine().trim();
                            System.out.print("Please enter the food's name to add:\n");
                            name = stdin.readLine().trim();
                            System.out.print("Please enter the food ID to add:\n");
                            idStr = stdin.readLine().trim();
                            id = Integer.parseInt(idStr);

                            operation = store1.addFoodById(category, name, id);
                            if (operation == true)
                                System.out.print("Food added\n");
                            else
                                System.out.print("Food exists\n");
                        }
                        catch(NumberFormatException e)
                        {
                            System.out.print("Food Id is not entered as integer. Food not added\n");
                        }
                        break;
                        
                    case 'D':  //Search by Food ID
                        try
                        {
                            System.out.print("Please enter a food id to search:\n");
                            idStr = stdin.readLine().trim();
                            id = Integer.parseInt(idStr);
                            operation2=store1.idExists(id);

                            if (operation2 > -1)
                                System.out.print("Food found\n");
                            else
                                System.out.print("Food not found\n");
                        }
                        catch(NumberFormatException e)
                        {
                            System.out.print("Food Id is not entered as integer. Food not added\n");
                        }
                        break;
                        
                    case 'C':  //Search by Category and Name
                        System.out.print("Please enter a food category to search:\n");
                        category = stdin.readLine().trim();
                        System.out.print("Please enter a food name to search:\n");
                        name = stdin.readLine().trim();
                        operation2=store1.categAndNameExists(category, name);

                        if (operation2 > -1)
                            System.out.print("category and name found\n");
                        else
                            System.out.print("category and name not found\n");
                        break;
                        
                    case 'L':   //List all foods
                        System.out.print(store1.listFood());
                        break;
                        
                    case 'O':  // Sort by food ID
                        store1.sortById();
                        System.out.print("sorted by id\n");
                        break;
                        
                    case 'P':  // Sort by categories and names
                        store1.sortByCategAndName();
                        System.out.print("sorted by categories and names\n");
                        break;
                        
                    case 'Q':   //Quit
                        break;
                        
                    case 'R':  //Remove by ID
                        try
                        {
                            System.out.print("Please enter a food ID to remove:\n");
                            idStr = stdin.readLine().trim();
                            id = Integer.parseInt(idStr);
                            operation = store1.removeById(id);

                            if (operation == true)
                                System.out.print("ID removed\n");
                            else
                                System.out.print("ID not found\n");
                        }
                        catch(NumberFormatException e)
                        {
                            System.out.print("Food Id is not entered as integer. Food not added\n");
                        }
                        break;
                        
                    case 'S':  //Remove by category and name
                        System.out.print("Please enter a category to remove:\n");
                        category = stdin.readLine().trim();
                        System.out.print("Please enter a name to remove:\n");
                        name = stdin.readLine().trim();
                        operation=store1.removeByCategAndName(category, name);

                        if (operation == true)
                            System.out.print("category and name removed\n");
                        else
                            System.out.print("category and name not found\n");
                        break;
                        
                    case 'T':  //Close GroceryStore
                        store1.closeGroceryStore();
                        System.out.print("Grocery store closed\n");
                        break;
                        
                    case 'U':  //Write Text to a File
                        System.out.print("Please enter a file name to write:\n");
                        filename = stdin.readLine().trim();
                        System.out.print("Please enter a string to write in the file:\n");
                        String inputStr = stdin.readLine().trim();
                        PrintWriter writer = null;
                        try
                        {
                            writer = new PrintWriter(new BufferedWriter(new FileWriter(filename)));
                            writer.println(inputStr);
                        }
                        catch(IOException exception)
                        {
                            System.out.print("Text file written exception\n");
                        }
                        finally
                        {
                            writer.flush();
                            writer.close();
                        }
                        System.out.print(filename + " was written\n");
                        break;
                        
                    case 'V':  //Read Text from a File
                        System.out.print("Please enter a file name to read:\n");
                        filename = stdin.readLine().trim();
                        BufferedReader reader = null;
                        try
                        {
                            reader = new BufferedReader(new FileReader(filename));
                            String empty = null;
                            System.out.print(filename + " was read\n");
                            while((empty = reader.readLine()) != null)
                            {
                                System.out.print("The first line of the file is:\n" + empty +"\n");
                            }
                        }
                        catch (FileNotFoundException e)
                        {
                            System.out.print(filename + " was not found\n");
                        }
                        finally
                        {
                            reader.close();
                        }
                        break;
               
                    case 'W':  //Serialize GroceryStore to a File
                        System.out.print("Please enter a file name to write:\n");
                        filename = stdin.readLine().trim();
                        ObjectOutputStream writer2 = null;
                        try
                        {
                            writer2 = new ObjectOutputStream(new FileOutputStream(filename));
                            writer2.writeObject(store1);
                            writer2.close();
                            System.out.print(filename + " was written\n");
                        }
                        catch (NotSerializableException exception)
                        {
                            System.out.print("Data file written exception");
                        }
                        catch (IOException exception)
                        {
                            System.out.print("Data file written exception");
                        }
                        break;
                        
                    case 'X':  //Deserialize GroceryStore object from a File
                        System.out.print("Please enter a file name to read:\n");
                        filename = stdin.readLine().trim();
                        ObjectInputStream reader2 = null;
                        try
                        {
                            reader2 = new ObjectInputStream(new FileInputStream(filename));
                            store1 = (GroceryStore) reader2.readObject();
                            reader2.close();
                            System.out.println(filename + " was read");
                        }
                        catch (ClassNotFoundException exception)
                        {
                            System.out.print("Class not found exception\n");
                        }
                        catch (NotSerializableException exception)
                        {
                            System.out.print("Not serializable exception\n");
                        }
                        catch (IOException exception)
                        {
                            System.out.print("Data file read exception\n");
                        }
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
            } while (input1 != 'Q' || line.length() != 1);
        }
        catch (IOException exception)
        {
            System.out.print("IO Exception\n");
        }
    }

  /** The method printMenu displays the menu to a user **/
  public static void printMenu()
    {
        System.out.print("Choice\t\tAction\n" +
                        "------\t\t------\n" +
                        "A\t\tAdd Food\n" +
                        "D\t\tSearch food by ID\n" +
                        "C\t\tSearch food by Category and Name\n" +
                        "L\t\tList Food\n" +
                        "O\t\tSort Food by ID\n" +
                        "P\t\tSort Food by Category and Name\n" +
                        "Q\t\tQuit\n" +
                        "R\t\tRemove Food by ID\n" +
                        "S\t\tRemove Food by Category and Name\n" +
                        "T\t\tClose Grocery Store\n" +
                        "U\t\tWrite Text to File\n" +
                        "V\t\tRead Text from File\n" +
                        "W\t\tSerialize GroceryStore to File\n" +
                        "X\t\tDeserialize GroceryStore from File\n" +
                        "?\t\tDisplay Help\n\n");
    }
} // end of Assignment8 class