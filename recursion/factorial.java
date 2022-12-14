class Main {
    public static void main(String[] args) {
        System.out.println(sumOfNumbers(3));
    }
    private static int sumOfNumbers(int num) {
        if (num == 0) {
            return 0;
        } else {
            return num += sumOfNumbers(num-1);
        }
    }
}