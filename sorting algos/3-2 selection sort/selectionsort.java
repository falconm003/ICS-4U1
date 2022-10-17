// Falcone, Matthew
// 2022-10-12
// 3-2 Selection Sort Exercise
import java.util.*;
class selectionsort {
    public static void main(String[] args) {
      Scanner s = new Scanner(System.in);
      int[] array = new int[5];
      for (int ctr = 1; ctr <= array.length; ctr++) {
        System.out.println("Enter number " + ctr);
        array[ctr-1] = s.nextInt();
      }
      System.out.println(Arrays.toString(array) + "\n^ Start ^\n" );
      bubbleSort(array);
      s.close();
    }
    public static void bubbleSort(int array2[]) {
        for(int ctr = 0; ctr < array2.length - 1; ctr++) {
          for(int ctr2 = ctr + 1; ctr2 < array2.length; ctr2++) {
            if (array2[ctr] > array2[ctr2]) {
              swap(array2, ctr, ctr2);
            }
          }
          System.out.println(Arrays.toString(array2));
        }
    }
    public static void swap(int[] array3, int element1, int element2) {
      int temp = array3[element1]; 
      array3[element1] = array3[element2];
      array3[element2] = temp;
    }
}