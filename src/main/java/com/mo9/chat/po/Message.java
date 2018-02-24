package com.mo9.chat.po;

import java.util.Date;

public class Message {

	//发送者uid
	public Long from;
	//发送者名称
	public String fromName;
	//接收者uid
	public Long to;
	//发送的文本
	public String text;
	//发送日期
	public Date date;
	//发送消息类型


	public Long getFrom() {
		return from;
	}

	public void setFrom(Long from) {
		this.from = from;
	}

	public Long getTo() {
		return to;
	}

	public void setTo(Long to) {
		this.to = to;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public String getFromName() {
		return fromName;
	}

	public void setFromName(String fromName) {
		this.fromName = fromName;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

}
