package com.blog.service;

import java.util.List;

import com.blog.pojo.Board;
import com.blog.pojo.Post;
import com.blog.pojo.Topic;
import com.blog.pojo.User;

public interface ForumService {

	public void addTopic(Topic topic);//添加主题
	public int addTopicLinkPost(int topicId,
			int postId);
	public void removeTopic(Topic topic);
	public void removeTopic(int topicId);
	
	
	public void addPost(Post post);//增加帖子
	public void removePost(Post post);
	public void removePost(int postId);
	
	
	public void addBoard(Board board);//增加版块
	public void removeBoard(Board board);
	public void removeBoard(int boardId);
	
	
	public int makeDigestTopic(int topicId);//设置收藏主题数量
	public List<Board> getAllBoards();
	public List<Board> getBoardLinkTopics();
	
	
	//暂时不写分页类
	
	public Topic getTopicById(int topicId);
	public Topic getTopicLinkPost(int topicId);
	public List<Topic> getTopicLinkPost();
	public List<Topic> getTopicByBoardName(String boardName);
	public Board getBoardById(int boardId);
	public Board getBoardByName(String boardName);
	public Board getBoardLinkTopic(int boardId);
	public Board getBoardLinkTopic(String boardName);
	public Post getPostById(int postId);
	public List<Post> getPostsByTopicId(int topicId,int postType);
	public void addBoardManager(int boardId,User user); //设置版块管理员
	
	
	
	public void updateTopic(Topic topic);//更新
	public void updatePost(Post post);
	public void updateBoard(Board board);
	
	
}
