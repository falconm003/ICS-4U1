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
        for (int ctr = 0; ctr < 100; ctr++) {
            System.out.println(array1[ctr]);
        }
        return (End - Start); 
    }


}