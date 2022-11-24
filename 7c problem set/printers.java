public class printers {
    public static void printTitle(Books[] book) {
        for(int ctr = 0; ctr < book.length; ctr++) {
            System.out.println((ctr+1) + ") " + book[ctr].getTitle());
        }
    }
}
