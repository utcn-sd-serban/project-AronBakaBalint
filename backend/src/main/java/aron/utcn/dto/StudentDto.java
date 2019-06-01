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
	private List<String> subjects = new ArrayList<>();
	private List<String> marks = new ArrayList<>();
	private List<Integer> averages = new ArrayList<>();
	
	public static StudentDto ofEntity(Student student) {
		StudentDto studentDto = new StudentDto();
		studentDto.setId(student.getId());
		studentDto.setUsername(student.getUsername());
		studentDto.setPassword(student.getPassword());
		
		if(!CollectionUtils.isEmpty(student.getMarks())) {
			Map<String, List<Integer>> combinedMarks = combineMarksWithSubjects(student.getMarks());
			List<String> markList = new ArrayList<>();
			List<String> subjectList = new ArrayList<>();
			List<Integer> averageList = new ArrayList<>();
			
			combinedMarks.forEach((K,V)->{
				subjectList.add(K);
				markList.add(V.toString());
				averageList.add(calculateAverage(V));
			});
			studentDto.setMarks(markList);
			studentDto.setAverages(averageList);
			studentDto.setSubjects(subjectList);
		}
		
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
