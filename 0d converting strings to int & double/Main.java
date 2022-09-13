// Matthew Falcone
// 2022-09-13
// 0d Converting a String into an Integer and Double
// Question 1
/* Write a Java program that would ask the user to input a whole number, and store the value into a String variable.  
The program would then convert the value in the String variable, and store it into an integer variable, add 5 to it, 
and print the result on the screen. */
import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.println("Input a whole number."); // asking user for a whole number
        int wholeNumber = s.nextInt();
        String convertedWholeNumber = new String(); 

        convertedWholeNumber = Integer.toString(wholeNumber); // converting user input into a string variable
        int newWholeNumber = Integer.parseInt(convertedWholeNumber); // converting the string back into an int, for some reason
        int finalInt = newWholeNumber + 5;
        System.out.println(finalInt);
    }
}