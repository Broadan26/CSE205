// Assignment #: ASU CSE205 Assignment #9
//         Name: Brandon
//    StudentID: 
//      Lecture: T/TH 4:30 - 5:45pm
//  Description: This program reads in a sequence of numbers from standard
//  input until 0 is read and stores the numbers in an array, it then
//  compute the largest number, the count of even numbers (includes both postive and negative),
//  the number of -1 inside the array, and also compute the sum of numbers at
//  odd indexes (i.e. 0, 2, 4, ...), using recursion.

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Assignment9
{
    public static void main (String[] args) throws IOException
    {
        //Input value for the StreamReader
        String inputInfo = new String();
        
        //Create the StreamReader
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        
        //String array for the StreamReader
        String holder[] = new String[1];
        int count = 0;
        
        //Receive user inputs and add them to String array via StreamReader
        do {
            
            //Resize the array based on input runs, starting at size 1
            if (count > 0)
                holder = Arrays.copyOf(holder, holder.length + 1);
            
            //Add input info to the array & increase count
            inputInfo = reader.readLine().trim();
            holder[count] = inputInfo;
            count++;
            
        } while (!inputInfo.equals("0"));
        
        //Copy values from String array to int array
        int numbers[] = new int[holder.length];
        
        //Check for a NumberFormatException when converting values
        try {
            for (int i = 0; i < holder.length; i++)
            {
                numbers[i] = Integer.parseInt(holder[i]);
            }
        }
        catch(NumberFormatException e) 
        {
            System.out.println("NumberFormatException occurred");
        }
        
        //Call recursive methods after int array is filled & print results
        System.out.println("The largest number is " + findMax(numbers, 0, numbers.length - 1));
        System.out.println("The total number of even integers is " + countEven(numbers, 0, numbers.length - 1));
        System.out.println("The total number of -1 is " + countNegativeOne(numbers, numbers.length - 1));
        System.out.println("The sum of numbers at odd indexes is " + computeSumAtOddIndexes(numbers, numbers.length - 1));
    }
    
    //Finds the largest number in the array numbers via recursion
    //Uses the location in the array at numbers[startIndex] to search the array
    public static int findMax(int[ ] numbers, int startIndex, int endIndex)
    {
        if (startIndex == endIndex)
            return numbers[startIndex];
        else
            return Math.max(numbers[startIndex], findMax(numbers, startIndex+1, endIndex));
    }

    //Finds the number of even integers in the array numbers via recursion
    //Uses the location in the array at numbers[startIndex] to search the array
    public static int countEven(int[ ] numbers, int startIndex, int endIndex)
    {
        int count = 0;
        if(startIndex < endIndex)
        {
            count = count + countEven(numbers, startIndex + 1, endIndex);
            if(numbers[startIndex] % 2 == 0)
                count++;
        }
        return count;
    }
    
    //Finds the number of times the value "-1" appears in the array numbers via recursion
    //Uses the location in the array at numbers[count] to search the array
    public static int countNegativeOne(int[ ] numbers, int count)
    {
        int correct = 0;
        if (count >= 0)
        {
            correct = correct + countNegativeOne(numbers, count - 1);
            if (numbers[count] == -1)
                correct++;
        }        
        return correct;
    }

    //Finds the sum of every value at an odd index within the array numbers recursively
    //Uses the location in the array at numbers[count] to traverse the array
    public static int computeSumAtOddIndexes(int[ ] numbers, int count)
    {
        int sum = 0;
        if (count >= 0)
        {
            sum = sum + computeSumAtOddIndexes(numbers, count - 1);
            if(count % 2 != 0)
                sum = sum + numbers[count];
        }
        return sum;
    }

}// end of class Assignment9
