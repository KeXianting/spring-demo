package org.spring.framework.aop.ref;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
	
	public static void main(String[] args) {
		
		//1.创建ioc容器
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("/spring-aop/applicationContext-annotation.xml");
		
		UserAction userAction = (UserAction) ctx.getBean("userAction");
		userAction.execute();
	}
	
}
