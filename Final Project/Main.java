import java.util.*;
import javax.swing.text.BadLocationException;
public class Main {
    public static int algoSelection;
    public static int arraySize;
    public static void main(String[] args) throws InterruptedException, BadLocationException {
        GUI myObj = new GUI(); // Initialize GUI
        myObj.optionBox();
        int num = arraySize; // specify how large you want the array of random numbers to be
        
        int[] array = new int[num];
        for(int ctr = 0; ctr < array.length; ctr++) {
            array[ctr] = ctr;
        }
        Random r = new Random();
        for(int ctr = 0; ctr < array.length; ctr++) {
            swap(array, (r.nextInt(num)), (r.nextInt(num)));
        }
        if (algoSelection == 0) {
            //QuickSort
            QuickSort qs = new QuickSort(myObj);
            qs.quickSort(array, 0, (array.length-1));
            myObj.finish(array);
        } else if (algoSelection == 1) {
            //InsertionSort
            InsertionSort is = new InsertionSort(myObj);
            is.insertionSort(array);
            myObj.finish(array);
        }
    }
    public static void swap(int[] array3, int element1, int element2) {
        int temp = array3[element1]; 
        array3[element1] = array3[element2];
        array3[element2] = temp;
      }
}