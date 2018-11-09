package com.fdmgroup.OnlineBookStore.SeperateRunner;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.fdmgroup.OnlineBookStore.Book.Book;
import com.fdmgroup.OnlineBookStore.Book.BookDao;

public class BookRunner {
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa");
		BookDao bDao = new BookDao(emf);
		Book b1 = new Book(101,"YouAndMe",25.5,"BlackWhite");
		Book b2 = new Book(202,"NothingElse",28,"Nobody");
		Book b3 = new Book(303,"CommonSense",30,"KingSnow");
		
		bDao.add(b1);
		bDao.add(b2);
		bDao.add(b3);
		System.out.println(bDao.get(101));
		System.out.println(bDao.update_price(202,37));
		
		
		
	}

}