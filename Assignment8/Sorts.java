// Assignment #: Arizona State University CSE205 #8
//         Name: Brandon
//    StudentID: 
//      Lecture: T/TH 4:30 - 5:45pm
//  Description: This class sorts foodList using the Comparator classes
//               for IdComparator and CategAndNameComparator.

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Sorts
{
    public static void sort(ArrayList<Food> foodList, Comparator<Food> xComparator)
    {
        Collections.sort(foodList, xComparator);
    }
}