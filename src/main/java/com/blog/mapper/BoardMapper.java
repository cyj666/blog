package com.blog.mapper;

import java.util.List;

import com.blog.pojo.Board;

public interface BoardMapper {
	
	public List<Board> getAllBoard();
	public Board getBoard(Board board);
	public void addBoard(Board board);
	public void deleteBoard(Board board);
	public void updateBoard(Board board);

}
