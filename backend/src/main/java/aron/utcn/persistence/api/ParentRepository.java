package aron.utcn.persistence.api;

import java.util.List;

public interface ParentRepository {

	List<String> getChildren(String parentname);
	
	void insertParent(String childName, String parentName);
}
