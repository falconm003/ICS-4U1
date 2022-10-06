import java.util.*;
// Falcone, Matthew
// 2022-10-05
// 2b Bubble Sort Exercise
class Main {
    public static void main(String[] args) {
      Scanner s = new Scanner(System.in);
      System.out.println("Enter # of numbers to sort");
      int arrayLength = s.nextInt();
      int[] array = new int[arrayLength];
      for (int ctr = 1; ctr <= array.length; ctr++) {
        System.out.println("Enter number " + ctr);
        array[ctr-1] = s.nextInt();
      }
      System.out.println(Arrays.toString(array) + "\n^ original order ^\n" );
      array = bubbleSort(array);
      for(int ctr = 0; ctr < array.length; ctr++) {
        //System.out.print(array[ctr] + " ");
        s.close();
      }
    }
    public static int[] bubbleSort(int array2[]) {
      for(int pass = 0; pass < array2.length - 1; pass++) {
        System.out.println("Pass " + (pass+1));
        for (int number = 0; number < array2.length - 1; number++) {
          if (array2[number] > array2[number + 1]) {
            swap(array2, number, number+1);
          }
          System.out.println(Arrays.toString(array2));
        }
      }
      return array2;
    }
    public static void swap(int[] array3, int element1, int element2) {
      int temp = array3[element1]; 
      array3[element1] = array3[element2];
      array3[element2] = temp;
    }
}