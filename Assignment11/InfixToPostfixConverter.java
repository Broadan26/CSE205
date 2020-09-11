// Assignment #: Arizona State University CSE205 #11
//         Name: Brandon
//    StudentID: 
//      Lecture: T/TH 4:30-5:45pm
//  Description: This is a utility class that provide a static method that
//		 takes an infix string, checked and determine if parentheses
//		 are matching, if matching, returns a postfix string.

import java.util.Stack;

public class InfixToPostfixConverter
{
    //The precedence method determines the precedence between two operators.
    //If the first operator is of higher or equal precedence than the second
    //operator, it returns true, otherwise it returns false.
    public static boolean precedence(char first, char second)
    {
        if(precedenceLevel(first) >= precedenceLevel(second))
            return true;
        else 
            return false;
    }
    
    //Helper method for checking precedence level of passed values, returns to precedence method
    public static int precedenceLevel(char value)
    {
        switch(value)
        {
            case '+':
            case '-':
                return 0;
            case '*':
            case '/':
                return 1;
            case '(':
                return -1;
            case ')':
                return -1;
            default:
                throw new IllegalArgumentException("Unknown Operator" + value);
        }
    }

    //The static convertToPostfix method will convert the infixString
    //into the corresponding postfix string.
    public static String convertToPostfix(String infixString)
    {
        //initialize the resulting postfix string
        String postfixString = "";

        //initialize the stack
        Stack<Character> stack1 = new Stack<Character>();

        //Obtain the character at index i in the string
        for (int i=0; i < infixString.length(); i++)
        {
            char currentChar = infixString.charAt(i);
            
            //Case A: If char is an operand, add it to the PostfixString
            if((currentChar >= 'A' && currentChar <= 'Z') || (currentChar >= 'a' && currentChar <= 'z'))
                postfixString = postfixString + currentChar;
                
            //Case B: If the char is a left parenthesis, push it on to the stack
            else if(currentChar == '(' )
                stack1.push(currentChar);

            //Case C: If the char is an operator & stack is empty, push char on to the stack
            else if(currentChar >= '*' && currentChar <= '/' && stack1.isEmpty() == true)
                stack1.push(currentChar);

            //Case D: If char is an operator and stack is not empty, compare precedence
            else if(currentChar >= '*' && currentChar <= '/' && stack1.isEmpty() == false)
            {
                while(stack1.isEmpty() == false && precedence(stack1.peek(), currentChar) == true)
                    postfixString = postfixString + stack1.pop();
                stack1.push(currentChar);
            }

            //Case E: If char is a right parenthesis and stack is not empty, pop everything out from the stack and append it to Postfix String
            else if(currentChar == ')')
            {
                if(currentChar == ')' && stack1.isEmpty() == true)
                    return "No matching open parenthesis error";
                
                while(stack1.isEmpty() == false && stack1.peek() != '(' )
                    postfixString = postfixString + stack1.pop();
                
                if(stack1.isEmpty() == true)
                    return "No matching open parenthesis error";
                else if (stack1.isEmpty() == false)
                    stack1.pop();
            }
        }

        //Case F: Add characters remaining in the stack to the postfixString except left parenthesis
        if(stack1.isEmpty() == false && stack1.peek() == '(')
            return "No matching close parenthesis error";
        else if(stack1.isEmpty() == false)
            while(stack1.isEmpty() == false && stack1.peek() != '(')
            {
                postfixString = postfixString + stack1.pop();
                if(stack1.isEmpty() == false && stack1.peek() == '(')
                    return "No matching close parenthesis error";
            }
        return "The Postfix Expression is: " + postfixString;
    }
}