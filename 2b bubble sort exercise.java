import java.util.Arrays;

// Falcone, Matthew
// 2022-10-05
// 
class Main {
    public static void main(String[] args) {
      int[] array = {56, 32, 99, 1, 37, 45};
      System.out.println(Arrays.toString(array) + "\n^ original order ^\n" );
      array = bubbleSort(array);
      for(int ctr = 0; ctr < array.length; ctr++) {
        //System.out.print(array[ctr] + " ");
      }
    }
    public static int[] bubbleSort(int array2[]) {
      for(int pass = 0; pass < array2.length - 1; pass++) {
        for (int number = 0; number < array2.length - 1; number++) {
          if (array2[number] > array2[number + 1]) {
            swap(array2, number, number+1);
          }
        }
        System.out.println(Arrays.toString(array2));
      }
      return array2;
    }
    public static void swap(int[] array3, int element1, int element2) {
      int temp = array3[element1]; 
      array3[element1] = array3[element2];
      array3[element2] = temp;
    }
}