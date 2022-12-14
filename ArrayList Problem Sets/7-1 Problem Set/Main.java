import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws FileNotFoundException, InterruptedException {
        ArrayList<String> verb = new ArrayList<String>(1525);
        ArrayList<String> noun = new ArrayList<String>(1042);
        Random r = new Random();
        Scanner lineIn = new Scanner(new FileReader("noun.txt"));
        Scanner lineIn2 = new Scanner(new FileReader("verb.txt"));

        for(int ctr = 0; ctr < 1525; ctr++) {
            noun.add(ctr, lineIn.nextLine());
        }
        for(int ctr = 0; ctr < 1042; ctr++) {
            verb.add(ctr, lineIn2.nextLine());
        }
        while(true) {
            System.out.println("The " + noun.get(r.nextInt(noun.size())) + " " + verb.get(r.nextInt(verb.size())) + 
            " the " + noun.get(r.nextInt(noun.size())) + " with a " + noun.get(r.nextInt(noun.size())));
            Thread.sleep(1000);
        }
    }
}