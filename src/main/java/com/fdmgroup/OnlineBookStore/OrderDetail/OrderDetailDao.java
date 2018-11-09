package com.fdmgroup.OnlineBookStore.OrderDetail;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;

import com.fdmgroup.OnlineBookStore.Book.Book;
import com.fdmgroup.OnlineBookStore.Order.Order;

public class OrderDetailDao {
	
	private EntityManagerFactory emf;
	public OrderDetailDao(EntityManagerFactory emf) {
		this.emf = emf;
		
	}

	public void add(OrderDetail orderDetail) {
		
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		et.begin();
		em.persist(orderDetail);
		et.commit();
		em.close();
		
	}
	
//	public OrderDetail update( Order order, Book book, int i) {
//
//		EntityManager em = emf.createEntityManager();
//		OrderDetail orderDetail= em.find(OrderDetail.class, book);
//		EntityTransaction et = em.getTransaction();
//		
//		et.begin();
//		orderDetail.getPk().setBook(book);
//		orderDetail.getPk().setOrder(order);
//		et.commit();
//		em.close();
//		
//		return orderDetail;
//		
//	}

}
