import java.util.*;
public class splitTest {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        String userInput = s.nextLine();
        String[] words = userInput.split("\\s+");
        for (int ctr = 0; ctr < words.length; ctr++) {
            String sentence = "";
            sentence = sentence + words[ctr];
            System.out.print(sentence + " ");
        } 
        s.close();
    }
}
