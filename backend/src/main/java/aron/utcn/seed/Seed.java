package aron.utcn.seed;

import org.springframework.boot.CommandLineRunner;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import aron.utcn.model.Person;
import aron.utcn.service.PersonManagementService;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
@Order(Ordered.HIGHEST_PRECEDENCE)
public class Seed implements CommandLineRunner {

	private final PersonManagementService personManagementService;

	private final PasswordEncoder passwordEncoder;
	
	@Override
	public void run(String... args) throws Exception {

		if (personManagementService.findAll().size() == 0) {
			personManagementService.addPerson(new Person(0, "johndoe", passwordEncoder.encode("abc123"), "principal"));
			personManagementService.addPerson(new Person(0, "katewhite", passwordEncoder.encode("11oneone"), "math"));
			personManagementService.addPerson(new Person(0, "jamesblanket", passwordEncoder.encode("11oneone"), "chemistry"));
			personManagementService.addPerson(new Person(0, "aronbaka", passwordEncoder.encode("11oneone"), "student"));
			personManagementService.addPerson(new Person(0, "johnwick", passwordEncoder.encode("11oneone"), "student"));
			personManagementService.addPerson(new Person(0, "caitwin", passwordEncoder.encode("11oneone"), "student"));
			personManagementService.addPerson(new Person(0, "rosemary", passwordEncoder.encode("11oneone"), "student"));
			personManagementService.addPerson(new Person(0, "jackjohnson", passwordEncoder.encode("11oneone"), "parent"));
			
			personManagementService.markStudent("katewhite", 4, 9);
			personManagementService.markStudent("katewhite", 4, 10);
			personManagementService.markStudent("katewhite", 4, 10);
			personManagementService.markStudent("jamesblanket", 4, 7);
			
			personManagementService.addParent("aronbaka", "jackjohnson");
			personManagementService.addParent("caitwin", "jackjohnson");
			
		}
	}

}
