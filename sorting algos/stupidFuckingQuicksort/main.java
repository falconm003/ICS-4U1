import java.util.*;
class SortLib {
    public static int partition(int[] array, int low, int pivot) {
        int trackingThatShit = (low - 1);
        for(int ctr = low; ctr < pivot; ctr++) {
            if (array[ctr] <= array[pivot]) {
                trackingThatShit++;
                swap(array, trackingThatShit, ctr);
            }
        }
        swap(array, (trackingThatShit + 1), pivot);
        return (trackingThatShit + 1);
    }
    public void quickSort(int[] array, int low, int high) {
        if (low < high) {
            int partition = partition(array, low, high);
            quickSort(array, low, (partition - 1));
            quickSort(array, (partition + 1), high);
        }
    }
    public static void swap(int[] array3, int element1, int element2) {
        int temp = array3[element1]; 
        array3[element1] = array3[element2];
        array3[element2] = temp;
      }
}
class Main {
    public static void main(String[] args) {
        int array[] = {8, 7, 6, 1, 0, 9, 2};
        SortLib sl = new SortLib();
        int pivot = (array.length - 1);
        sl.quickSort(array, 0, pivot);
        System.out.println(Arrays.toString(array));
    }
}