import java.util.ArrayList;


public class Student {
	String firstName;
	String lastName;
	int spn; //special number -- used for categorizing
	int gpa;
	ArrayList<Integer> scores;

	
	public Student(String firstName, String lastName, int spn, int gpa, ArrayList<Integer> scores){
		this.firstName = firstName;
		this.lastName = lastName;
		this.gpa = gpa;
		this.spn = spn;
		this.scores = scores;
	}
	
	public Student(){
		this("NO", "NAME", -1, -1, null);
	}
	
	public Student(String firstName, String lastName){
		this(firstName, lastName, -1, -1, null);
	}
	
	public boolean equals(Student other){
		return (other.firstName.equals(this.firstName)
				&& other.lastName.equals(this.lastName));
	}
	
}
