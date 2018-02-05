package com.blog.pojo;

import java.util.Date;

public class Topic extends BaseDomain {
	
	public Topic() {
		// TODO Auto-generated constructor stub
	}

	private MainPost mainPost;//对应主帖子
		
	private int topicId;
	
	private Date createTime; //主题创建时间
	
	private Date lastPost;  //最后的帖子发表时间
	
	private int views;    //浏览数
	
	private int replies;  //回复数
	
	private int digest;   //收藏数？不清楚

	public MainPost getMainPost() {
		return mainPost;
	}

	public void setMainPost(MainPost mainPost) {
		this.mainPost = mainPost;
	}


	public int getTopicId() {
		return topicId;
	}

	public void setTopicId(int topicId) {
		this.topicId = topicId;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Date getLastPost() {
		return lastPost;
	}

	public void setLastPost(Date lastPost) {
		this.lastPost = lastPost;
	}

	public int getViews() {
		return views;
	}

	public void setViews(int views) {
		this.views = views;
	}

	public int getReplies() {
		return replies;
	}

	public void setReplies(int replies) {
		this.replies = replies;
	}

	public int getDigest() {
		return digest;
	}

	public void setDigest(int digest) {
		this.digest = digest;
	}
	
	//private User user;    
}
