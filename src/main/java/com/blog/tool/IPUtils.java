package com.blog.tool;

import javax.servlet.http.HttpServletRequest;

public class IPUtils {
	/** 
	 * TODO //获得客户端的ip地址 
	 * @param request 
	 * @return 
	 * @author cyj
	 * @date 
	 */  
	public static String getRemortIP(HttpServletRequest request) {  
	    if (request.getHeader("x-forwarded-for") == null) {  
	        return request.getRemoteAddr();  
	    }  
	    return request.getHeader("x-forwarded-for");  
	}  
	  
	/** 
	 * TODO //获得客户端的主机名   
	 * @param request 
	 * @return 
	 * @author cyj 
	 * @date 
	 */  
	public static String getRemoteHost(javax.servlet.http.HttpServletRequest request) {  
	    String ip = request.getHeader("x-forwarded-for");  
	    if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {  
	        ip = request.getHeader("Proxy-Client-IP");  
	    }  
	    if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {  
	        ip = request.getHeader("WL-Proxy-Client-IP");  
	    }  
	    if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {  
	        ip = request.getRemoteAddr();  
	    }  
	    return ip.equals("0:0:0:0:0:0:0:1") ? "127.0.0.1" : ip;  
	}  
}
