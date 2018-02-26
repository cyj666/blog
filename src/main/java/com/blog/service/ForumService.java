package com.blog.service;

import java.util.List;

import com.blog.pojo.Board;
import com.blog.pojo.Post;
import com.blog.pojo.Topic;
import com.blog.pojo.User;

public interface ForumService {

	/**
	 * 主题方法
	 * @param topic
	 */
	public void addTopic(Topic topic);//添加主题
	public int addTopicLinkPost(int topicId,int postId);
	public void removeTopic(Topic topic);
	public void removeTopic(int topicId);
	public void updateTopic(Topic topic);//更新
	public int makeDigestTopic(int topicId);//设置收藏主题数量
	public Topic getTopicById(int topicId);
	public Topic getTopic(Topic topic);
	public Topic getTopicLinkPost(int topicId);
	public List<Topic> getTopicLinkPost();
	public List<Topic> getTopicByBoardName(String boardName);
	public List<Topic> getTopicByRand();
	
	
	
	/**
	 * 帖子方法
	 * @param post
	 */
	public void addPost(Post post);//增加帖子
	public void removePost(Post post);
	public void removePost(int postId);
	public void updatePost(Post post);
	public Post getPostById(int postId);
	public Post getPost(Post post);
	public Post getPostByPost(Post post);
	public List<Post> getPostsByTopicId(int topicId,int postType);
	public int getUserIdByPost(int postId);
	public int getPostCountBytopicId(int topicId);
	
	
	
	/**
	 * 版块方法
	 * @param board
	 */
	public void addBoard(Board board);//增加版块
	public void addBoard(int boardId,int topicId);//增加版块
	public void removeBoard(Board board);
	public void removeBoard(int boardId);
	public void updateBoard(Board board);
	public List<Board> getAllBoards();//得到所有的Board（其中不包含topic）
	public List<Board> getBoardLinkTopics();//连接多个表之后得到所有的Board（其中包含topic）
	public Board getBoardById(int boardId);
	public Board getBoardByName(String boardName);
	public Board getBoardLinkTopic(int boardId);
	public Board getBoardLinkTopic(String boardName);
	public void addBoardManager(int boardId,User user); //设置版块管理员
	public List<Board> getBoardByRand();
	public Board getBoardLinkTopicByTopicId(int topicId);


	
	


	
	
}
