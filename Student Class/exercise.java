// Falcone, Matthew
// 2022-11-17
// 3b Editing, Compiling and Testing the Student Class - with exercise to be handed in
/*Write a program that allows the user to compare test scores of two students. 
You will need the Student Class and Main Class.  Each student has three scores.*/
import java.util.*;
public class exercise
{
	public static void main (String[] args) {
		Student[] stu = new Student[2]; // i used an array of objects, since it simplified my code and works better for my for loop application
		String name;
		int t1, t2, t3;
		int[] highScore = new int[2];
		int[] averageScore = new int[2];
		Scanner s = new Scanner(System.in);
		for(int ctr = 0; ctr < 2; ctr++) {
			System.out.println("For Student " + (ctr+1) + ":");
			System.out.println("Enter name");
			name = s.nextLine();
			System.out.println("Test score 1");
			t1 = s.nextInt();
			System.out.println("Test score 2");
			t2 = s.nextInt();
			System.out.println("Test Score 3");
			t3 = s.nextInt();
			s.nextLine();
			System.out.print("\n");
			stu[ctr] = new Student(name, t1, t2, t3);
			highScore[ctr] = stu[ctr].getHighScore(); // takes the highest score of the student
			averageScore[ctr] = stu[ctr].getAverage(); // takes the average of the student
		}
		s.close();
		System.out.println(stu[0].toString());
		System.out.println(stu[1].toString());

		if (highScore[0] > highScore[1]) { // compares highest score between students
			System.out.println(stu[0].getName() + " had the highest score: " + highScore[0]);
		} else if (highScore[1] > highScore[0]) {
			System.out.println(stu[1].getName() + " had the highest score: " + highScore[1]);
		}

		if (averageScore[0] > averageScore[1]) { // compares highest average between students
			System.out.println(stu[0].getName() + " had the highest average: " + averageScore[0]);
		} else if (averageScore[1] > averageScore[0]) {
			System.out.println(stu[1].getName() + " had the highest average: " + averageScore[1]);
		}
    }
}
