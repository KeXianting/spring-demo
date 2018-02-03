package org.spring.framework.ioc.annotation.generic;

public class BaseDao<T> {

	public void save(T entity){
		System.out.println("Save:" + entity);
	}
	
}
