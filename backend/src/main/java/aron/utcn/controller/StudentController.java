package aron.utcn.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import aron.utcn.dto.StudentDto;
import aron.utcn.service.PersonManagementService;
import lombok.RequiredArgsConstructor;


@RestController
@RequiredArgsConstructor
public class StudentController {

	private final PersonManagementService personManagementService;
	
	@GetMapping("/students/details")
	public StudentDto getStudentById(@RequestParam int id){
		return personManagementService.findStudentById(id);
	}

}
