package com.fdmgroup.OnlineBookStore;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.hibernate.Session;

import com.fdmgroup.OnlineBookStore.Book.Book;
import com.fdmgroup.OnlineBookStore.Book.BookDao;
import com.fdmgroup.OnlineBookStore.Order.Order;
import com.fdmgroup.OnlineBookStore.Order.OrderDao;
import com.fdmgroup.OnlineBookStore.OrderDetail.OrderDetail;
import com.fdmgroup.OnlineBookStore.OrderDetail.OrderDetailDao;
import com.fdmgroup.OnlineBookStore.OrderDetail.OrderDetailId;
import com.fdmgroup.OnlineBookStore.User.User;
import com.fdmgroup.OnlineBookStore.User.UserDao;

public class OnlineBookStoreRunner {

	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa");
		UserDao uDao = new UserDao(emf);
		User u1 = new User( "chris", "brown", "abc","male");
		User u2 = new User( "bob", "nothing","abc1","female");
		User u3 = new User("kobe", "byrant", "abc2","male");
		User u4 = new User( "diam", "libero", "abc3","male");
		User u5 = new User( "dapibus", "lambo","abc4", "male");
		User u6 = new User( "ipsum", "brito", "abc5","female");
		User u7 = new User( "feugiat", "taco", "abc6","male");
		User u8 = new User( "est", "beef","abc7", "male");
		User u9 = new User( "pulvinar", "lamb","abc8", "female");
		
		
		uDao.add(u1);
		uDao.add(u2);
		uDao.add(u3);
		uDao.add(u4);
		uDao.add(u5);
		uDao.add(u6);
		uDao.add(u7);
		uDao.add(u8);
		uDao.add(u9);

		BookDao bDao = new BookDao(emf);
		Book b1 = new Book(101, "YouAndMe", 25.5, "BlackWhite");
		Book b2 = new Book(202, "NothingElse", 28, "Nobody");
		Book b3 = new Book(303, "CommonSense", 30, "KingSnow");
		Book b4 = new Book(404, "dolor", 32, "amet");
		Book b5 = new Book(505, "consectetur", 12, "adipiscing");
		Book b6 = new Book(606, "Duis", 38, "Etiam");
		Book b7 = new Book(707, "lorem", 24, "mauris");
		Book b8 = new Book(808, "bibendum", 56, "euismod");

		bDao.add(b1);
		bDao.add(b2);
		bDao.add(b3);
		bDao.add(b4);
		bDao.add(b5);
		bDao.add(b6);
		bDao.add(b7);
		bDao.add(b8);

		OrderDao oDao = new OrderDao(emf);

		Order d1 = new Order(1001, u1, "2006-11-08");
		Order d2 = new Order(1002, u2, "2007-11-08");
		Order d3 = new Order(1003, u3, "2010-08-08");
		Order d4 = new Order(1004, u3, "2013-02-23");
		Order d5 = new Order(1005, u4, "2018-06-08");
		Order d6 = new Order(1006, u5, "2000-05-08");
		Order d7 = new Order(1007, u6, "2001-04-08");
		Order d8 = new Order(1008, u7, "2002-03-08");
		Order d9 = new Order(1009, u8, "2003-09-08");
		Order d10 = new Order(1010, u9, "2004-10-08");

		oDao.add(d1);
		oDao.add(d2);
		oDao.add(d3);
		oDao.add(d4);
		oDao.add(d5);
		oDao.add(d6);
		oDao.add(d7);
		oDao.add(d8);
		oDao.add(d9);
		oDao.add(d10);

		// EntityManager em = emf.createEntityManager();
		// Session session = em.unwrap(org.hibernate.Session.class);

		OrderDetailId odId1 = new OrderDetailId(d1,b1);
		OrderDetail od1 = new OrderDetail(odId1,3);
		OrderDetailId odId2 = new OrderDetailId(d2,b2);
		OrderDetail od2 = new OrderDetail(odId2,2);

		

		OrderDetailDao odDao = new OrderDetailDao(emf);
		odDao.add(od1);
		odDao.add(od2);

		System.out.println(uDao.get("abc"));


	}

}
