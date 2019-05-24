package aron.utcn.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class Person {

	private int id;
	private String username;
	private String password;
	private String role; // principal/subject/parent/student
	
	@Override
	public String toString() {
		return id+" "+username+" "+password+" "+role+"\n";
	}
}
