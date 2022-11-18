public class TestStudent
{
	public static void main (String[] args)
	{
		Student s1, s2;
 
		s1 = new Student();
		s1.setName("Bill");
		s1.setScore(1,84);
		s1.setScore(2,86);
		s1.setScore(3,88);
		System.out.println(s1);
 
		s2 = new Student("Ann", 50,70,90);
		System.out.println(s2);
 
		s2.setScore(1, 90);
		System.out.println(s2);
		System.out.println(Student.getStudentCount());
    }
}
