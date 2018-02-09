package com.blog.pojo;

import java.util.Date;

//帖子类
public class Post extends BaseDomain {

	public Post() {
		// TODO Auto-generated constructor stub
	}
	
	private int postId;  //帖子ID
	
	private int topicId;//对应主题id
	
	private int postType;//帖子种类
	
	private String postTitle;  
	
	private String postText;
	
	private Date createTime; //帖子创建时间

	public int getPostId() {
		return postId;
	}

	public void setPostId(int postId) {
		this.postId = postId;
	}

	public int getTopicId() {
		return topicId;
	}

	public void setTopicId(int topicId) {
		this.topicId = topicId;
	}

	public int getPostType() {
		return postType;
	}

	public void setPostType(int postType) {
		this.postType = postType;
	}

	public String getPostTitle() {
		return postTitle;
	}

	public void setPostTitle(String postTitle) {
		this.postTitle = postTitle;
	}

	public String getPostText() {
		return postText;
	}

	public void setPostText(String postText) {
		this.postText = postText;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	@Override
	public String toString() {
		return "Post [postId=" + postId + ", topicId=" + topicId + ", postType=" + postType + ", postTitle=" + postTitle
				+ ", postText=" + postText + ", createTime=" + createTime + "]";
	}
	
	
	
}
