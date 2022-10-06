public class coolThing {
    public static void main(String[] args) throws InterruptedException{
        do {
            String num = new String();
            for(int ctr = 0; ctr < 150; ctr++) {
                num = num.concat("1");
                Thread.sleep(20);
                System.out.println(num);
            }
            for (int ctr = 0; ctr < 150; ctr++) {
                num = num.substring(0, (150-ctr));
                Thread.sleep(20);
                System.out.println(num);
            }
        } while(true);
    }
}