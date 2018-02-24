package com.mo9.chat.service.impl;


import com.mo9.chat.mapper.LoginMapper;
import com.mo9.chat.po.Staff;
import com.mo9.chat.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Transactional(propagation= Propagation.REQUIRED,isolation= Isolation.DEFAULT,timeout=5)
@Service("loginservice")
public class LoginServiceImpl implements LoginService{
	@Autowired
	LoginMapper loginmapper;

	public String getpwdbyname(String name) {
		Staff s=loginmapper.getpwdbyname(name);
		if(s!=null)
		return s.getPassword();
		else
		return null;
	}
	public Long getUidbyname(String name) {
		Staff s=loginmapper.getpwdbyname(name);
		if(s!=null)
			return (long) s.getStaff_id();
			else
			return null;
	}
	public String getnamebyid(long id) {
		Staff s=loginmapper.getnamebyid(id);
		if(s!=null)
			return s.getUsername();
			else
			return null;
	}
	
	

}
