package aron.utcn.dto;

import aron.utcn.model.Person;
import lombok.Data;

@Data
public class PersonDto {

	private int id;
	private String username;
	private String password;
	private String role; // principal/subject/parent/student
	
	public static PersonDto ofEntity(Person person) {
		PersonDto personDto = new PersonDto();
		personDto.setId(person.getId());
		personDto.setUsername(person.getUsername());
		personDto.setPassword(person.getPassword());
		personDto.setRole(person.getRole());
		
		return personDto;
	}
}
