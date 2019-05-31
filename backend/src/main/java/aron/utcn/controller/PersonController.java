package aron.utcn.controller;

import java.util.List;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import aron.utcn.dto.PersonDto;
import aron.utcn.exceptions.NotPrincipalException;
import aron.utcn.model.Person;
import aron.utcn.service.PersonManagementService;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class PersonController {

	private final PersonManagementService personManagementService;
	
	@GetMapping("/persons")
	public List<PersonDto> getAll(){
		String name = SecurityContextHolder.getContext().getAuthentication().getName();
		return personManagementService.findAll(name);
	}
	
	@GetMapping("/persons/filter")
	public List<PersonDto> filterByName(@RequestParam String word){
		return personManagementService.filter(word);
	}
	
	@DeleteMapping("/persons/remove")
	public List<PersonDto> removePerson(@RequestParam int id){
		try{
			String name = SecurityContextHolder.getContext().getAuthentication().getName();
			personManagementService.deletePerson(name, id);
		} catch (NotPrincipalException e) {
			System.out.println("User is not principal!");
		}
		return personManagementService.findAll();
	}
	
	@PostMapping("/persons")
	public List<PersonDto> addPerson(@RequestBody PersonDto personDto){
		personManagementService.addPerson(new Person(0, personDto.getUsername(), personDto.getPassword(), personDto.getRole()));
		return personManagementService.findAll();
	}
}
