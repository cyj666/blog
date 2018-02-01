package com.blog.pojo;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;

import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.solr.client.solrj.beans.Field;
import org.apache.xmlbeans.impl.xb.ltgfmt.FileDesc.Role;
import org.hibernate.validator.constraints.NotBlank;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.NumberFormat;
import org.springframework.format.annotation.NumberFormat.Style;

import com.blog.tool.IPUtils;

public class User extends BaseDomain {

	private static final long serialVersionUID = -1672970955045193907L;  
	
	//@Field("id")
	private int userId;
	
	//@Field("name")
	//@NotBlank(message="不能为空")
	private String username;
	
	
	//@NotBlank(message="不能为空")
	private String password;
	
	private Integer status ;
	
	//private String passwordSalt;
	
	private boolean locked;
	
	private Set<Role> roleSet = new HashSet<Role>();  //用户角色
	 
	private Integer credit ;  //用户积分
	
	
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private Date lastVisit;  //最后登录时间
	
	private String lastIp; //最后登录IP
	
	private Set<Board> manBoards; //用户关注的主模块
	
	
	
	
	public User(String username,String password,HttpServletRequest request) {
		this.username = username;
		SimpleHash simpleHash = new SimpleHash("MD5", password);
		this.password = simpleHash.toString();
		this.password = password;
		this.credit = 0;
		this.status = Status.Normal;
		this.locked = Boolean.FALSE;
		this.lastVisit = new Date();
		this.lastIp = IPUtils.getRemortIP(request);
	}
	

	public Integer getCredit() {
		return credit;
	}





	public void setCredit(Integer credit) {
		this.credit = credit;
	}





	public Date getLastVisit() {
		return lastVisit;
	}





	public void setLastVisit(Date lastVisit) {
		this.lastVisit = lastVisit;
	}





	public String getLastIp() {
		return lastIp;
	}





	public void setLastIp(String lastIp) {
		this.lastIp = lastIp;
	}





	public User() {
		// TODO Auto-generated constructor stub
		
	}


	


	public int getUserId() {
		return userId;
	}





	public void setUserId(int userId) {
		this.userId = userId;
	}





	public String getUsername() {
		return username;
	}


	public void setUsername(String username) {
		this.username = username;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	/*public String getPasswordSalt() {
		return passwordSalt;
	}


	public void setPasswordSalt(String passwordSalt) {
		this.passwordSalt = passwordSalt;
	}
**/
	

	


	





	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((password == null) ? 0 : password.hashCode());
		result = prime * result + ((username == null) ? 0 : username.hashCode());
		return result;
	}


	@Override
	public String toString() {
		return "User [userId=" + userId + ", username=" + username + ", password=" + password + ", status=" + status
				+ ", locked=" + locked + ", roleSet=" + roleSet + ", credit=" + credit + ", lastVisit=" + lastVisit
				+ ", lastIp=" + lastIp + ", manBoards=" + manBoards + "]";
	}





	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		if (password == null) {
			if (other.password != null)
				return false;
		} else if (!password.equals(other.password))
			return false;
		if (username == null) {
			if (other.username != null)
				return false;
		} else if (!username.equals(other.username))
			return false;
		return true;
	}





	public boolean getLocked() {
		return locked;
	}





	public void setLocked(boolean locked) {
		this.locked = locked;
	}





	public Integer getStatus() {
		return status;
	}





	public void setStatus(Integer status) {
		this.status = status;
	}




	public Set<Role> getRoleSet() {
		return roleSet;
	}


	public void setRoleSet(Set<Role> roleSet) {
		this.roleSet = roleSet;
	}
	

	

}
