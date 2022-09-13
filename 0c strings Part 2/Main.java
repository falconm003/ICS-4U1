// 2022-09-12
// Matthew Falcone
// 0c Strings Part 2 - Question 3
/* The company is worried about security. They made an agreement
 * with the users such that they will enter a password that is of 
 * random length when they try to access the system. However, the user
 * has to make sure that the acutal password is typed between character
 * 5 and 10. This password will then be extracted from the longer 
 * "password" and compared with the system preset password to gain entry.
 */

 // master password is "tester"


import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        String masterPassword = "tester";
        System.out.println("Enter your password");
        String userPassword = s.nextLine();

        if (userPassword.regionMatches(false, 5, masterPassword, 0, 6)) {
            System.out.println("Correct");
        } else {
            System.out.println("Incorrect");
        }
    }
}