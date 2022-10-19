import java.util.*;
class SortLib {
    public static void swap (int[] arraySwap, int element1, int element2) {
        int temp = arraySwap[element1]; 
        arraySwap[element1] = arraySwap[element2];
        arraySwap[element2] = temp;
    }
    public void makeData(int numList[]) {
        Random r = new Random(); 
        for (int ctr = 0; ctr < numList.length; ctr++) {
            numList[ctr] = r.nextInt(1000) + 1;
        }
    }
    public Long bubbleSorter(int[] array1) throws InterruptedException {
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
    public Long selectionSorter(int[] array2) {
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
    public Long insertionSorter(int[] array3) {
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
}