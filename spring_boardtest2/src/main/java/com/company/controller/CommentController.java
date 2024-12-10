package com.company.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.company.dto.CommentDTO;
import com.company.service.CommentService;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
@RequestMapping("/comment")
public class CommentController {

	private final CommentService commentService;
	
	@PostMapping("/save")
	public @ResponseBody List<CommentDTO> save(@ModelAttribute CommentDTO commentDTO) {
		System.out.println("commentDTO = " + commentDTO);
		commentService.save(commentDTO);
		// 해당 게시글에 작성된 댓글 리스트 가져옴
		List<CommentDTO> commentDTOList = commentService.findAll(commentDTO.getBoardId());
		return commentDTOList;
	}
	
	@GetMapping("/delete")
	public String delete(@RequestParam("id") Long id) {
		commentService.delete(id);
		return "redirect:/comment/";
	}
	
	@GetMapping
	public String findById(@RequestParam("id") Long id,
		@RequestParam(value = "page", required = false, defaultValue = "1") int page, Model model) {
		commentService.updateHits(id);
		CommentDTO CommentDTO = commentService.findById(id);
		model.addAttribute("board", CommentDTO);
		model.addAttribute("page", page);
		List<CommentDTO> commentDTOList = commentService.findAll(id);
		model.addAttribute("commentList", commentDTOList);
		return "detail";
	}
	
	
	@GetMapping("/update")
	public String updateForm(@RequestParam("id") Long id, Model model) {
		CommentDTO commentDTO = commentService.findById(id);
		model.addAttribute("comment", commentDTO);
		return "update";
	}
}	
