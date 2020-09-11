// Assignment #: Arizona State University CSE205 #8
//         Name: Brandon
//    StudentID: 
//      Lecture: T/TH 4:30 - 5:45pm
//  Description: This class defines Food objects in foodList ArrayList

import java.io.Serializable;

public class Food implements Serializable
{
    private String category;
    private String name;
    private int id;

    //constructor
    public Food(String nCategory, String nName, int nId)
    {
	category = nCategory;
        name = nName;
        id = nId;
    }

    //accessors & mutators
    public String getCategory()
    {
        return category;
    }

    public void setCategory(String nCategory)
    {
	category = nCategory;
    }

    public String getName()
    {
	return name;
    }

    public void setName(String nName)
    {
	name = nName;
    }

    public int getId()
    {
        return id;
    }

    public void setId(int nId)
    {
	id = nId;
    }

    public String toString()
    {
        return "Category: " + category + "\t\tName: " + name + "\t\tID: " + id + "\n";
    }
}