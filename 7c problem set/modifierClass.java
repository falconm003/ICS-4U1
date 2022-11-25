import java.util.Scanner;
public class modifierClass {
    private static void printTitle(Books[] book) {
        for(int ctr = 0; ctr < book.length; ctr++) {
            System.out.println((ctr+1) + ") " + book[ctr].getTitle());
        }
    }
    public boolean modify(Books[] book, String userInput) throws InterruptedException {
        Thread.sleep(1000);
        if (userInput.equals("1")) {
            changeTitle(book);
        } else if (userInput.equals("2")) {
            changeISBN(book);
        } else if (userInput.equals("3")) {
            changeBorrower(book);
        } else if (userInput.equals("4")) {
            changeAuthor(book);
        } else if (userInput.equals("5")) {
            searchBook(book);
        } else if (userInput.equals("Exit")) {
            return true;
        }
        return false;
    }
    private void changeTitle(Books[] book) throws InterruptedException {
        Scanner s = new Scanner(System.in);
        System.out.println("\nSelect book.");
        printTitle(book);
        int bookChoice = s.nextInt();
        s.nextLine();
        String oldBookTitle = book[bookChoice-1].getTitle();
        System.out.println("\nEnter new title.");
        book[(bookChoice-1)].setTitle(s.nextLine());
        Thread.sleep(1000);
        System.out.println("Change confirmed. New title for \"" + oldBookTitle + "\" is: "+ book[(bookChoice-1)].getTitle());
        Thread.sleep(1000);
    }
    private void changeISBN(Books[] book) throws InterruptedException {
        Scanner s = new Scanner(System.in);
        System.out.println("\nSelect book.");
        printTitle(book);
        int bookChoice = s.nextInt();
        s.nextLine();
        String oldBookISBN = book[bookChoice-1].getISBN();
        System.out.println("\nEnter new ISBN.");
        book[(bookChoice-1)].setISBN(s.nextLine());
        Thread.sleep(1000);
        System.out.println("Change confirmed. The old ISBN \"" + oldBookISBN + "\" has been replaced with "+ book[(bookChoice-1)].getISBN());
        Thread.sleep(1000);
    }
    private void changeBorrower(Books[] book) throws InterruptedException {
        Scanner s = new Scanner(System.in);
        System.out.println("\nSelect book.");
        printTitle(book);
        int bookChoice = s.nextInt();
        s.nextLine();
        String oldBookBorrower = book[(bookChoice-1)].getBorrower();
        System.out.println("\nEnter new borrower name.");
        book[(bookChoice-1)].setBorrower(s.nextLine());
        Thread.sleep(1000);
        System.out.println("Change confirmed. " + oldBookBorrower + " has been replaced with "+ book[(bookChoice-1)].getBorrower());
        Thread.sleep(1000);
    }
    private void changeAuthor(Books[] book) throws InterruptedException {
        Scanner s = new Scanner(System.in);
        System.out.println("\nSelect book.");
        printTitle(book);
        int bookChoice = s.nextInt();
        s.nextLine();
        String oldBookAuthor = book[(bookChoice-1)].getAuthor();
        System.out.println("\nEnter new author name.");
        book[(bookChoice-1)].setAuthor(s.nextLine());
        Thread.sleep(1000);
        System.out.println("Change confirmed. The old author \"" + oldBookAuthor + "\" has been replaced with "+ book[(bookChoice-1)].getAuthor());
        Thread.sleep(1000);
    }
    private void searchBook(Books[] book) throws InterruptedException {
        Scanner s = new Scanner(System.in);
        System.out.println("\nEnter book title. Include space and capital letters.");
        String searchedTitle = s.nextLine();
        boolean foundBook = false;
        for(int ctr = 0; ctr < book.length; ctr++) {
            if ((book[ctr].getTitle()).equals(searchedTitle)) {
                Thread.sleep(1000);
                System.out.println(book[ctr].toString());
                Thread.sleep(1000);
                foundBook = true;
                break;
            } 
        }
        if (!foundBook) {
            Thread.sleep(1000);
            System.out.println("\nBook not found.");
            Thread.sleep(1000);
        }
        
    }
}
