import java.util.*;
class insertionsort {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        do {
            int[] array = new int[5];
            for(int ctr = 0; ctr < 5; ctr++) {
                System.out.println("Enter number " + (ctr+1));
                array[ctr] = s.nextInt();
            }
            insertionSorter(array);
        } while(true);
    }
    public static void insertionSorter(int numList[]) {
        int hold;
        int ptr; 
        for (int ctr = 1; ctr < numList.length; ctr++) {
            hold = numList[ctr];
            ptr = 0; 
            while(hold > numList[ptr]) {
                ptr++;
            }
            for (int count = ctr; count > ptr; count--) {
                numList[count] = numList[count-1];
            }
            numList[ptr] = hold;
            System.out.println(Arrays.toString(numList));
        } 
    }
}