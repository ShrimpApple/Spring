package com.company.repository;

import java.util.List;

import com.company.dto.MemberDTO;


public interface MemberRepository {
	
	
	 int save(MemberDTO memberDTO);

	 MemberDTO login(MemberDTO memberDTO);		

	List<MemberDTO> findAll();

	MemberDTO findById(Long id);

	 void delete(Long id);

	MemberDTO findByMemberEmail(String loginEmail);

	int update(MemberDTO memberDTO);
}
