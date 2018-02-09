package com.blog.pojo;

import java.util.List;

//论坛板块类
public class Board extends BaseDomain {

	public Board() {
		// TODO Auto-generated constructor stub
	}
	
	private long boardId;  //论坛板块ID
	
	private String boardName;  //版块名
	
	private String boardDesc;  //版块描述
	
	//private int topicNum;  //主题数量
	
	private List<Topic> topics;  //对应的主题

	public long getBoardId() {
		return boardId;
	}

	public void setBoardId(long boardId) {
		this.boardId = boardId;
	}

	public String getBoardName() {
		return boardName;
	}

	public void setBoardName(String boardName) {
		this.boardName = boardName;
	}

	public String getBoardDesc() {
		return boardDesc;
	}

	public void setBoardDesc(String boardDesc) {
		this.boardDesc = boardDesc;
	}

	
	/*public int getTopicNum() {
		return topics.size();
	}

	private void setTopicNum(int topicNum) {
		this.topicNum = topicNum;
	}*/

	public List<Topic> getTopics() {
		return topics;
	}

	public void setTopics(List<Topic> topics) {
		this.topics = topics;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (boardId ^ (boardId >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Board other = (Board) obj;
		if (boardId != other.boardId)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Board [boardId=" + boardId + ", boardName=" + boardName + ", boardDesc=" + boardDesc + ", topics="
				+ topics + "]";
	}

	
	
	
	
}
