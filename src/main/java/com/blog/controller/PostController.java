package com.blog.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authz.annotation.RequiresUser;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.blog.pojo.Board;
import com.blog.pojo.Post;
import com.blog.pojo.Topic;
import com.blog.pojo.User;
import com.blog.service.ForumService;
import com.blog.service.UserService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@Controller
public class PostController {


	@Autowired
	ForumService forumService;
	
	@Autowired
	UserService userService;
	
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
		if ((posts.size()==0||posts==null)&&topicId==null) {
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
	
	
	@RequestMapping("/postMain")
	@ResponseBody
	@RequiresUser
	public Integer postMain(@RequestParam(value="postTitle")String postTitle,
			@RequestParam(value="postText")String postText,
			@RequestParam(value="boardName")String boardName) {
		//String uuid = UUID.randomUUID().toString().replace("-", "");
		Date date = new Date();	
		String dateTemp =  new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(date);
		try {
			date = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(dateTemp);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Topic topic = new Topic();
		topic.setCreateTime(date);
		topic.setDigest(1);
		topic.setReplies(1);
		topic.setViews(1);
		topic.setLastPost(date);
		//topic.setTopicId(null);
		forumService.addTopic(topic);//增加主题
		topic = forumService.getTopic(topic);
		int topicId = topic.getTopicId();
		
		Post post = new Post();
		post.setCreateTime(date);
		post.setPostTitle(postTitle);
		post.setPostText(postText);
		post.setPostType(1);
		//post.setPostId(null);
		forumService.addPost(post);//增加帖子
		post = forumService.getPostByPost(post);
		int postId = post.getPostId();
		
		forumService.addTopicLinkPost(topicId, postId);
		
		String username = (String)SecurityUtils.getSubject().getPrincipal();
		User user = userService.getUserByUsername(username);
		userService.addUserPost(user.getUserId(), post.getPostId());
		
		Board board = forumService.getBoardByName(boardName);
		forumService.addBoard((int)board.getBoardId(), topicId);
		return 1;
	}
	
	@RequestMapping("/postOthers")
	@ResponseBody
	@RequiresUser
	public Integer postOthers(@RequestParam(value="postText")String postText,
			@RequestParam(value="postMainTitle")String postMainTitle,
			@RequestParam(value="postMainText")String postMainText
			) {
		Date date = new Date();	
		String dateTemp =  new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(date);
		try {
			date = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(dateTemp);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Post postMain = new Post();
		postMain.setPostTitle(postMainTitle);
		postMain.setPostText(postMainText);
		postMain.setPostType(1);
		postMain = forumService.getPost(postMain);//找到主帖子
		
		//postMain.getTopicId();
		
		Post post = new Post();
		post.setCreateTime(date);
		post.setPostText(postText);
		post.setPostTitle(postMain.getPostTitle());
		post.setPostType(0);
		forumService.addPost(post);
		post = forumService.getPostByPost(post);
		
		
		String username = (String)SecurityUtils.getSubject().getPrincipal();
		User user = userService.getUserByUsername(username);
		userService.addUserPost(user.getUserId(), post.getPostId());
		
		forumService.addTopicLinkPost(postMain.getTopicId(), post.getPostId());
		
		
		
		return 1;
	}
}
