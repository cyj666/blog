package com.blog.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.blog.mapper.BoardMapper;
import com.blog.mapper.PostMapper;
import com.blog.mapper.TopicMapper;
import com.blog.pojo.Board;
import com.blog.pojo.Post;
import com.blog.pojo.Topic;
import com.blog.pojo.User;


@Service
public class ForumServiceImpl implements ForumService {
	
	private final static Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);
	
	@Autowired
	BoardMapper boardMapper;
	
	@Autowired
	PostMapper postMapper;
	
	@Autowired
	TopicMapper topicMapper;
	
	
	@Override
	public void addTopic(Topic topic) {
		// TODO Auto-generated method stub
		topicMapper.addTopic(topic);
	}

	@Override
	public void removeTopic(Topic topic) {
		// TODO Auto-generated method stub
		topicMapper.deleteTopic(topic);
	}

	@Override
	public void removeTopic(int topicId) {
		// TODO Auto-generated method stub
		Topic topic = new Topic();
		topic.setTopicId(topicId);
		topicMapper.deleteTopic(topic);
	}

	@Override
	public void addPost(Post post) {
		// TODO Auto-generated method stub
		postMapper.addPost(post);
	}

	@Override
	public void removePost(Post post) {
		// TODO Auto-generated method stub
		postMapper.deletePost(post);
	}

	@Override
	public void removePost(int postId) {
		// TODO Auto-generated method stub
		Post post = new Post();
		post.setPostId(postId);
		postMapper.deletePost(post);
	}

	@Override
	public void addBoard(Board board) {
		// TODO Auto-generated method stub
		boardMapper.addBoard(board);
	}

	@Override
	public void removeBoard(Board board) {
		// TODO Auto-generated method stub
		boardMapper.deleteBoard(board);
	}

	@Override
	public void removeBoard(int boardId) {
		// TODO Auto-generated method stub
		Board board = new Board();
		board.setBoardId(boardId);
		boardMapper.deleteBoard(board);
	}

	//查询收藏数
	@Override
	public int makeDigestTopic(int topicId) {
		// TODO Auto-generated method stub
		Topic topic = new Topic();
		topic.setTopicId(topicId);
		Topic topic2 = topicMapper.getTopic(topic);
		return topic2.getDigest();
	}

	@Override
	public List<Board> getAllBoards() {
		// TODO Auto-generated method stub
		return boardMapper.getAllBoard();
	}

	@Override
	public Topic getTopicById(int topicId) {
		// TODO Auto-generated method stub
		Topic topic = new Topic();
		topic.setTopicId(topicId);
		return topicMapper.getTopic(topic);
	}

	@Override
	public Board getBoardById(int boardId) {
		// TODO Auto-generated method stub
		Board board = new Board();
		board.setBoardId(boardId);
		return boardMapper.getBoard(board);
	}

	@Override
	public Post getPostById(int postId) {
		// TODO Auto-generated method stub
		Post post = new Post();
		post.setPostId(postId);
		post =postMapper.getPost(post);
		return post;
	}

	@Override
	public void addBoardManager(int boardId, User user) {
		// TODO Auto-generated method stub
		boardMapper.addBoardManager(boardId, user.getUserId());
	}

	@Override
	public void updateTopic(Topic topic) {
		// TODO Auto-generated method stub
		topicMapper.updateTopic(topic);
	}

	@Override
	public void updatePost(Post post) {
		// TODO Auto-generated method stub
		postMapper.updatePost(post);
	}

	@Override
	public void updateBoard(Board board) {
		// TODO Auto-generated method stub
		boardMapper.updateBoard(board);
	}

	@Override
	public int addTopicLinkPost(int topicId, int postId) {
		// TODO Auto-generated method stub
		return topicMapper.addTopicLinkPost(topicId, postId);
	}

	@Override
	public Topic getTopicLinkPost(int topicId) {
		return topicMapper.getTopicLinkPost(topicId,1);
	}

	@Override
	public Board getBoardLinkTopic(int boardId) {
		// TODO Auto-generated method stub
		Board board = new Board();
		board.setBoardId(boardId);
		return boardMapper.getBoardLinkTopic(board);
	}

	@Override
	public Board getBoardByName(String boardName) {
		Board board = new Board();
		board.setBoardName(boardName);
		return boardMapper.getBoard(board);
	}

	@Override
	public List<Board> getBoardLinkTopics() {
		// TODO Auto-generated method stub		
		return boardMapper.getBoardLinkTopics();
	}

	@Override
	public Board getBoardLinkTopic(String boardName) {
		// TODO Auto-generated method stub
		Board board = new Board();
		board.setBoardName(boardName);
		return boardMapper.getBoardLinkTopic(board);
	}

	@Override
	public List<Topic> getTopicLinkPost() {
		// TODO Auto-generated method stub
		return topicMapper.getTopicLinkPost();
	}

	@Override
	public List<Topic> getTopicByBoardName(String boardName) {
		// TODO Auto-generated method stub
		return topicMapper.getTopicByBoardName(boardName);
	}

	@Override
	public List<Post> getPostsByTopicId(int topicId,int postType) {
		// TODO Auto-generated method stub
		return postMapper.getPostsByTopicId(topicId,postType);
	}

	@Override
	public List<Board> getBoardByRand() {
		// TODO Auto-generated method stub
		return boardMapper.getBoardByRand();
	}

	@Override
	public List<Topic> getTopicByRand() {
		// TODO Auto-generated method stub
		return topicMapper.getTopicByRand();
	}

	@Override
	public Board getBoardLinkTopicByTopicId(int topicId) {
		// TODO Auto-generated method stub
		return boardMapper.getBoardLinkTopicByTopicId(topicId);
	}

}
