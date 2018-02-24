package com.mo9.chat;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.mo9.chat.mapper")
public class ChatwsApplication {

	public static void main(String[] args) {
		SpringApplication.run(ChatwsApplication.class, args);
	}
}
