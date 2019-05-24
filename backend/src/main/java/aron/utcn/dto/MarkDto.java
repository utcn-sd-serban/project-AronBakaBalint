package aron.utcn.dto;

import aron.utcn.model.Mark;
import lombok.Data;

@Data
public class MarkDto {

	private int id;
	private String studentName;
	private String subject;
	private int value;
	
	public static MarkDto ofEntity(Mark mark) {
		MarkDto markDto = new MarkDto();
		markDto.setId(mark.getId());
		markDto.setStudentName(mark.getStudentName());
		markDto.setValue(mark.getValue());
		
		return markDto;
	}
}
