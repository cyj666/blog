package com.blog.service;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.shiro.authc.UsernamePasswordToken;

import com.blog.pojo.User;

public interface UserService {

	public User getUserById(int id);	
	public User getUserByUsername(String username);
	public User getUser(User user);
	public List<User> getUsers(User user);
	public void addUser(User user);
	public void deleteUser(User user);	
	public void updateUser(User user);
	public void lockUser(User user);
	public void unlockUser(User user);
	public void setStatus(User user,int status);
	public void setCredit(User user,int credit);
	public void setLastVisit(User user,Date lastVisit);
	public void setLastIp(User user,String lastIp);
	public List<User> getAllUser();
	public UsernamePasswordToken loginSuccess(String username,String password,HttpServletRequest request);
	//public User findUserByUsername(String username); 
	
	//public User solrTest(int userId);
}
