package aron.utcn.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
