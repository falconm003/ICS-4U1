// Matthew Falcone
// 2022-09-13
// 0d Converting a String into an Integer and Double
// Question 2
/* Write a Java program that would ask the user to input a decimal number, 
and store the value into a String variable.  The program would then convert 
the value in the String variable, and store it into a ((double)) variable, add 5 
to it, and print the result on the screen.   */
import java.util.*;
public class Main2 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.println("Input any number, whole or decimal."); // asking the user for a number
        double number = s.nextDouble();
        String convertedNumber = new String(); 

        convertedNumber = Double.toString(number); // converting user input into a string variable
        double newNumber = Double.parseDouble(convertedNumber); // converting the string back into a double, for some reason
        double finalDouble = newNumber + 5;
        System.out.println(finalDouble);
    }
}