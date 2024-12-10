package com.company.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.company.dto.BoardDTO;
import com.company.dto.CommentDTO;
import com.company.repository.CommentRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CommentService {

	private final CommentRepository commentRepository;

	public void save(CommentDTO commentDTO) {
		commentRepository.save(commentDTO);
	}

	public List<CommentDTO> findAll(Long boardId) {
		return commentRepository.findAll(boardId);
	}

	public void delete(Long id) {
		commentRepository.delete(id);
	}
	
	public CommentDTO findById(Long id) {
		return commentRepository.findById(id);
	}

	public void updateHits(Long id) {
		commentRepository.updateHits(id);		
	}
	
}
