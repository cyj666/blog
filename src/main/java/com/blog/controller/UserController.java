package com.blog.controller;

import java.io.IOException;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.DisabledAccountException;
import org.apache.shiro.authc.ExcessiveAttemptsException;
import org.apache.shiro.authc.ExpiredCredentialsException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.UnauthorizedException;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.blog.pojo.Post;
import com.blog.pojo.User;
import com.blog.service.ForumService;
import com.blog.service.UserService;
import com.blog.tool.CaptchaUtil;
import com.blog.tool.IPUtils;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;



@Controller
public class UserController {

	@Autowired
	UserService userService;
	
	@Autowired
	ForumService forumService;
	
	
	
	@RequestMapping(value="/login.do",method=RequestMethod.POST)
	public String login(@RequestParam(value="username") String username,
			@RequestParam(value="password") String password,
			@RequestParam(value="captcha") String captcha,
			HttpServletRequest request,
			Model model) {
		String randomString = captcha.toUpperCase();
		HttpSession session = request.getSession();
		
		String msg = "";	
		User user =  new User();
		UsernamePasswordToken token = new UsernamePasswordToken(username, password);
		try {
			if (!session.getAttribute("randomString").equals(randomString)) {
				msg="验证码出错！请检查。";
				model.addAttribute("message", msg);	
				return "login";
			}

			//默认记住我
			
			token.setRememberMe(true);
			Subject subject = SecurityUtils.getSubject();
		    subject.login(token); 
		    msg="登录成功！登录IP:"+token.getHost();
		    
		    user =  userService.getUserByUsername(username);
		    userService.setCredit(user, user.getCredit()+1); //每次登录积分加一
		    userService.setLastVisit(user, new Date());
		    userService.setLastIp(user, IPUtils.getRemortIP(request));
		   // user =  userService.getUserByUsername(username);
	        model.addAttribute("message", msg);	
	        //model.addAttribute("user", user);	
	        return "redirect:/home";  
		} catch (IncorrectCredentialsException e) {  
	        msg = "登录密码错误. Password for account " + token.getPrincipal() + " was incorrect.";  
	        model.addAttribute("message", msg);  
	        System.out.println(msg);  
	    } catch (ExcessiveAttemptsException e) {  
	        msg = "登录失败次数过多";  
	        model.addAttribute("message", msg);  
	        System.out.println(msg);  
	    } catch (LockedAccountException e) {  
	        msg = "帐号已被锁定. The account for username " + token.getPrincipal() + " was locked.";  
	        model.addAttribute("message", msg);  
	        System.out.println(msg);  
	    } catch (DisabledAccountException e) {  
	        msg = "帐号已被禁用. The account for username " + token.getPrincipal() + " was disabled.";  
	        model.addAttribute("message", msg);  
	        System.out.println(msg);  
	    } catch (ExpiredCredentialsException e) {  
	        msg = "帐号已过期. the account for username " + token.getPrincipal() + "  was expired.";  
	        model.addAttribute("message", msg);  
	        System.out.println(msg);  
	    } catch (UnknownAccountException e) {  
	        msg = "帐号不存在. There is no user with username of " + token.getPrincipal();  
	        model.addAttribute("message", msg);  
	        System.out.println(msg);  
	    } catch (UnauthorizedException e) {  
	        msg = "您没有得到相应的授权！" + e.getMessage();  
	        model.addAttribute("message", msg);  
	        System.out.println(msg);  
	    } catch (AuthenticationException e) {
			// TODO: handle exception
	    	 msg = "验证错误" + e.getMessage();  
		     model.addAttribute("message", msg);  
		     System.out.println(msg);
		} catch (Exception e) {
			// TODO: handle exception
	    	 msg = "未知错误" + e.getMessage();  
		     model.addAttribute("message", msg);  
		     System.out.println(msg);
		} 				
		return "login"; 
				
	}
	
	/**
	 * 验证码实现
	 */
	@RequestMapping(value = "/captcha", method = RequestMethod.GET)
	@ResponseBody
	public void captcha(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		CaptchaUtil.outputCaptcha(request, response);
	}
	
	/**
	 * 
	 * @param request
	 * @param response
	 * @param model
	 * @return
	 * @throws IOException
	 */
	@RequestMapping(value = "/logout", method = RequestMethod.GET)  
	public String logout(HttpServletRequest request, HttpServletResponse response, Model model) throws IOException {  
		Subject subject = SecurityUtils.getSubject();
		subject.logout();
	    return "redirect:/home";
	}  
	
	@RequestMapping(value="/register",method=RequestMethod.GET)
	public String register(Model model) {
		User user = new User();
		model.addAttribute("user", user);
		return "register";
	}
	
	@RequestMapping(value="/register.do",method=RequestMethod.POST)
	//@ResponseBody
	public String register(@RequestParam("username") String username,
			@RequestParam("password") String password,
			@RequestParam("password2") String password2,
			@RequestParam(value="captcha") String captcha,
			HttpServletRequest request,
			Model model) {
		String randomString = captcha.toUpperCase();
		HttpSession session = request.getSession();
		String msg="";
		if (!session.getAttribute("randomString").equals(randomString)) {
			msg="验证码出错！请检查。";
			model.addAttribute("message", msg);	
			return "register";
		}
		if (!password.equals(password2)) {
			msg="两次密码不一致！";
			model.addAttribute("message", msg);	
			return "register";
		}
		
		User user = new User(username, password, request);
		user.setLastVisit(new Date());
		try {
			userService.addUser(user);
			msg="注册成功！";
			model.addAttribute("message", msg);			
		} catch (Exception e) {
			// TODO: handle exception
			msg="注册失败，出现异常！";
			model.addAttribute("message", msg);	
		}		
		return "redirect:register";
	}
	
	@RequestMapping(value="/user")
	public String User(@RequestParam("username")String username,
			@RequestParam(value = "page", required = true, defaultValue = "1") Integer page,
			@RequestParam(value = "pageSize", required = false, defaultValue = "10") Integer pageSize,
			Model model) {
		User user = userService.getUserByUsername(username);
		user = userService.getUserLinkPost(user);
		model.addAttribute("user", user);		
		List<Post> posts = user.getPosts();	
		model.addAttribute("posts", posts);
		return "/user";
	}
}
