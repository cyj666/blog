package com.blog.mapper;

import java.util.List;

import com.blog.pojo.Post;

public interface PostMapper {
	public List<Post> getAllPost();
	public List<Post> getPosts(Post post);
	public Post getPost(Post post);
	public void addPost(Post post);
	public void deletePost(Post post);
	public void updatePost(Post post);
}
