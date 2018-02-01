package com.blog.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.blog.listener.HelloWorld;
import com.blog.pojo.User;
import com.blog.service.UserService;
import com.blog.tool.Test;


@Controller
public class BaseController {
	
	
	@Autowired
	UserService userService;
	
	@RequestMapping("/index")
	@ResponseBody
	public String welcome(@RequestParam("name") String name) {
		User userTemp = new User();
		userTemp.setUsername(name);
		User user = userService.getUser(userTemp);
		user.setPassword("admin");
		userService.updateUser(user);
		return userService.getUser(user).toString();
	}
	
	
	@RequestMapping("/{active}")
	public String active(@PathVariable String active) {
		return active;
	}
	
	@ResponseBody
	@RequestMapping(value="/start",method=RequestMethod.GET)
	public void test2(HttpServletRequest request,
			@RequestParam(name="cId",required=true)String cId,
			@RequestParam(name="name",required=true)String name)throws Exception {
		if (name.equals("a")) {
			Test.a = cId;
		}else if (name.equals("b")) {
			Test.b = cId;
		}
	}
	
	@ResponseBody
	@RequestMapping(value="/test",method=RequestMethod.GET)
	public void test(@RequestParam(name="value",required=true)String value,
			@RequestParam(name="cId",required=true)String cId,
			@RequestParam(name="name",required=true)String name)throws Exception {
		/*HttpSession session = request.getSession();
		if (session.getAttribute("sessionId")==null) {
			session.setAttribute("sessionId", session.getId());
		}*/
		if (name.equals("a")) {
			new HelloWorld().test(value,Test.a);
		}else if (name.equals("b")) {
			new HelloWorld().test(value,Test.b);
		}
		
		//producerService.sendMessage(receiveQueue, "my name is cyj!"); 
	}
}
