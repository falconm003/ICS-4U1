import java.util.*;
public class sentencetranslator {
        public static void main(String[] args) {
            Scanner s = new Scanner(System.in);
            while(true) {
                System.out.println("\nEnter the sentence you would like to translate");
                String userInput = s.nextLine(); 
                System.out.print("\nIn pig latin: ");
                userInput = userInput.toLowerCase();
                String[] words = userInput.split("\\s+");
                int vowelIndex = 0;
                for(int ctr = 0; ctr < words.length; ctr++) {
                    for(int ctr2 = 0; ctr2 < words[ctr].length(); ctr2++) {
                        String temp = words[ctr].substring(ctr2, ctr2+1);
                        if (temp.equals("a") || temp.equals("e")
                        || temp.equals("i") || temp.equals("o")
                        || temp.equals("u") || temp.equals("q")) { // sniffing out vowels and q
                            vowelIndex = ctr2; // storing the index of the first vowel. For example: in hello, the index of the first vowel is 1. 
                            printWord(words[ctr], vowelIndex, temp);
                            break;
                        }
                    }
                }
                boolean isEnded = false;
                if (isEnded) {
                    s.close();
                    System.exit(1);
                    // the user can't actually end the program through scanner. I put this here so VSC would not annoy me about s.close(). 
                }
            }
        }
    public static void printWord(String word, int vowel, String temp) {
        if (!temp.equals("q")) {
            for (int ctr = vowel; ctr < word.length(); ctr++) {
                System.out.print(word.charAt(ctr)); // Printing the vowel and everything after. For example: hello = ello
            }
            for (int ctr = 0; ctr < vowel; ctr++) {
                System.out.print(word.charAt(ctr)); // Printing the letters up to, but not including the value. For example: hello = h
            }
            if (vowel == 0) {
                System.out.print("way "); // printing "way" if the word starts with a vowel
            } else {
                System.out.print("ay "); // else case
            }
        } else if (temp.equals("q")) {
            for(int ctr = vowel + 2; ctr < word.length(); ctr++) { // we add 2 to the for loop because we want to print everything after "qu" which is 2 digits.
                System.out.print(word.charAt(ctr));  
            }
            System.out.print("quay ");
        }
    } 
}