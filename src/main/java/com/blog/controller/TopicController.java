package com.blog.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.blog.pojo.Topic;
import com.blog.service.ForumService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@Controller
public class TopicController {

	
	@Autowired
	ForumService forumService;
	
	@RequestMapping(value = "/topic", method = RequestMethod.GET)
	public String topic(Model model, 
			@RequestParam(value = "boardName", required = false) String boardName,
			@RequestParam(value = "boardId", required = false) Integer boardId,
			@RequestParam(value = "page", required = true, defaultValue = "1") Integer page,
			@RequestParam(value = "pageSize", required = false, defaultValue = "10") Integer pageSize) {
		
		if ((boardName == null || boardName == "") && boardId == null) {
			model.addAttribute("msg", "火星了！该主题不存在。");
			return "/topic";
		}
		PageHelper.startPage(page, pageSize);
		List<Topic> topics = forumService.getTopicByBoardName(boardName);
		if (topics.size()==0||topics==null) {
			model.addAttribute("msg", "火星了！该主题不存在。");
			return "/topic";
		}
		PageInfo<Topic> p = new PageInfo<>(topics);
		model.addAttribute("page", p);
		model.addAttribute("topics", topics);
		model.addAttribute("boardName", boardName);
		model.addAttribute("board", forumService.getBoardByName(boardName));//版块
		return "/topic";
	}
	
	@RequestMapping(value = "/count")
	@ResponseBody
	public int getCount(@RequestParam("topicId")int topicId) {
		int count = forumService.getPostCountBytopicId(topicId);
		return count;
	}

}
