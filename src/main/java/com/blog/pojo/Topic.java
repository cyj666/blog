package com.blog.pojo;

import java.util.Date;
import java.util.List;

public class Topic extends BaseDomain {
	
	public Topic() {
		// TODO Auto-generated constructor stub
	}

	//private MainPost mainPost;//对应主帖子
	
	private List<Post> posts;//对应的全部帖子
		
	private Integer topicId;   //主题ID
	
	private Date createTime; //主题创建时间
	
	private Date lastPost;  //最后的帖子发表时间
	
	private int views;    //浏览数
	
	private int replies;  //回复数
	
	private int digest;   //收藏数？不清楚

	/*public MainPost getMainPost() {
		return mainPost;
	}

	public void setMainPost(MainPost mainPost) {
		this.mainPost = mainPost;
	}*/


	public Integer getTopicId() {
		return topicId;
	}

	public void setTopicId(Integer topicId) {
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

	
	
	public List<Post> getPosts() {
		return posts;
	}

	public void setPosts(List<Post> posts) {
		this.posts = posts;
	}

	@Override
	public String toString() {
		return "Topic [posts=" + posts + ", topicId=" + topicId + ", createTime="
				+ createTime + ", lastPost=" + lastPost + ", views=" + views + ", replies=" + replies + ", digest="
				+ digest + "]";
	}
		
	
	
	
	//private User user;    
	
	
}
