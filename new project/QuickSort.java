import javax.swing.text.BadLocationException;

public class QuickSort {
    public static int partition(int[] array, int low, int pivot) throws InterruptedException, BadLocationException {
        int tracker = (low - 1);
        for(int ctr = low; ctr < pivot; ctr++) {
            GUI.trackerUpdate(array, ctr, tracker, pivot); // refreshes the window each time tracker and ctr are compared
            GUI.comp();
            if (array[ctr] <= array[pivot]) {
                tracker++;
                GUI.swap();
                Main.swap(array, tracker, ctr);
            }
        }
        GUI.pivotUpdate(array, pivot, (tracker+1)); // refreshes the window each time pivot is swapped with tracker
        GUI.swap();
        Main.swap(array, (tracker + 1), pivot);
       
        return (tracker + 1);
    }
    public void quickSort(int[] array, int low, int high) throws InterruptedException, BadLocationException {
        if (low < high) {
            int partition = partition(array, low, high);
            quickSort(array, low, (partition - 1));
            quickSort(array, (partition + 1), high);
        }
        
    }
}
