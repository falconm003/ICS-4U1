package translators;
import java.io.*;
import java.util.*;
public class filetranslator {
  public static void main(String[] args) throws IOException {
    String finalWord = new String();
    String placeholder = new String();
    Scanner s = new Scanner(System.in);
    Scanner lineIn = null;
    Scanner lineIn2 = null;
    File inputFile = null;
    boolean noErrors = false;
    String checkForChange = new String();
    do {
      try {
        lineIn = new Scanner(new FileReader("input.txt"));
        lineIn2 = new Scanner(new FileReader("input.txt"));
        checkForChange = lineIn2.nextLine();
        noErrors = true;
        break;
      } catch (FileNotFoundException e) {
        //e.printStackTrace();
        System.out.println("Error: input.txt does not exist");
        System.out.println("Generate? (Y)");
        String userResponse = s.nextLine();
        if (userResponse.equals("Y")) {
          inputFile = new File("input.txt");
          if(inputFile.createNewFile()) {
            System.out.println("File Created. exiting");
            System.exit(1);
          }
        }
      } catch (NoSuchElementException e) {
        System.out.println("input.txt is blank." + checkForChange);
        System.exit(1);
      }
    } while (noErrors);
    while (lineIn.hasNextLine()) {
      String userInput = lineIn.nextLine();
      String[] words = userInput.split("\\s+");
      int vowelIndex = 0;
      for (int ctr = 0; ctr < words.length; ctr++) {
        for (int ctr2 = 0; ctr2 < words[ctr].length(); ctr2++) {
          String temp = words[ctr].substring(ctr2, ctr2 + 1);
          if (temp.equals("a") || temp.equals("e")
              || temp.equals("i") || temp.equals("o")
              || temp.equals("u") || temp.equals("q")) { 
            vowelIndex = ctr2;
            finalWord = printWord(words[ctr], vowelIndex, temp);
            placeholder = placeholder.concat(finalWord);
            break;
          }
        }
      }
      toTextFile(placeholder);
      s.close();
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
    System.exit(0);
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
      for (int ctr = vowel + 2; ctr < word.length(); ctr++) {
        placeholder = String.valueOf(word.charAt(ctr));
        finalWord = finalWord.concat(placeholder);
      }
      finalWord = finalWord.concat("quay ");
    }
    return finalWord;
  }
}