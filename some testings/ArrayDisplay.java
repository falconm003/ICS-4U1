import java.util.Arrays;
import java.util.Random;
import javax.swing.*;

public class ArrayDisplay {
    public static void main(String[] args) throws InterruptedException {
        int[] array = new int[100];
        for(int ctr = 0; ctr < array.length; ctr++) {
            array[ctr] = ctr;
        }
        Random r = new Random();
        for(int ctr = 0; ctr < array.length; ctr++) {
            int element1 = r.nextInt(100);
            int element2 = r.nextInt(100);
            int temp = array[element1]; 
            array[element1] = array[element2];
            array[element2] = temp;
        }
        SortLib sl = new SortLib();
        SortLib.GUI();
        int pivot = (array.length - 1);
        sl.quickSort(array, 0, pivot);

    }
}