// Assignment #: 1
//         Name: Brandon Barrett
//    StudentID: 1203873172
//      Lecture: T/TH 4:30pm-5:45pm
//  Description: (1)This class reads an integer from a keyboard and prints it out
//               along with other messages.
//				 (2)The purpose of this assignment is let you be familiar with the assignments submission
//				 server. Make sure to modify the original program in such a way that your outputs match
//				 exactly the outputs we provided!

import java.util.Scanner;  // use the Scanner class located in the "java.util" directory

public class Assignment1 {
  public static void main (String[] args) {

     int number;

     Scanner console = new Scanner(System.in);

     number = console.nextInt();     // read an integer entered by a user

    // display the number with other messages
    System.out.print("This program reads an integer from a keyboard,\n"
                   + "and prints it out on the screen.\n"
                   + "The number is " + number + ".\n"
                   + "Make sure that you get the exact same output as the expected one.\n");
  }
}