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
import com.blog.service.ForumService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@Controller
public class PostController {


	@Autowired
	ForumService forumService;
	
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
		Board board = forumService.getBoardLinkTopicByTopicId(topicId);
		model.addAttribute("board", board);
		return "/post";
	}
}
