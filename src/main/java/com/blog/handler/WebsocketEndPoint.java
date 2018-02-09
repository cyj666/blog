package com.blog.handler;

import java.io.IOException;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

public class WebsocketEndPoint extends TextWebSocketHandler {

	private static final Logger logger = LoggerFactory.getLogger(WebsocketEndPoint.class);
	/*private final static List<WebSocketSession> sessions 
	= Collections.synchronizedList(new ArrayList<WebSocketSession>());*/
	private final static  Map<String, WebSocketSession> clients = new ConcurrentHashMap<>();
	
	//接收文本消息，并发送出去
	@Override
	protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
		// TODO Auto-generated method stub			
		//String data = message.getPayload();
		TextMessage returnMessage = new TextMessage(message.getPayload());				
		
		sendToOthers(session, returnMessage);
		
		super.handleTextMessage(session, message);
	}
	
	/**
	 * 向特定目标发送
	 * @param id
	 * @param message
	 * @throws IOException 
	 */
	private void sendToOne(String id,TextMessage message) throws IOException {		
		WebSocketSession session = clients.get(id);
		if (session!=null&&session.isOpen()) {
			session.sendMessage(message);
			logger.debug("发送成功！");
		}else if (!session.isOpen()) {
			clients.remove(session);
			session.close();
		}else {
			logger.debug("发送失败！缓存中无此session或session已被关闭。");
		}
		
	}
	/**
	 * 发送除自己以外的
	 * @param tm
	 */
	private void sendToOthers(WebSocketSession session,TextMessage tm) {
		 try  
	        {  
	            for(WebSocketSession s : clients.values())  
	            {  
	                if(s.isOpen()&&s!=session)  
	                {  
	                    s.sendMessage(tm); 
	                    logger.debug("发送成功！");
	                }  
	                else if (s!=session&&!s.isOpen()) {
	                	logger.debug("发送失败！");
	                    clients.remove(s.getId());
					}else {
						logger.debug("不发送给本人！");
					}
	                 
	            }  
	        }catch(Exception e)  
	        {  
	            e.printStackTrace();  
	        }  
	}
	/**
	 * 广播发送
	 * @param 
	 */
	private void sendToAll(TextMessage tm)  
	    {  
	        try  
	        {  
	            for(WebSocketSession session : clients.values())  
	            {  
	                if(session.isOpen())  
	                {  
	                    session.sendMessage(tm); 
	                    logger.debug("广播成功！");
	                }  
	                else  
	                {  
	                    clients.remove(session.getId());  
	                }  
	            }  
	        }catch(Exception e)  
	        {  
	            e.printStackTrace();  
	        }  
	    }  
	
	//连接建立后处理
    @Override
    public void afterConnectionEstablished(WebSocketSession session) throws Exception {
        logger.debug("成功连接，可以开始通话。");   
        if(!clients.containsKey(session.getId()))  
        {  
            clients.put(session.getId(), session);  
        }  
        //sessions.add(session);
        //处理离线消息
    }
    
    //抛出异常时处理
    @Override
    public void handleTransportError(WebSocketSession session, Throwable exception) throws Exception {
        if(session.isOpen()){
            session.close();
        }
        logger.debug("出现异常，连接已经关闭...");
        clients.remove(session.getId());
        //sessions.remove(session);
    }
    
    //连接关闭后处理
    @Override
    public void afterConnectionClosed(WebSocketSession session, CloseStatus closeStatus) throws Exception {
        logger.debug("连接即将关闭......");
        if(session.isOpen()){
            session.close();
        }
        //clients.remove(session.getId());
       // sessions.remove(session);
    }

    @Override
    public boolean supportsPartialMessages() {
        return false;
    }
}
