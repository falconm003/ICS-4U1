import java.util.Scanner;
public class modifierClass {
    public void modify(Books[] book, int userInput) {
        if (userInput == 1) {
            changeTitle(book);
        } else if (userInput == 2) {
            changeISBN(book);
        } else if (userInput == 3) {
            changeBorrower(book);
        } else if (userInput == 4) {
            changeAuthor(book);
        } else if (userInput == 5) {
            searchBook(book);
        }
    }
    private void changeTitle(Books[] book) {
        Scanner s = new Scanner(System.in);
        System.out.println("\nSelect book.");
        printers.printTitle(book);
        int bookChoice = s.nextInt();
        s.nextLine();
        String oldBookTitle = book[bookChoice-1].getTitle();
        System.out.println("\nEnter new title.");
        book[(bookChoice-1)].setTitle(s.nextLine());
        System.out.println("Change confirmed. New title for \"" + oldBookTitle + "\" is: "+ book[(bookChoice-1)].getTitle());
        s.close();
    }
    private void changeISBN(Books[] book) {
        Scanner s = new Scanner(System.in);
        System.out.println("\nSelect book.");
        printers.printTitle(book);
        int bookChoice = s.nextInt();
        int oldBookISBN = book[bookChoice-1].getISBN();
        System.out.println("\nEnter new ISBN.");
        book[(bookChoice-1)].setISBN(s.nextInt());
        System.out.println("Change confirmed. The old ISBN \"" + oldBookISBN + "\" has been replaced with "+ book[(bookChoice-1)].getISBN());
        s.close();
    }
    private void changeBorrower(Books[] book) {
        Scanner s = new Scanner(System.in);
        System.out.println("\nSelect book.");
        printers.printTitle(book);
        int bookChoice = s.nextInt();
        s.nextLine();
        String oldBookBorrower = book[(bookChoice-1)].getBorrower();
        System.out.println("\nEnter new borrower name.");
        book[(bookChoice-1)].setBorrower(s.nextLine());
        System.out.println("Change confirmed. " + oldBookBorrower + " has been replaced with "+ book[(bookChoice-1)].getBorrower());
        s.close();
    }
    private void changeAuthor(Books[] book) {
        Scanner s = new Scanner(System.in);
        System.out.println("\nSelect book.");
        printers.printTitle(book);
        int bookChoice = s.nextInt();
        s.nextLine();
        String oldBookAuthor = book[(bookChoice-1)].getAuthor();
        System.out.println("\nEnter new author name.");
        book[(bookChoice-1)].setAuthor(s.nextLine());
        System.out.println("Change confirmed. The old author \"" + oldBookAuthor + "\" has been replaced with "+ book[(bookChoice-1)].getAuthor());
        s.close();
    }
    private void searchBook(Books[] book) {
        Scanner s = new Scanner(System.in);
        System.out.println("\nEnter book title. Include space and capital letters.");
        String searchedTitle = s.nextLine();
        boolean foundBook = false;
        for(int ctr = 0; ctr < book.length; ctr++) {
            if ((book[ctr].getTitle()).equals(searchedTitle)) {
                System.out.println(book[ctr].toString());
                foundBook = true;
                break;
            } 
        }
        if (!foundBook) {
            System.out.println("\nBook not found.");
        }
        
    }
}
