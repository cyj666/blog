package com.blog.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.blog.pojo.Post;
import com.blog.pojo.Topic;
import com.blog.service.ForumService;

@Controller
public class IndexController {
	
	@Autowired
	ForumService forumService;
	
	
	@ResponseBody
	@RequestMapping(value="/do",method=RequestMethod.GET,produces = "application/json;charset=utf-8")
	public String event(@RequestParam(value="event",required=true)String event) {
		Topic topic = new Topic();
		Post post = new Post();
		List<Post> posts = new ArrayList<>();
		String json = "";
		
		switch (event) {
		case "flushPosts":
			topic = forumService.getTopicLinkPost(1);
			//posts = topic.get
			json = JSON.toJSONString(topic);
			
			break;
		
		default:
			break;
		}
		return json;
	}
}
