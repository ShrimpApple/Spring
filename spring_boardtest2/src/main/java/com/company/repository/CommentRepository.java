package com.company.repository;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import com.company.dto.BoardDTO;
import com.company.dto.CommentDTO;

import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor
public class CommentRepository {
	
	private final SqlSessionTemplate sql;

	public void save(CommentDTO commentDTO) {
		sql.insert("Comment.save", commentDTO);
	}

	public List<CommentDTO> findAll(Long boardId) {
		return sql.selectList("Comment.findAll", boardId);
	}

	public void delete(Long id) {
		sql.delete("Comment.delete", id);	
	}

	public CommentDTO findById(Long id) {
		return sql.selectOne("comment.findById", id);
	}

	public void updateHits(Long id) {
		sql.update("Comment.updateHits", id);
	}
}
