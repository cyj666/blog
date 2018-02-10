package com.blog.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.blog.pojo.Board;
import com.blog.pojo.Post;
import com.blog.pojo.Topic;
import com.blog.service.ForumService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@Controller
public class BoardController {

	@Autowired
	ForumService forumService;

	@RequestMapping(value = "/board", method = RequestMethod.GET)
	public String board(Model model, 
			@RequestParam(value = "page", required = true, defaultValue = "1") Integer page,
			@RequestParam(value = "pageSize", required = false, defaultValue = "10") Integer pageSize) {
		PageHelper.startPage(page, pageSize);
		List<Board> boards = forumService.getBoardLinkTopics();

		PageInfo<Board> p = new PageInfo<>(boards);

		model.addAttribute("boards", boards);
		model.addAttribute("page", p);
		return "/board";
	}



}
