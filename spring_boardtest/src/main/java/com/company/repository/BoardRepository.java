package com.company.repository;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import com.company.dto.BoardDTO;

import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor
public class BoardRepository {
	private final SqlSessionTemplate sql;
	
	public int save(BoardDTO boardDTO) {
		
		return sql.insert("Board.save", boardDTO);
	}

	public void updateHits(Long id) {
		sql.update("Board.updateHits", id);
	}

	public BoardDTO findById(Long id) {
		return sql.selectOne("Board.findById", id);
	}

	public List<BoardDTO> findAll() {
		return sql.selectList("Board.findAll");
	}

	public void delete(Long id) {
		sql.delete("Board.delete", id);
	}

	public void update(BoardDTO boardDTO) {
		sql.update("Board.update", boardDTO);
	}

	public List<BoardDTO> pagingList(Map<String, Integer> pagingParams) {
		return sql.selectList("Board.pagingList", pagingParams);
	}

	public int boardCount() {
		return sql.selectOne("Board.boardCount");
	}
}
