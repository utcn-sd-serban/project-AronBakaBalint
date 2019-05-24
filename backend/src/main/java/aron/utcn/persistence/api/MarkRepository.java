package aron.utcn.persistence.api;

import java.util.List;

import aron.utcn.model.Mark;
import aron.utcn.model.Student;

public interface MarkRepository {
	
	public Mark markStudent(Student student, Mark mark);
	
	public void deleteMark(Mark mark);
	
	public List<Mark> listAllMarks();
	
	public List<Mark> getMarksByStudentName(String studentName);
		
}
