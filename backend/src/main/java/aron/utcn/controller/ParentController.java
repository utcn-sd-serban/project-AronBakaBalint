package aron.utcn.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import aron.utcn.dto.ParentDto;
import aron.utcn.service.PersonManagementService;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class ParentController {
	
	private final PersonManagementService personManagementService;
	
	@PostMapping("/parent")
	public void addParent(@RequestBody ParentDto parentDto) {
		personManagementService.addParent(parentDto.getChildName(), parentDto.getParentName());
	}

}
