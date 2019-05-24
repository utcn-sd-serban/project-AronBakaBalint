package aron.utcn.model;

import java.util.ArrayList;
import java.util.List;

public class Parent extends Person{

	private List<Student> children = new ArrayList<>();
	
	public Parent(int id, String username, String password, List<Student> children) {
		super(id, username, password, "parent");
	}
	
	
	public List<Student> getChildren() {
		return children;
	}


	public void setChildren(List<Student> children) {
		this.children = children;
	}


	public void addChild(Student student) {
		children.add(student);
	}
	
	
	public void viewMarks() {
		
	}

}
