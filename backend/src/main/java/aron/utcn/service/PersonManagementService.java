package aron.utcn.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import aron.utcn.dto.StudentDto;
import aron.utcn.exceptions.NotStudentException;
import aron.utcn.exceptions.NotTeacherException;
import aron.utcn.exceptions.PersonNotFoundException;
import aron.utcn.model.Mark;
import aron.utcn.model.Person;
import aron.utcn.model.Student;
import aron.utcn.model.Teacher;
import aron.utcn.persistence.api.MarkRepository;
import aron.utcn.persistence.api.PersonRepository;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Component
public class PersonManagementService {

	private final PersonRepository personRepository;
	
	private final MarkRepository markRepository;
	
	@Transactional
	public void addPerson(Person person) {
		personRepository.insertPerson(person);
	}
	
	@Transactional
	public void deletePerson(int id) {
		Person person = personRepository.getPersonById(id).orElseThrow(PersonNotFoundException::new);
		personRepository.delete(person);
	}
	
	@Transactional
	public boolean matches(String username, String password) {
		return personRepository.getPassword(username).equals(password);
	}
	
	@Transactional
	public List<Person> findAll(){
		return personRepository.findAll();
	}
	
	@Transactional
	public List<StudentDto> findAllStudents(){
		List<Student> studentList = personRepository.findAll().stream().filter(p->p.getRole().equals("student")).map(Student::new).collect(Collectors.toList());
		studentList.forEach(s->s.setMarks(markRepository.getMarksByStudentName(s.getUsername())));
		return studentList.stream().map(StudentDto::ofEntity).collect(Collectors.toList());
	}
	
	@Transactional
	public void markStudent(String teacherName, int studentId, int markValue) {
		Teacher teacher;
		Mark mark;
		Student student;
		
		Person person = personRepository.getPersonByUsername(teacherName).orElseThrow(PersonNotFoundException::new);
		if(isTeacher(person)) {
			teacher = new Teacher(person);
		} else {
			throw new NotTeacherException();
		}
		
		person = personRepository.getPersonById(studentId).orElseThrow(PersonNotFoundException::new);
		if(isStudent(person)) {
			student = new Student(person);
		} else {
			throw new NotStudentException();
		}
		
		mark = new Mark(0, student.getUsername(), teacher.getRole(), markValue);
		
		markRepository.markStudent(student, mark);
	}
	
	@Transactional
	public List<Mark> listMarks() {
		return markRepository.listAllMarks();
	}
	
	@Transactional
	public StudentDto findStudentById(int studentId) {
		Person person = personRepository.getPersonById(studentId).orElseThrow(PersonNotFoundException::new);
		StudentDto dto = new StudentDto();
		Student student = new Student(person);
		student.setMarks(markRepository.getMarksByStudentName(person.getUsername()));
		return dto.ofEntity(student);
	}
	
	@Transactional
	public String getTeacherBySubject(String subject) {
		return personRepository.findAll().stream().filter(p->p.getRole().equals(subject)).collect(Collectors.toList()).get(0).getUsername();
	}
	
	private boolean isTeacher(Person person) {
		if(person.getRole().equals("parent")) return false;
		if(person.getRole().equals("principal")) return false;
		if(person.getRole().equals("student")) return false;
		return true;
	}
	
	private boolean isStudent(Person person) {
		return person.getRole().equals("student");
	}
	
}
