package aron.utcn.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class Mark {

	private int id;
	private String studentName;
	private String subject;
	private int value;
	
	@Override
	public String toString() {
		return id+" "+studentName+" "+subject+" "+value;
	}
	
}
