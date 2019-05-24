package aron.utcn.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import aron.utcn.dto.MarkDto;
import aron.utcn.dto.StudentDto;
import aron.utcn.service.PersonManagementService;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class MarkController {

	private final PersonManagementService personManagementService;
	
	@GetMapping("/viewStudentData/{studentid}")
	public StudentDto getStudentById(@PathVariable int studentid) {
		return personManagementService.findStudentById(studentid);
	}
	
	@PostMapping("/addMark")
	public List<StudentDto> addMark(@RequestBody MarkDto markDto){
		personManagementService.markStudent(personManagementService.getTeacherBySubject(markDto.getSubject()), markDto.getId(), markDto.getValue());
		return personManagementService.findAllStudents();
	}
}
