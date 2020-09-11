// Assignment #: Arizona State University CSE205 #8
//         Name: Brandon
//    StudentID: 
//      Lecture: T/TH 4:30 - 5:45pm
//  Description: This class compares the Category Type in Food objects.

import java.util.Comparator;

public class CategAndNameComparator implements Comparator<Food>
{
    @Override
    public int compare(Food x, Food y)
    {
        int equality;
        //Compare Categories of Food items
        if(x.getCategory().compareTo(y.getCategory()) < 0)
            equality = -1;
        else if (x.getCategory().compareTo(y.getCategory()) > 0)
            equality = 1;
        //If Categories are the same compare Names
        else
        {
            if(x.getName().compareTo(y.getName()) < 0)
                equality = -1;
            else if (x.getName().compareTo(y.getName()) > 0)
                equality = 1;
            else
                equality = 0;
        }
        return equality;
    }
}