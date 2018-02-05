package com.blog.realm;


import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.blog.pojo.User;
import com.blog.service.UserService;

public class MyRealm extends AuthorizingRealm {

	private static final Logger log = LoggerFactory.getLogger(MyRealm.class);
	
	@Autowired
	private UserService userService;

	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
		// TODO Auto-generated method stub
		String username= (String) principals.getPrimaryPrincipal();
		SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
		//authorizationInfo.setRoles(userService.);
		
		return null;
	}

	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
		// TODO Auto-generated method stub
		String username = (String) token.getPrincipal();
		User userTemp = new User();
		userTemp.setUsername(username);
		User user = userService.getUser(userTemp);
		if (user==null) {
			throw new UnknownAccountException("无此账号！");
		}
		if (Boolean.TRUE.equals(user.getLocked())) {
			throw new LockedAccountException("账号被锁");
		}
		return new SimpleAuthenticationInfo(user.getUsername(), 
				user.getPassword(),
				ByteSource.Util.bytes(user.getPassword()),
				getName());
	}
	
	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return "MyRealm";
	}
	
}
