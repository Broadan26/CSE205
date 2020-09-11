// Assignment #: Arizona State University CSE205 #8
//         Name: Brandon
//    StudentID: 
//      Lecture: T/TH 4:30 - 5:45pm
//  Description: This class is instantiated in the Main and handles every function related to the Food Objects.
//               This includes sorting, searching and returning data.
//               The class is serialized so that it can have information pulled from it and stored in local files.

import java.io.Serializable;
import java.util.ArrayList;

public class GroceryStore implements Serializable
{
    public ArrayList<Food> foodList;
    
    //Base constructor for GroceryStore, instantiates the ArrayList
    public GroceryStore()
    {
        foodList = new ArrayList<Food>();
    }
    
    //Searches for a Food object by Id and returns the index if found
    public int idExists(int x)
    {
        int index = -1;
        //Check if foodList is Empty first
        if(foodList.isEmpty() == true)
        {
            index = -1;
        }
        //Then check for existing Ids
        else
        {
            for(int i = 0; i < foodList.size(); i++)
            {
                if(foodList.get(i).getId() == x)
                {
                    index = i;
                    break;
                }
            }
        }
        return index;
    }
    
    //Compares the category and name input with those in food objects
    public int categAndNameExists(String category, String name)
    {
        int index = -1;
        //Check if foodList is empty first
        if(foodList.isEmpty() == true)
        {
            index = -1;
        }
        //Then check for existing categories and names
        else
        {
            for(int i = 0; i < foodList.size(); i++)
            {
                if(foodList.get(i).getCategory().equals(category) && foodList.get(i).getName().equals(name))
                {
                    index = i;
                    break;
                }
            }
        }
        return index;
    }
    
    //Compares added food information to information already in foodList
    //If the information is not a duplicate, it will add it as a new food object
    public boolean addFoodById(String category, String name, int id)
    {
        boolean check;
        if(idExists(id) != -1 && categAndNameExists(category, name) != -1)
        {
            check = false;
        }
        else
        {
            foodList.add(new Food(category, name, id));
            check = true;
        }
        return check;
    }
    
    //Checks if a food item exists by ID and removes it if it exists
    public boolean removeById(int id)
    {
        boolean check;
        int idExists = idExists(id);
        if(idExists != -1)
        {
            foodList.remove(idExists);
            check = true;
        }
        else
        {
            check = false;
        }
        return check;
    }
    
    //Checks if a food item exists by Category and Name.
    //Removes the food item if it exists.
    public boolean removeByCategAndName(String category, String name)
    {
        boolean check;
        int catAndNameExist = categAndNameExists(category, name);
        if(catAndNameExist != -1)
        {
            foodList.remove(catAndNameExist);
            check = true;
        }
        else
        {
            check = false;
        }
        return check;
    }
    
    //Sorts foodList objects by Category and Name.
    public void sortByCategAndName()
    {
        Sorts.sort(foodList, new CategAndNameComparator());
    }
    
    //Sorts foodList objects by ID
    public void sortById()
    {
        Sorts.sort(foodList,new IdComparator());
    }
    
    //Lists all food objects in foodList as a concatenation
    //If foodList is empty, returns "No Food"
    public String listFood()
    {
        String check = "";
        if(foodList.isEmpty())
            check = "\nNo Food\n\n";
        else
        {
            for(int i = 0; i < foodList.size(); i++)
            {
                check = check + foodList.get(i).toString();
            }
        }
        return check;
    }
    
    //Clears foodList
    public void closeGroceryStore()
    {
        foodList.clear();
    }
}