package com.blog.handler;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.config.annotation.WebSocketConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;

import com.blog.websocket.HandshakeInterceptor;

@Configuration
@EnableWebSocket
public class WebSocketConfig implements WebSocketConfigurer {

	@Override
    public void registerWebSocketHandlers(WebSocketHandlerRegistry registry) {
		 registry.addHandler(new WebsocketEndPoint(), "/")
         .addInterceptors(new HandshakeInterceptor())/*.setAllowedOrigins("http://127.0.0.1:8090/")*/;
    }

   
}
