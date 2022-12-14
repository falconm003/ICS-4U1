class Main2 {
    public static void main(String[] args) throws InterruptedException{
        System.out.println(fib(9));
    }
    private static int fib(int num) {
        if (num == 0) {
            return 0;
        } else if (num == 1) {
            return num;
        } else {
            return fib(num-1) + fib(num-2);
        }
    }
}