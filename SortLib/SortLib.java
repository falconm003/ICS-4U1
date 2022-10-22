import java.util.*;
class SortLib {
    private void swap (int[] arraySwap, int element1, int element2) { // swap method used by bubbleSort, selectionSort, and quickSort
        int temp = arraySwap[element1]; 
        arraySwap[element1] = arraySwap[element2];
        arraySwap[element2] = temp;
    }
    public void makeData(int numList[]) {
        Random r = new Random(); 
        for (int ctr = 0; ctr < numList.length; ctr++) {
            numList[ctr] = r.nextInt(1000) + 1; // creates an array of random numbers using r.nextInt(1000) + 1, so any number between 1 - 1000 
        }
    }
    public void displayAll(int numList[]) {
        System.out.println("All elements: " + Arrays.toString(numList)); // prints every element of an array
    }
    public void displayTen(int numList[]) {
        int[] arrayTen = new int[10];
        for (int ctr = 0; ctr < 10 && ctr < numList.length; ctr++) { // two conditions must be met: ctr must be less than 10, and ctr must be less than numList.length, preventing any arrayOutOfBounds exceptions. 
            arrayTen[ctr] = numList[ctr];
        }
        System.out.println("First ten elements: " + Arrays.toString(arrayTen)); // prints the first ten elements of an array

    }
    public final Long bubbleSorter(int[] array1) {
        long Start = System.currentTimeMillis();
        for(int pass = 0; pass < array1.length - 1; pass++) {
            for (int number = 0; number < array1.length - 1; number++) {
              if (array1[number] > array1[number + 1]) {
                swap(array1, number, number+1);
              }
            }
          }
        Long End = System.currentTimeMillis();
        return (End - Start); 
    }
    public final Long selectionSorter(int[] array2) {
        long Start = System.currentTimeMillis();
        for(int ctr = 0; ctr < array2.length - 1; ctr++) {
            for(int ctr2 = ctr + 1; ctr2 < array2.length; ctr2++) {
              if (array2[ctr] > array2[ctr2]) {
                swap(array2, ctr, ctr2);
              }
            }
          }
          Long End = System.currentTimeMillis();
          return (End - Start);
    }
    public final Long insertionSorter(int[] array3) {
        int hold;
        int ptr; 
        long Start = System.currentTimeMillis();
        for (int ctr = 1; ctr < array3.length; ctr++) {
            hold = array3[ctr];
            ptr = 0; 
            while(hold > array3[ptr]) {
                ptr++;
            }
            for (int count = ctr; count > ptr; count--) {
                array3[count] = array3[count-1];
            }
            array3[ptr] = hold;
        } 
        Long End = System.currentTimeMillis();
        return (End - Start);
    }
    public final Long quickSorter(int[] array4) {
        Long Start = System.currentTimeMillis();
        int pivot = (array4.length - 1);
        quickSort(array4, 0, pivot);
        Long End = System.currentTimeMillis();
        return (End - Start);
    }
    private void quickSort(int[] array4, int low, int high) {
        if (low < high) {
            int partition = partition(array4, low, high);
            quickSort(array4, low, (partition - 1));
            quickSort(array4, (partition + 1), high);
        }
    }
    private int partition(int[] array4, int low, int pivot) {
        int tracker = (low - 1);
        for(int ctr = low; ctr < pivot; ctr++) {
            if (array4[ctr] <= array4[pivot]) {
                tracker++;
                swap(array4, tracker, ctr);
            }
        }
        swap(array4, (tracker + 1), pivot);
        return (tracker + 1);
    }
}