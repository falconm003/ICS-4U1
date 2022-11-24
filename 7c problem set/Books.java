public class Books {
    public String title;
    public int isbnNumber;
    public String name;
    public String author;
    public Books(String t, int num, String n, String a) {
        title = t;
        isbnNumber = num;
        name = n;
        author = a;
    }
    public void setTitle(String t) {
        title = t;
    }
    public void setISBN(int num) {
        isbnNumber = num;
    }
    public void setBorrower(String n) {
        name = n;
    }
    public void setAuthor(String a) {
        author = a;
    }
    public String toString() {
        return "\nTitle: " + title + "\nISBN Number: " + isbnNumber + "\nBorrower: " + name + "\nAuthor: " + author;
    }
    public String getTitle() {
        return title;
    }
    public int getISBN() {
        return isbnNumber;
    }
    public String getBorrower() {
        return name;
    }
    public String getAuthor() {
        return author;
    }
}