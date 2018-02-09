package com.blog.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.blog.pojo.Post;

public interface PostMapper {
	public List<Post> getAllPost();
	public List<Post> getPosts(Post post);
	public List<Post> getPostsByTopicId(@Param("topicId")int topicId,@Param("postType")int postType);
	public Post getPost(Post post);
	public void addPost(Post post);
	public void deletePost(Post post);
	public void updatePost(Post post);
}
