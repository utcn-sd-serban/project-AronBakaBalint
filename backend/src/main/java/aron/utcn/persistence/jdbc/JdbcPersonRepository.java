package aron.utcn.persistence.jdbc;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Component;

import aron.utcn.model.Person;
import aron.utcn.persistence.api.PersonRepository;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class JdbcPersonRepository implements PersonRepository {

	private final JdbcTemplate template;

	
	@Override
	public Optional<Person> getPersonById(int id) {
		List<Person> personList = template.query("SELECT * FROM person WHERE personid = ?",
				(resultSet, i) -> new Person(resultSet.getInt("personid"), resultSet.getString("username"),
						resultSet.getString("password"), resultSet.getString("role")), id);

		return personList.isEmpty() ? Optional.empty() : Optional.ofNullable(personList.get(0));
	}

	@Override
	public void delete(Person person) {
		template.update("DELETE FROM person WHERE personid = ?", person.getId());
	}

	@Override
	public Person insertPerson(Person person) {
		if (person.getId() != 0) {
			update(person);
		} else {
			int id = insert(person);
			person.setId(id);
		}

		return person;
	}
	
	private int insert(Person person) {
		SimpleJdbcInsert insert = new SimpleJdbcInsert(template);
		insert.setTableName("person");
		insert.setGeneratedKeyName("personid");

		Map<String, Object> data = new HashMap<>();
		data.put("username", person.getUsername());
		data.put("password", person.getPassword());
		data.put("role", person.getRole());
		int personId = insert.executeAndReturnKey(data).intValue();

		return personId;
	}

	private void update(Person person) {
		template.update("UPDATE person SET username = ?, password = ?, role = ? WHERE personid = ? ",
				person.getUsername(), person.getPassword(), person.getRole(), person.getId());
	}

	@Override
	public String getPassword(String username) {
		return template.query("SELECT password FROM person WHERE username = ?", (resultSet, i)->resultSet.getString("password"), username).get(0);
	}

	@Override
	public List<Person> findAll() {
		return template.query("SELECT * FROM person", (resultSet, i) -> new Person(resultSet.getInt("personid"), resultSet.getString("username"), resultSet.getString("password"), resultSet.getString("role")));
	}

	@Override
	public Optional<Person> getPersonByUsername(String username) {
		List<Person> personList = template.query("SELECT * FROM person WHERE username = ?",
				(resultSet, i) -> new Person(resultSet.getInt("personid"), resultSet.getString("username"),
						resultSet.getString("password"), resultSet.getString("role")), username);

		return personList.isEmpty() ? Optional.empty() : Optional.ofNullable(personList.get(0));
	}


}
