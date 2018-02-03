package org.spring.framework.ioc.ref;

import org.spring.framework.ioc.helloworld.User;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;


public class MyBeanPostProcessor implements BeanPostProcessor {


	public Object postProcessAfterInitialization(Object arg0, String arg1)
			throws BeansException {
		if(arg1.equals("boy")){
			System.out.println("postProcessAfterInitialization..." + arg0 + "," + arg1);
			User user = (User) arg0;
			user.setUserName("�����");
		}
		return arg0;
	}


	public Object postProcessBeforeInitialization(Object arg0, String arg1)
			throws BeansException {
		if(arg1.equals("boy"))
			System.out.println("postProcessBeforeInitialization..." + arg0 + "," + arg1);
		return arg0;
	}

}
