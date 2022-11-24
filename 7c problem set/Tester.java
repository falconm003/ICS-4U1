import java.util.*;
public class Tester {
    public static void printMenu() {
        System.out.println("\nSelect an option.");
        System.out.println("1) Change title of a book" 
                            + "\n2) Change ISBN number of a book"
                            + "\n3) Change borrower name"
                            + "\n4) Change book author"
                            + "\n5) Search for book by title and get info");
    }
    public static void main(String[] args) throws InterruptedException {
        Scanner s = new Scanner(System.in);
        Books[] book = new Books[5];
        book[0] = new Books("Harry Potter", 193962, "Mark", "Jose");
        book[1] = new Books("Fight Club", 982970, "Anna", "Jeziah");
        book[2] = new Books("The Great Gatsby", 383621, "Joe", "Frankfurt");
        book[3] = new Books("To Kill a Mockingbird", 947789, "Dwayne", "Gerturde");
        book[4] = new Books("Harry Potter 2", 852245, "Bartholeus", "Demascus");

        modifierClass modifier = new modifierClass();
        
        System.out.println("Welcome to the Library!");
        do {
            printMenu();
            modifier.modify(book, s.nextInt());
        } while(true);
    }

}
