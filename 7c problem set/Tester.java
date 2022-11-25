
import java.util.*;
import java.io.*;
public class Tester {
    private static void printMenu() {
        System.out.println("\nSelect an option.");
        System.out.println("1) Change title of a book" 
                            + "\n2) Change ISBN number of a book"
                            + "\n3) Change borrower name"
                            + "\n4) Change book author"
                            + "\n5) Search for book by title and get info"
                            + "\n\ntype Exit to save and quit");
    }
    private static void dataInput(Books[] book) throws IOException {
        Scanner lineIn = new Scanner(new FileReader("books.txt"));
        for(int ctr = 0; ctr < book.length; ctr++) {
            String[] sortedInput = (lineIn.nextLine()).split(", ");
            book[ctr] = new Books(sortedInput[0], sortedInput[1], sortedInput[2], sortedInput[3]);
        }
        lineIn.close();
    }
    private static void dataOutput(Books[] book) throws IOException {
        PrintWriter lineOut = new PrintWriter(new BufferedWriter(new FileWriter("books.txt")));
        for(int ctr = 0; ctr < book.length; ctr++) {
            lineOut.println(book[ctr].getTitle() + ", " + book[ctr].getISBN() + ", " + book[ctr].getBorrower() + ", " + book[ctr].getAuthor());
        }
        lineOut.close();
    }
    public static void main(String[] args) throws InterruptedException, IOException {
        Scanner s = new Scanner(System.in);
        Books[] book = new Books[5];
        dataInput(book);

        modifierClass modifier = new modifierClass();
        
        boolean exit = false;
        System.out.println("Welcome to the Library!");
        do {
            printMenu();
            exit = modifier.modify(book, s.nextLine());
        } while(!exit);
        dataOutput(book);
        s.close();
    }

}
