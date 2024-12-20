package com.company.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class MemberDTO {
	private Long id;
	private String memberName;
	private int memberKor;
	private int memberEngnum;
	private int memberMatnum;
}
