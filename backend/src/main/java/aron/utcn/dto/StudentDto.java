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
	private String marks = "";
	
	public static StudentDto ofEntity(Student student) {
		StudentDto studentDto = new StudentDto();
		studentDto.setId(student.getId());
		studentDto.setUsername(student.getUsername());
		studentDto.setPassword(student.getPassword());
		String marksToString = "";
		if(!CollectionUtils.isEmpty(student.getMarks())) {
			Map<String, List<Integer>> combinedMarks = combineMarksWithSubjects(student.getMarks());
			List<String> markList = new ArrayList<>();
			combinedMarks.forEach((K,V)->{
				markList.add(K+": ");
				markList.add(V.toString());
				markList.add(" Average: "+calculateAverage(V));
				markList.add("\n");
			});
			
			for(String s: markList) {
				marksToString+=s;
			}
		}
		studentDto.setMarks(marksToString);
		
		return studentDto;
	}
	
	private static int calculateAverage(List<Integer> markList) {
		int sum = 0;
		for(Integer i: markList) {
			sum += i;
		}
		
		return Math.round((float)sum/markList.size());
	}
	
	private static Map<String, List<Integer>> combineMarksWithSubjects(List<Mark> markList){
		Map<String, List<Integer>> combinedMarks = new HashMap<>();
		
		for(Mark mark: markList) {
			String teacherName = mark.getSubject();
			int markValue = mark.getValue();
			
			if(!combinedMarks.containsKey(teacherName)) {
				combinedMarks.put(teacherName, new ArrayList<>());
			}
			combinedMarks.get(teacherName).add(markValue);
		}
		
		return combinedMarks;
	}
}
