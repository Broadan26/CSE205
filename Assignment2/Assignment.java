// Assignment #: 2
// Name        : Brandon
// StudentID   : 
// Lecture     : T/TH 4:30-5:45pm Das
// Description : This program uses a single while loop that will run until the user inputs 0.
//               Each input will be tested for...
//                  1. The minimum value
//                  2. The sum of positive integers that are also even
//                  3. The total number of negative integers
//                  4. The sum of numbers that are divisible by 3
//               And then everything is printed at the bottom

import static java.lang.Integer.MAX_VALUE;
import java.util.Scanner;

public class Assignment2 
{
    public static void main(String[]args) 
    {
        //Local Variable Declaration
        int input = -1; int minValue = MAX_VALUE;
        int divisibleThree = 0; int countNeg = 0;
        int sumPos = 0;
        
        //Scanner setup
        Scanner console = new Scanner(System.in);
        
        while (input != 0) 
        {
            //Read the value from the user
            input = console.nextInt();

            //Set the minimum value
            if (input < minValue) 
            {
                minValue = input;
            }

            //Sum of Numbers Divisible by 3
            if (input % 3 == 0) 
            {
                divisibleThree = input + divisibleThree;
            }

            //Count of Negative Integers
            if (input < 0) 
            {
                countNeg++;
            }
            
            //Sum of Positive Even Integers
            if (input > 0 && input % 2 == 0) 
            {
                sumPos = input + sumPos;
            }
        }
        
        //Print out that gobbly gook above
        System.out.print("The minimum integer is " + minValue + "\n"
                       + "The sum of positive even integers is " + sumPos + "\n"
                       + "The count of negative integers is " + countNeg + "\n"
                       + "The sum of numbers divisible by 3 is " + divisibleThree + "\n");
    }
}
