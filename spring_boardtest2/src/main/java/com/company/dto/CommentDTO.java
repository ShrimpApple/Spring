package com.company.dto;

import java.sql.Timestamp;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class CommentDTO {
	
	private Long id;
	private String commentWriter;
	private String commentContents;
	private Long boardId;
	private Timestamp  commentCreatedTime;
}
