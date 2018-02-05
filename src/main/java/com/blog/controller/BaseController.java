package com.blog.controller;

import java.io.UnsupportedEncodingException;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.blog.listener.HelloWorld;
import com.blog.pojo.User;
import com.blog.service.UserService;
import com.blog.tool.IPUtils;
import com.blog.tool.Test;


@Controller
public class BaseController {
	
	
	@Autowired
	UserService userService;
	
	@RequestMapping("/index")
	@ResponseBody
	public String welcome(@RequestParam("name") String name,
			HttpServletRequest request) {
		User userTemp = new User();
		userTemp.setUsername(name);
		User user = userService.getUser(userTemp);
		user.setCredit(user.getCredit()+1);
		user.setLastVisit(new Date());
		user.setLastIp(IPUtils.getRemortIP(request));
		userService.updateUser(user);
		return userService.getUser(user).toString();
	}
	
	@RequestMapping("/delete")
	@ResponseBody
	public String del(@RequestParam("name") String name,
			HttpServletRequest request,
			HttpServletResponse response) throws UnsupportedEncodingException {
		User userTemp = new User();
		userTemp.setUsername(name);
		User user = userService.getUser(userTemp);
		response.setHeader("Content-type", "text/html;charset=UTF-8"); 
		response.setCharacterEncoding("UTF-8");
		if (user==null) {
			return name+" is no exist!";
		}
		userService.deleteUser(user);
		return name+" delete success!";
	}
	
	@RequestMapping("/register")
	@ResponseBody
	public String register(@RequestParam("name") String name,
			@RequestParam("password") String password,
			HttpServletRequest request) {
		User user = new User(name, password, request);
		user.setLastVisit(new Date());
		userService.addUser(user);
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
			//@RequestParam(name="cId",required=true)String cId,
			@RequestParam(name="myName",required=true)String myName,
			@RequestParam(name="toName",required=true)String name)throws Exception {
		
		if (name.equals("a")) {
			new HelloWorld().test(value,name,Test.a);
		}else if (name.equals("b")) {
			new HelloWorld().test(value,name,Test.b);
		}
		
		//producerService.sendMessage(receiveQueue, "my name is cyj!"); 
	}
}
