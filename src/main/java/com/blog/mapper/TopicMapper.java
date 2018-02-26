package com.blog.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.blog.pojo.Topic;

public interface TopicMapper {

	public Topic getTopicLinkPost(@Param("topicId")int topicId,@Param("event")int event);  //连接topics表和posts表查
	public List<Topic> getTopicLinkPost(); 
	public Topic getTopic(Topic topic); //单独查topics表
	public List<Topic> getAllTopic();
	public List<Topic> getTopicByBoardName(@Param("boardName")String boardName);
	public List<Topic> getTopicByRand();
	public int getPostCountBytopicId(@Param("topicId")int topicId);
	
	public int addTopic(Topic topic);
	public int addTopicLinkPost(@Param("topicId")int topicId,
			@Param("postId")int postId);
	
	public int deleteTopic(Topic topic);
	public int deleteTopicLinkPost(@Param("topicId")int topicId,
			@Param("postId")int postId);
	
	public int updateTopic(Topic topic);
	public int updatePostLinkPost(@Param("topicId")int topicId,
			@Param("postId")int postId);
		
	
}
