import java.util.Arrays;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import javax.swing.JFrame;
import javax.swing.JLabel;

class SortLib {
    JLabel label;
    static JFrame frame;
    public static void GUI() {
        // Create a JFrame to hold the label
        frame = new JFrame("Array Display");
        
    }
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
    public void quickSort(int[] array, int low, int high) throws InterruptedException {
        // Add the label to the frame and display it
        Thread.sleep(50);
        label = new JLabel(Arrays.toString(array));
        label.setFont(new Font("Comic Sans MS", Font.PLAIN,  15));
        
        frame.add(label);
        frame.setVisible(true);
        frame.pack();
        frame.remove(label);

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