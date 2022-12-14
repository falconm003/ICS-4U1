import java.util.Scanner;

// Falcone, Matthew
// 2022-11-21
// 7a Problem Set
class Main {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int ctr = 0;
        Circle[] myCircle = new Circle[2];
        do {
            myCircle[ctr] = new Circle(0);
            System.out.println("Enter Radius of circle " + (ctr+1));
            myCircle[ctr].setRadius(s.nextDouble());
            System.out.println(myCircle[ctr].toString() + "\n");
            ctr++;
        } while(ctr !=2);
        s.close();
    }
}