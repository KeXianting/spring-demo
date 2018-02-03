package org.spring.framework.jdbc.tx.xml.service.impl;

import org.spring.framework.jdbc.tx.BookShopService;
import org.spring.framework.jdbc.tx.Cashier;

import java.util.List;


public class CashierImpl implements Cashier {

	private BookShopService bookShopService;
	
	public void setBookShopService(BookShopService bookShopService) {
		this.bookShopService = bookShopService;
	}
	

	public void checkout(String username, List<String> isbns) {
		for(String isbn: isbns){
			bookShopService.purchase(username, isbn);
		}
	}

}
