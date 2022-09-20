import java.io.*;
import java.util.*;
public class filetranslator {
        public static void main(String[] args) throws IOException {
            String finalWord = new String();
            String placeholder = new String();
            Scanner lineIn = new Scanner (new FileReader("input.txt"));
            while(lineIn.hasNextLine()) {
                String userInput = lineIn.nextLine(); 
                String[] words = userInput.split("\\s+");
                int vowelIndex = 0;
                for(int ctr = 0; ctr < words.length; ctr++) {
                    for(int ctr2 = 0; ctr2 < words[ctr].length(); ctr2++) {
                        String temp = words[ctr].substring(ctr2, ctr2+1);
                        if (temp.equals("a") || temp.equals("e")
                        || temp.equals("i") || temp.equals("o")
                        || temp.equals("u") || temp.equals("q")) { // sniffing out vowels and q
                            vowelIndex = ctr2; // storing the index of the first vowel. For example: in hello, the index of the first vowel is 1. 
                            finalWord = printWord(words[ctr], vowelIndex, temp);
                            placeholder = placeholder.concat(finalWord);
                            break;
                        }
                    } 
                }
                toTextFile(placeholder);
            }
        }
    public static void toTextFile(String word) {
        PrintWriter writer = null;
        try {
            writer = new PrintWriter("output.txt");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        System.out.println("check output.txt");
        writer.print(word);
        writer.close();
    }
    
    public static String printWord(String word, int vowel, String temp) {
       String finalWord = new String();
       String placeholder = new String();
       
        if (!temp.equals("q")) {
            for (int ctr = vowel; ctr < word.length(); ctr++) {
                placeholder = String.valueOf(word.charAt(ctr));
                finalWord = finalWord.concat(placeholder);
            }
            for (int ctr = 0; ctr < vowel; ctr++) {
                placeholder = String.valueOf(word.charAt(ctr)); 
                finalWord = finalWord.concat(placeholder);
            }
            if (vowel == 0) {
                finalWord = finalWord.concat("way "); 
            } else {
                finalWord = finalWord.concat("ay "); 
            }
        } else if (temp.equals("q")) {
            for(int ctr = vowel + 2; ctr < word.length(); ctr++) { 
                placeholder = String.valueOf(word.charAt(ctr));
                finalWord = finalWord.concat(placeholder);  
            }
            finalWord = finalWord.concat("quay ");
        }
        return finalWord;
    } 
}