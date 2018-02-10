package com.blog.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.blog.pojo.Board;

public interface BoardMapper {
	
	public List<Board> getAllBoard();
	public Board getBoard(Board board);//单独查boards表
	public Board getBoardLinkTopic(Board board);//查boards表和topics
	public List<Board> getBoardLinkTopics();//查boards表和topics
	public List<Board> getBoardByRand();//随机取10条数据
	public Board getBoardLinkTopicByTopicId(int topicId);
	
	
	public void addBoard(Board board);
	public void addBoardManager(@Param("boardId")int boardId,
			@Param("userId")int userId);
	public void addBoardLinkTopic(@Param("boardId")int boardId,
			@Param("topicId")int topicId);
	
	
	
	public void deleteBoard(Board board);
	public void deleteBoardLinkTopic(@Param("boardId")int boardId,
			@Param("topicId")int topicId);
	
	
	
	public void updateBoard(Board board);
	public void updateBoardLinkTopic(@Param("boardId")int boardId,
			@Param("topicId")int topicId);
	
}
