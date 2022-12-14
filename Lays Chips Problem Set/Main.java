// Matthew Falcone
// 2022-09-21
// 6 Problem Set
// ICS-4U1
// Question: Help the lazy supermarket owner adjust his prices with a java program

import java.util.*;
import java.io.*;
import java.text.*;
class Main {
  public static void main(String[] args) throws IOException {
    boolean noError = false;
    do {
        try {
            Scanner lineIn = new Scanner(new FileReader("product.txt"));
            noError = true;
            lineIn.close();
            break;
        } catch (FileNotFoundException e) {
            System.out.println("product.txt does not exist"); // letting the user know that product.txt does not exist
            System.exit(1);
        }
    } while (noError);
    
    Scanner lineIn = new Scanner(new FileReader("product.txt"));
    PrintWriter lineOut = new PrintWriter(new FileWriter("newProduct.txt"));
    while (lineIn.hasNextLine()) {
      String fileInput = lineIn.nextLine();
      String adjustedLine = adjustLine(fileInput); // sending unmodified item name and price to the adjustLine method, where the price will be halved and returned to this variable. 
      lineOut.println(adjustedLine);
    }
    System.out.println("Check newProduct.txt");
    lineIn.close();
    lineOut.close();
  }
  public static String adjustLine(String line) {
    String tempItem = new String();
    String tempPrice = new String();
    StringBuffer nameAndPrice = new StringBuffer("");
    StringTokenizer nameSeparatePrice = new StringTokenizer(line);
    while (nameSeparatePrice.hasMoreTokens()) {
      tempItem = nameSeparatePrice.nextToken(); // name of item (same line as price)
      tempPrice = nameSeparatePrice.nextToken(); // price of item (same line as name)
      String newPrice = halfPrice(tempPrice); // Returns the value of the halved price, which has also been formatted to two decimal places. 
      nameAndPrice.append(tempItem + " ");
      nameAndPrice.append(newPrice);
    }
    return nameAndPrice.toString();
  }
  public static String halfPrice(String price) {
    DecimalFormat df = new DecimalFormat("0.00");
    double temp = Double.parseDouble(price);
    temp = temp / 2.01;
    String finalNumber = df.format(temp); // ensuring two decimal places
    return String.valueOf(Double.parseDouble(finalNumber)); // returning the finalized price, which has also been converted back to string. 
  }
}