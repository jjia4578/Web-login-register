package com.fdmgroup.OnlineBookStore.SeperateRunner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import javax.persistence.Persistence;

import org.hibernate.Session;

import com.fdmgroup.OnlineBookStore.Book.Book;
import com.fdmgroup.OnlineBookStore.Order.Order;
import com.fdmgroup.OnlineBookStore.OrderDetail.OrderDetail;
import com.fdmgroup.OnlineBookStore.OrderDetail.OrderDetailDao;
import com.fdmgroup.OnlineBookStore.User.User;

public class OrderDetailRunner {
	public static void main(String[] args) {
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa");
		EntityManager em = emf.createEntityManager();
		Session session = em.unwrap(org.hibernate.Session.class);
//		User u2 = new User(2,"bob","nothing","female");
//
//		Book b2 = new Book(202,"NothingElse",28,"Nobody");
//		session.save(u2);
//		session.save(b2);
		Order d3 = (Order)session.get(Order.class, 3);
		Book b3 = (Book)session.get(Book.class, 303);
		OrderDetail od1 = new OrderDetail();
		od1.setNum(2);
		od1.getPk().setOrder(d3);
		od1.getPk().setBook(b3);
		
		OrderDetailDao odDao = new OrderDetailDao(emf);
		odDao.add(od1);

	}

}
