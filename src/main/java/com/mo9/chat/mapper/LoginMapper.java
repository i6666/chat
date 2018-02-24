package com.mo9.chat.mapper;

import com.mo9.chat.po.Staff;


public interface LoginMapper {
	Staff getpwdbyname(String name);
	Staff getnamebyid(long id);
}
