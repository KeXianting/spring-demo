package org.spring.framework.ioc.ref;

import org.spring.framework.ioc.helloworld.Car;
import org.spring.framework.ioc.helloworld.User;
import org.springframework.beans.factory.FactoryBean;

import java.util.ArrayList;
import java.util.List;


/*
FactoryBean：以Bean结尾，表示它是一个Bean，
不同于普通Bean的是：它是实现了FactoryBean<T>接口的Bean，
根据该Bean的Id从BeanFactory中获取的实际上是FactoryBean的getObject()返回的对象，
而不是FactoryBean本身， 如果要获取FactoryBean对象，可以在id前面加一个&符号来获取
 */
public class UserBean implements FactoryBean<User>{


	public User getObject() throws Exception {
		User user = new User();
		user.setUserName("abc");
		user.setWifeName("ABC");
		
		List<Car> cars = new ArrayList();
		cars.add(new Car("ShangHai", "BuiKe", 180, 300000));
		cars.add(new Car("ShangHai", "CRUZE", 130, 150000));
		
		user.setCars(cars);
		return user;
	}


	public Class<?> getObjectType() {
		return User.class;
	}


	public boolean isSingleton() {
		return true;
	}

}
