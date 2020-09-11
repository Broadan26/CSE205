// Assignment #: Arizona State University CSE205 #8
//         Name: Brandon
//    StudentID: 
//      Lecture: T/TH 4:30 - 5:45pm
//  Description: This class compares the ProductId in Food objects.

import java.util.Comparator;

public class IdComparator implements Comparator<Food>
{
    @Override
    public int compare(Food x, Food y)
    {
        int equality;
        //Compare Id numbers of Food objects
        if(x.getId() < y.getId())
            equality = -1;
        else if (x.getId() > y.getId())
            equality = 1;
        else
            equality = 0;
        return equality;
    }
}