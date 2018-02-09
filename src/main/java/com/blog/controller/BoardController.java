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

	@RequestMapping(value = "/post", method = RequestMethod.GET)
	public String post(Model model, 
			@RequestParam(value = "topicName", required = false) String topicName,
			@RequestParam(value = "topicId", required = false) Integer topicId,
			@RequestParam(value = "page", required = true, defaultValue = "1") Integer page,
			@RequestParam(value = "pageSize", required = false, defaultValue = "10") Integer pageSize,
			@RequestParam(value = "boardName", required = false) String boardName) {
		
		if ((topicName == null || topicName == "") && topicId == null) {
			model.addAttribute("msg", "火星了！该贴不存在。");
			return "/post";
		}
		PageHelper.startPage(page, pageSize);
		List<Post> posts = forumService.getPostsByTopicId(topicId, 0);// 跟帖
		if (posts.size()==0||posts==null) {
			model.addAttribute("msg", "火星了！该贴不存在。");
			return "/post";
		}
		PageInfo<Post> p = new PageInfo<>(posts);
		model.addAttribute("page", p);
		model.addAttribute("posts", posts);
		List<Post> postsMain = forumService.getPostsByTopicId(topicId, 1);// 主帖子
		if (postsMain.size()==0||postsMain==null) {
			model.addAttribute("msg", "火星了！该贴不存在。");
			return "/post";
		}		
		
		model.addAttribute("postsMain", postsMain);
		model.addAttribute("boardName", boardName);
		return "/post";
	}

}
