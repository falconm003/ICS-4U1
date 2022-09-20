package translators;
import java.util.*;
public class wordtranslator {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.println("Enter the word you would like to translate");
        String userInput = s.nextLine(); 

        int vowelIndex = 0;

        for (int ctr = 0; ctr < userInput.length(); ctr++) {
            String temp = userInput.substring(ctr, ctr+1);
            if (temp.equals("a") || temp.equals("e")
            || temp.equals("i") || temp.equals("o")
            || temp.equals("u")) { // sniffing out vowels
                vowelIndex = ctr; // storing the index of the first vowel. For example: in hello, the index of the first vowel is 1. 
                break;
            } else if (temp.equals("q")) { // sniffing out q
                vowelIndex = ctr;
                for(int ctr2 = vowelIndex + 2; ctr2 < userInput.length(); ctr2++) { // we add 2 to the for loop because we want to print everything after "qu" which is 2 digits. 
                    System.out.print(userInput.charAt(ctr2));
                }
                System.out.print("quay");
                System.exit(1);
            }
        }
        for (int ctr = vowelIndex; ctr < userInput.length(); ctr++) {
            System.out.print(userInput.charAt(ctr)); // Printing the vowel and everything after. For example: hello = ello
        }
        for (int ctr = 0; ctr < vowelIndex; ctr++) {
            System.out.print(userInput.charAt(ctr)); // Printing the letters up to, but not including the value. For example: hello = h
        }
        if (vowelIndex == 0) {
            System.out.println("way"); // printing "way" if the word starts with a vowel
        } else {
            System.out.print("ay"); // else case
        }
        s.close();
    } 
}