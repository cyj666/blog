package com.blog.service;


import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpServletRequest;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.crypto.hash.SimpleHash;
/*import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.client.solrj.impl.HttpSolrServer;
import org.apache.solr.client.solrj.response.QueryResponse;*/
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.blog.mapper.UserMapper;
import com.blog.pojo.User;
import com.blog.tool.IPUtils;


@Service
public class UserServiceImpl implements UserService {

	private final static Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);
	
	@Autowired
	UserMapper usermapper;
	
	/*@Autowired  
    private HttpSolrServer httpSolrServer;*/
		
	@Override
	public void addUser(User user) {
		// TODO Auto-generated method stub
		SimpleHash simpleHash = new SimpleHash("MD5", user.getPassword());
		user.setPassword(simpleHash.toString());
		 int i = usermapper.addUser(user);
		 logger.debug("执行成功条数："+i);
		 logger.debug("用户"+user.getUsername()+"添加成功！");
	}

	@Override
	public User getUser(User user) {
		// TODO Auto-generated method stub
		logger.debug("用户"+user.getUsername()+"查询成功！");
		return usermapper.getUser(user);
		
	}

	@Override
	public void deleteUser(User user) {
		// TODO Auto-generated method stub
		usermapper.deleteUser(user);
		logger.debug("用户"+user.getUsername()+"删除成功！");
	}

	@Override
	public void updateUser(User user) {
		// TODO Auto-generated method stub
		SimpleHash simpleHash = new SimpleHash("MD5", user.getPassword());
		user.setPassword(simpleHash.toString());
		usermapper.updateUser(user);
		logger.debug("用户"+user.getUsername()+"修改成功！");
	}

	
	@Override
	public void lockUser(User user) {
		// TODO Auto-generated method stub
		boolean locked = user.getLocked();
		if (!locked) {  //判断有没有被锁
			user.setLocked(Boolean.TRUE);  
		}
		usermapper.updateUser(user);
		logger.debug("用户"+user.getUsername()+"已被锁上！");
	}

	@Override
	public void unlockUser(User user) {
		// TODO Auto-generated method stub
		boolean locked = user.getLocked();
		if (locked) {  //判断有没有被锁
			user.setLocked(Boolean.FALSE);  
		}
		usermapper.updateUser(user);
		logger.debug("用户"+user.getUsername()+"已解锁！");
	}

	@Override
	public void setStatus(User user, int status) {
		// TODO Auto-generated method stub
		user.setStatus(status);
		usermapper.updateUser(user);
		logger.debug("用户"+user.getUsername()+"变更了状态！"+"当前状态值为:"+user.getStatus());
	}

	@Override
	public void setCredit(User user, int credit) {
		// TODO Auto-generated method stub
		user.setCredit(credit);
		usermapper.updateUser(user);
		logger.debug("用户"+user.getUsername()+"变更了积分！"+"当前积分为:"+user.getCredit());
	}

	@Override
	public void setLastVisit(User user, Date lastVisit) {
		// TODO Auto-generated method stub
		user.setLastVisit(lastVisit);
		usermapper.updateUser(user);
		logger.debug("用户"+user.getUsername()+"变更了最后登录时间！"+"最后登录时间为:"+user.getLastVisit());
	}

	@Override
	public void setLastIp(User user, String lastIp) {
		// TODO Auto-generated method stub
		user.setLastIp(lastIp);
		usermapper.updateUser(user);
		logger.debug("用户"+user.getUsername()+"变更了最后登录IP！最后登录IP为："+user.getLastIp());
	}

	@Override
	public User getUserById(int id) {
		// TODO Auto-generated method stub
		User user = new User();
		user.setUserId(id);
		return getUser(user);
	}

	@Override
	public User getUserByUsername(String username) {
		// TODO Auto-generated method stub
		User user = new User();
		user.setUsername(username);
		return getUser(user);
	}

	@Override
	public List<User> getAllUser() {
		// TODO Auto-generated method stub
		return usermapper.getAllUser();
	}

	@Override
	public UsernamePasswordToken loginSuccess(String username,String password,HttpServletRequest request) {
		// TODO Auto-generated method stub
		UsernamePasswordToken token = new UsernamePasswordToken(username, password);
		token.setHost(IPUtils.getRemortIP(request));
		//默认记住我
		token.setRememberMe(true);
		Subject subject = SecurityUtils.getSubject();
	    subject.login(token); 
	    return token;	       
	}

	@Override
	public List<User> getUsers(User user) {
		// TODO Auto-generated method stub
		
		return usermapper.getUsers(user);
	}




	/*public User solrTest(int userId) {
		SolrQuery solrQuery = new SolrQuery();
		solrQuery.setQuery("id:"+userId);
		QueryResponse queryResponse = null;
		try {
			queryResponse = this.httpSolrServer.query(solrQuery);
			System.out.println(queryResponse);
		} catch (SolrServerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println((User)queryResponse.getBeans(User.class));
		return (User) queryResponse.getBeans(User.class); 
	}*/
	
	  /*public List<User> search(int keywords, Integer page, Integer rows) throws Exception {
	        SolrQuery solrQuery = new SolrQuery(); //构造搜索条件
	        solrQuery.setQuery("id:" + keywords); //搜索关键词
	        // 设置分页 start=0就是从0开始，，rows=5当前返回5条记录，第二页就是变化start这个值为5就可以了。
	        solrQuery.setStart((Math.max(page, 1) - 1) * rows);
	        solrQuery.setRows(rows);       
	        // 执行查询
	        QueryResponse queryResponse = this.httpSolrServer.query(solrQuery);
	        List<User> users = queryResponse.getBeans(User.class);	     
	            // 将高亮的标题数据写回到数据对象中
	            Map<String, Map<String, List<String>>> map = queryResponse.getHighlighting();
	            for (Map.Entry<String, Map<String, List<String>>> highlighting : map.entrySet()) {
	                for (User u : users) {
	                    if (!highlighting.getKey().equals(u.getUserId())) {
	                        continue;
	                    }  
	                    break;
	                }
	            }
	        

	        return users;
	    }*/



	
}
