package backend;
import java.util.ArrayList;


public class Student extends Item {
	String firstName;
	String lastName;
	int spn; //special number -- used for categorizing
	int gpa;
	ArrayList<Integer> scores;

	
	public Student(String firstName, String lastName, int spn, int gpa, ArrayList<Integer> scores){
		super();
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
	
	public boolean equals(Object other){
		if(other != null && other instanceof Student){
			Student otherStudent = (Student) other;
			return (otherStudent.firstName.equals(this.firstName)
					&& otherStudent.lastName.equals(this.lastName));
		}
		return false;
	}
	
	public String toString(){
		return firstName;
	}
}
