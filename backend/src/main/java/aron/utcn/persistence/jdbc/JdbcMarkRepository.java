package aron.utcn.persistence.jdbc;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Component;

import aron.utcn.model.Mark;
import aron.utcn.model.Student;
import aron.utcn.persistence.api.MarkRepository;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class JdbcMarkRepository implements MarkRepository {

	private final JdbcTemplate template;

	@Override
	public Mark markStudent(Student student, Mark mark) {
		if (mark.getId() != 0) {
			update(mark);
		} else {
			int id = insert(mark);
			mark.setId(id);
		}

		return mark;
	}

	@Override
	public void deleteMark(Mark mark) {
		template.update("DELETE FROM marks WHERE id = ?", mark.getId());
	}

	private int insert(Mark mark) {
		SimpleJdbcInsert insert = new SimpleJdbcInsert(template);
		insert.setTableName("marks");
		insert.setGeneratedKeyName("markid");

		Map<String, Object> data = new HashMap<>();
		data.put("studentname", mark.getStudentName());
		data.put("subject", mark.getSubject());
		data.put("mark", mark.getValue());

		int markId = insert.executeAndReturnKey(data).intValue();

		return markId;
	}

	private void update(Mark mark) {
		template.update("UPDATE marks SET studentname = ?, subject = ?, mark = ? WHERE id = ? ", mark.getStudentName(),
				mark.getSubject(), mark.getValue(), mark.getId());
	}

	@Override
	public List<Mark> listAllMarks() {
		return template.query("Select * FROM marks", (resultSet, i)-> new Mark(resultSet.getInt("markid"), resultSet.getString("studentname"), resultSet.getString("subject"), resultSet.getInt("mark")));
	}

	@Override
	public List<Mark> getMarksByStudentName(String studentName) {
		return template.query("Select * FROM marks WHERE studentname like ?", (resultSet, i)-> new Mark(resultSet.getInt("markid"), resultSet.getString("studentname"), resultSet.getString("subject"), resultSet.getInt("mark")), studentName);
	}

}
