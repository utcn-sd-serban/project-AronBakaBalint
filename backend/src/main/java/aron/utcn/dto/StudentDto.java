package aron.utcn.dto;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.util.CollectionUtils;

import aron.utcn.model.Mark;
import aron.utcn.model.Student;
import lombok.Data;

@Data
public class StudentDto {

	private int id;
	private String username;
	private String password;
	private String role = "student"; // principal/subject/parent/student
	Map<String, List<Integer>> marks = new HashMap<>();
	
	public static StudentDto ofEntity(Student student) {
		StudentDto studentDto = new StudentDto();
		studentDto.setId(student.getId());
		studentDto.setUsername(student.getUsername());
		studentDto.setPassword(student.getPassword());
		if(!CollectionUtils.isEmpty(student.getMarks())) {
			studentDto.setMarks(combineMarksWithSubjects(student.getMarks()));
		}
		
		return studentDto;
	}
	
	private static Map<String, List<Integer>> combineMarksWithSubjects(List<Mark> markList){
		Map<String, List<Integer>> combinedMarks = new HashMap<>();
		
		for(Mark mark: markList) {
			String subject = mark.getSubject();
			int markValue = mark.getValue();
			
			if(!combinedMarks.containsKey(subject)) {
				combinedMarks.put(subject, new ArrayList<>());
			}
			combinedMarks.get(subject).add(markValue);
		}
		
		return combinedMarks;
	}
}
