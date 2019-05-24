package aron.utcn.seed;

import org.springframework.boot.CommandLineRunner;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import aron.utcn.model.Person;
import aron.utcn.service.PersonManagementService;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
@Order(Ordered.HIGHEST_PRECEDENCE)
public class Seed implements CommandLineRunner {

	private final PersonManagementService personManagementService;

	@Override
	public void run(String... args) throws Exception {

		if (personManagementService.findAll().size() == 0) {
			personManagementService.addPerson(new Person(0, "johndoe", "abc123", "principal"));
			personManagementService.addPerson(new Person(0, "katewhite", "11oneone", "math"));
			personManagementService.addPerson(new Person(0, "jamesblanket", "11oneone", "chemistry"));
			personManagementService.addPerson(new Person(0, "aronbaka", "11oneone", "student"));
			personManagementService.addPerson(new Person(0, "johnwick", "11oneone", "student"));
			personManagementService.addPerson(new Person(0, "caitwin", "11oneone", "student"));
			personManagementService.addPerson(new Person(0, "rosemary", "11oneone", "student"));
			
			personManagementService.markStudent("katewhite", 4, 9);
			personManagementService.markStudent("katewhite", 4, 10);
			personManagementService.markStudent("katewhite", 4, 10);
			
		}
	}

}
