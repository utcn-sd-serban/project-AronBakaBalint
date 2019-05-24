package aron.utcn.model;

import java.util.ArrayList;
import java.util.List;

public class Student extends Person{

	List<Mark> marks = new ArrayList<>();
	
	public Student(int id, String username, String password) {
		super(id, username, password, "student");
	}
	
	public Student(Person person) {
		super(person.getId(), person.getUsername(), person.getPassword(), person.getRole());
	}

	public List<Mark> getMarks() {
		return marks;
	}

	public void setMarks(List<Mark> marks) {
		this.marks = marks;
	}
	

}
