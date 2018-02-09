package com.blog.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.blog.pojo.User;

public interface UserMapper {

	public User getUser(User user);
	public User getUserLinkPost(User user);//查询某人的发帖
	public List<User> getUsers(User user);
	public List<User> getAllUser();
	
	public int addUser(User user);
	public int addUserPost(@Param("userId")int userId,@Param("postId")int postId); //发帖
	
	public void deleteUser(User user);	
	public void deleteUserPost(@Param("userId")int userId,@Param("postId")int postId);//删帖
	
	public void updateUser(User user);
	
	public User findUserByUsernameLinkRoleAndPermission(@Param("username")String username);
}

