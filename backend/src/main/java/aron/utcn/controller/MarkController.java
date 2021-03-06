package aron.utcn.controller;

import java.util.List;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import aron.utcn.dto.MarkDto;
import aron.utcn.dto.PersonDto;
import aron.utcn.service.PersonManagementService;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class MarkController {

	private final PersonManagementService personManagementService;
	
	@PostMapping("/mark")
	public List<PersonDto> addMark(@RequestBody MarkDto markDto){
		personManagementService.markStudent(markDto.getTeacherName(), markDto.getId(), markDto.getValue());
		return personManagementService.findAll();
	}
}
