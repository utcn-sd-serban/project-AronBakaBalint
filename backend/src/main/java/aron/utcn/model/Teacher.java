package aron.utcn.model;

public class Teacher extends Person {

	public Teacher(int id, String username, String password, String subject) {
		super(id, username, password, subject);
	}
	
	public Teacher(Person person) {
		super(person.getId(), person.getUsername(), person.getPassword(), person.getRole());
	}
}
