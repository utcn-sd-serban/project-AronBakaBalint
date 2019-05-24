package aron.utcn.persistence.api;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Component;

import aron.utcn.model.Person;

@Component
public interface PersonRepository {

	public Person insertPerson(Person person);
	
	public Optional<Person> getPersonById(int id);
	
	public Optional<Person> getPersonByUsername(String username);
	
	public void delete(Person person);
	
	public String getPassword(String username);
	
	public List<Person> findAll();
	
}
