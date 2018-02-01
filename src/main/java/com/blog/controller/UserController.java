package com.blog.controller;

import javax.servlet.http.HttpServletRequest;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.DisabledAccountException;
import org.apache.shiro.authc.ExcessiveAttemptsException;
import org.apache.shiro.authc.ExpiredCredentialsException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.UnauthorizedException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.blog.service.UserService;


@Controller
public class UserController {

	@Autowired
	UserService userService;
	
	
	@RequestMapping(value="/login",method=RequestMethod.POST)
	public String login(@RequestParam(value="username") String username,@RequestParam(value="password") String password,
			HttpServletRequest request,Model model) {
		String msg = "";
		UsernamePasswordToken token = null;
		try {
		 token = userService.loginSuccess(username, password, request);
		 msg="登录成功！登录IP:"+token.getHost();
	       // System.out.println(msg);  
	        model.addAttribute("message", msg);		        	       
	        return "index";  
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
}
