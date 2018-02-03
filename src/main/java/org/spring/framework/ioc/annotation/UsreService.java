package org.spring.framework.ioc.annotation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsreService {
	
	@Autowired
	private UserDao userDao;
	
	public void addNew(){
		System.out.println("������û�");
		userDao.save();
	}
	
}
