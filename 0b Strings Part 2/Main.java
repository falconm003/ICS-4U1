// 2022-09-12
// Matthew Falcone
// 0b Strings Part 2 - Other Methods Question 1
import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        String thing = "Lard";
        do {
            System.out.println("Enter a string that is 50 characters long.");
            thing = s.nextLine();
        } while (thing.length() != 50);

        String output = "Lard";
        
        // First time "c" occurred
        output = "c is located at index " + thing.indexOf("c");
        System.out.println(output);
        // First time "ing" occurred
        output = "ing is located at index " + thing.indexOf ("ing");
        System.out.println(output);
        // Last time "w" occurred
        output = "w is last located at " + thing.lastIndexOf("w");
        System.out.println(output);
        // Characters from the beginning till index 5
        System.out.println("Characters from the beginning till index 5: ");
        for (int ctr = 0; ctr <= 4; ctr++) {
            System.out.print(thing.charAt(ctr));
        }
    }
}
// If you are here, fuck u