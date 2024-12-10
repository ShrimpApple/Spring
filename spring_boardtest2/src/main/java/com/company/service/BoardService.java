package com.company.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.company.dto.BoardDTO;
import com.company.dto.PageDTO;
import com.company.repository.BoardRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class BoardService {
	
	private final BoardRepository boardRepository;

	public int save(BoardDTO boardDTO) {
		
		return boardRepository.save(boardDTO);
	}

	public void updateHits(Long id) {
		boardRepository.updateHits(id);
	}

	public BoardDTO findById(Long id) {
		return boardRepository.findById(id);
	}

	public List<BoardDTO> findAll() {
		return boardRepository.findAll();
	}

	public void delete(Long id) {
		boardRepository.delete(id);
	}

	public void update(BoardDTO boardDTO) {
		boardRepository.update(boardDTO);		
	}

	int pageLimit = 3; // 한 페이지당 보여줄 글 갯수
	int blockLimit = 3; // 하단에 보여줄 페이지 번호 갯수
	
	public List<BoardDTO> pagingList(int page) {
		int pageLimit = 3; // 한 페이지당 보여줄 글 갯수
		/*
		 1페이지당 보여지는 글 갯수3
		 	1page => 0
		 	2page => 3
		 	3page => 6
		 */
		int pagingStart = (page - 1) * pageLimit;
		Map<String, Integer> pagingParams = new HashMap<>();
		pagingParams.put("start", pagingStart);
		pagingParams.put("limit", pageLimit);
		List<BoardDTO> pagingList = boardRepository.pagingList(pagingParams);
		
		return pagingList;
	}

	public PageDTO pagingParam(int page) {
		// 전체 글 갯수 조회
		int boardCount = boardRepository.boardCount();
		// 전체 페이지 갯수 계산 (10/3=3.33333 => 4)
		int maxPage = (int)(Math.ceil((double) boardCount / pageLimit));
		// 시작 페이지 값 계산 (1, 4, 7, 10, ~~~~)
		int startPage = (((int)(Math.ceil((double) page / blockLimit))) - 1) * blockLimit + 1;
		// 끝 페이지 값 계산(3, 5, 9, 12, ~~~~)
		int endPage = startPage + blockLimit - 1;
		if (endPage > maxPage) {
			endPage = maxPage;
		}
		PageDTO pageDTO = new PageDTO();
		pageDTO.setPage(page);
		pageDTO.setMaxPage(maxPage);
		pageDTO.setStartPage(startPage);
		pageDTO.setEndPage(endPage);
		return pageDTO;
	}
}
