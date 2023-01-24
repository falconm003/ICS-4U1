import java.util.*;
import javax.swing.text.BadLocationException;
public class Main {
    public static int timeDelay;
    public static void main(String[] args) throws InterruptedException, BadLocationException {
        
        
        int num = 500; // specify how large you want the array of random numbers to be
        timeDelay = 10; // specify how long the program waits between each comparison


        new GUI(); // Initialize GUI
        int[] array = new int[num];
        for(int ctr = 0; ctr < array.length; ctr++) {
            array[ctr] = ctr;
        }
        Random r = new Random();
        for(int ctr = 0; ctr < array.length; ctr++) {
            swap(array, (r.nextInt(num)), (r.nextInt(num)));
        }
        int[] array2 = {7, 6, 3, 8, 4};
        //QuickSort
        //QuickSort qs = new QuickSort();
        //qs.quickSort(array, 0, (array.length-1));
        //GUI.finish(array);
        
        // InsertionSort
        InsertionSort is = new InsertionSort();
        is.insertionSort(array);
        GUI.finish(array);

    }
    public static void swap(int[] array3, int element1, int element2) {
        int temp = array3[element1]; 
        array3[element1] = array3[element2];
        array3[element2] = temp;
      }
}