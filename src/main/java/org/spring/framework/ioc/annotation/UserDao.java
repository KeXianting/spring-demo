package org.spring.framework.ioc.annotation;

import org.springframework.stereotype.Service;

@Service
public class UserDao {
	
	public void save(){
		System.out.println("UserDao save");
	}
	
}
