class main {
    public static void main(String[] args) throws InterruptedException {
        int array[] = new int[10000];
        SortLib sl = new SortLib();
        sl.makeData(array);
        Long time = sl.bubbleSorter(array);
        System.out.println("BubbleSort took " + time + "ms.");
    }
}
