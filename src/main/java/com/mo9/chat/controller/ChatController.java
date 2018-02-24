package com.mo9.chat.controller;

import com.google.gson.GsonBuilder;
import com.mo9.chat.po.Message;
import com.mo9.chat.po.User;
import com.mo9.chat.service.LoginService;
import com.mo9.chat.websocket.MyWebSocketHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;

import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.*;

@RestController
public class ChatController {
	@Autowired
	MyWebSocketHandler handler;
	
	@Autowired
	LoginService loginservice;
	
	@RequestMapping("/onlineusers")
	@ResponseBody
	public Set<String> onlineusers(HttpSession session){
		Map<Long, WebSocketSession> map=MyWebSocketHandler.userSocketSessionMap;
		Set<Long> set=map.keySet();
		Iterator<Long> it = set.iterator();
		Set<String> nameset=new HashSet<String>();
		while(it.hasNext()){
			Long entry = it.next();
			String name=loginservice.getnamebyid(entry);
			String user=(String)session.getAttribute("username");
			if(!user.equals(name))
				nameset.add(name);
		}
		return nameset;
	}
	
	// 发布系统广播（群发）
		@ResponseBody
		@RequestMapping(value = "broadcast", method = RequestMethod.POST)
		public void broadcast(@RequestParam("text") String text) throws IOException {
			Message msg = new Message();
			msg.setDate(new Date());
			msg.setFrom(-1L);//-1表示系统广播
			msg.setFromName("系统广播");
			msg.setTo(0L);
			msg.setText(text);
			handler.broadcast(new TextMessage(new GsonBuilder().setDateFormat("yyyy-MM-dd HH:mm:ss").create().toJson(msg)));
		}
		
	@RequestMapping(value = "getuid",method = RequestMethod.POST)
	@ResponseBody
	public User getuid(@RequestParam("username")String username){
		Long a=loginservice.getUidbyname(username);
		User u=new User();
		u.setUid(a);
		return u;
	}
}
