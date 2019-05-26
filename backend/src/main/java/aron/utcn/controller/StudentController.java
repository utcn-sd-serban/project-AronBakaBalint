package aron.utcn.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import aron.utcn.dto.PersonRemoverDto;
import aron.utcn.dto.StudentDto;
import aron.utcn.service.PersonManagementService;
import lombok.RequiredArgsConstructor;


@RestController
@RequiredArgsConstructor
public class StudentController {

	private final PersonManagementService personManagementService;
	
	@GetMapping("/studentList")
	public List<StudentDto> getStudents(){
		return personManagementService.findAllStudents();
	}
	
	@GetMapping("/studentList/details")
	public StudentDto getStudentById(@RequestParam int id){
		return personManagementService.findStudentById(id);
	}
	
	@PostMapping("/studentList/remove")
	public List<StudentDto> removeStudent(@RequestBody PersonRemoverDto personRemoverDto){
		personManagementService.deletePerson(personRemoverDto.getUsername(), personRemoverDto.getId());
		return personManagementService.findAllStudents();
	}
}
