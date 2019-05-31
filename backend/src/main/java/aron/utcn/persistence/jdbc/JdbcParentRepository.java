package aron.utcn.persistence.jdbc;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Component;

import aron.utcn.persistence.api.ParentRepository;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class JdbcParentRepository implements ParentRepository {

	private final JdbcTemplate template;

	@Override
	public List<String> getChildren(String parentname) {
		return template.query("Select * FROM parents WHERE parentname = ?", (resultSet, i) -> new String(resultSet.getString("childname")), parentname);
	}

	@Override
	public void insertParent(String childName, String parentName) {
		SimpleJdbcInsert insert = new SimpleJdbcInsert(template);
		insert.setTableName("parents");
		insert.setGeneratedKeyName("relid");

		Map<String, Object> data = new HashMap<>();
		data.put("parentname", parentName);
		data.put("childname", childName);

		insert.execute(data);
	}
}
