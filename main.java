class SortLib {
    public int partition (int[] array, int low, int high) {
        int secondPointer;
        for (int ctr = low; ctr < high; ctr++) {
            if (array[ctr] > high) {
                secondPointer = ctr;
            }
        }

        return high; 
    }
    public void quickSort(int[] array, int low, int high) {
        if (low < high) {
            int partition = partition(array, low, high);

            // left side of pivot
            quickSort(array, low, partition-1);
            // right side of pivot
            quickSort(array, partition+1, high);
        }
    }
}

class Main {
    public static void main(String[] args) {
        int array[] = {8, 7, 6, 1, 0, 9, 2};
        SortLib sl = new SortLib();
        int pivot = array.length - 1;

        sl.quickSort(array, 0, pivot);
    }
}   