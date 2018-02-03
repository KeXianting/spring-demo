package org.spring.framework.ioc.ref;

import org.spring.framework.ioc.helloworld.User;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.sql.DataSource;
import java.sql.SQLException;
import java.text.DateFormat;
import java.util.Date;


public class Main {
	
	public static void main(String[] args) throws SQLException {
		
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("spring-ioc/beans-auto.xml");
		Action action = ctx.getBean(Action.class);
		
		action.execute();
		
		//测试bean的作用域
		Dao dao1 = (Dao) ctx.getBean("dao2");
		Dao dao2 = (Dao) ctx.getBean("dao2");
		//prototype: 原型的. 每次调用 getBean 方法都会返回一个新的 bean. 且在第一次调用 getBean 方法时才创建实例
		//singleton: 单例的. 每次调用 getBean 方法都会返回同一个 bean. 且在 IOC 容器初始化时即创建 bean 的实例. 默认值
		System.out.println("nanke");
		System.out.println(dao1 == dao2);
		
		//测试使用外部使用文件
		DataSource dataSource = (DataSource) ctx.getBean("dataSource");
		System.out.println(dataSource.getConnection());
		
		//测试spEL
		User boy = (User) ctx.getBean("boy");
		System.out.println(boy.getUserName() + ":" + boy.getWifeName());
		
//		DateFormat dateFormat = DateFormat.getDateInstance(DateFormat.FULL);
		DateFormat dateFormat = (DateFormat) ctx.getBean("dateFormat");
		System.out.println("dataFormat nanke: ");
		System.out.println(dateFormat.format(new Date()));
		
		Date date = (Date) ctx.getBean("datetime");
		System.out.println(date);
		
		User user = (User) ctx.getBean("user");
		System.out.println(user);
		
		ctx.close();
		//DispatcherServlet;
	}
	
}
