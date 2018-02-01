package com.blog.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.blog.pojo.User;

public interface UserMapper {

	//public User getUserById(@Param("id") int id);
	
	//public User getUserByName(@Param("name") String name);
	
	/*public void addUser(@Param("username")String username,
			@Param("password")String password);*/
	public User getUser(User user);
	public List<User> getAllUser();
	public void addUser(User user);
	public void deleteUser(User user);	
	public void updateUser(User user);
	//public List<User> findUserByUsername(@Param("username")String username); 
	
	//public User findUserByUsername(@Param("username")String username); 
}

