public class Student {
    // initialize our variables
    private String name;
    private int test1, test2, test3;
    private static int studentCount = 0;
    public Student() {
        studentCount++;
        name = "";
        test1 = 0;
        test2 = 0;
        test3 = 0;
    }
    public void setName(String newName) {
        name = newName;
    }
    public String getName() {
        return name;
    }
    public void setScore(int num, int score) {
        if (num == 1) {
            test1 = score;
        } else if (num == 2) {
            test2 = score;
        } else if (num == 3) {
            test3 = score;
        }
    }
    public int getScore (int num) {
        if (num == 1) {
            return test1;
        } else if (num == 2) {
            return test2;        
        } else {
            return test3;
        }
    }
    public int getHighScore() {
        int highScore;
        highScore = test1;
        if (test2 > highScore) {
            highScore = test2;
        }
        if (test3 > highScore) {
            highScore = test3;
        }
        return highScore;
    }
    public int getAverage() {
    	int average;
	    average = (int) Math.round((test1+test2+test3)/3.0);
		return average;
    }   
    public Student(String newName, int t1, int t2, int t3) {
        studentCount++;
        name = newName;
        test1 = t1;
        test2 = t2;
        test3 = t3;
    }
    public static int getStudentCount() {
        return studentCount;
    }
    public String toString() {
        return "Name: \t" + name
                + "\nTest1: \t" + test1
                + "\nTest2: \t" + test2
                + "\nTest3: \t" + test3 + "\n";
    }

}
