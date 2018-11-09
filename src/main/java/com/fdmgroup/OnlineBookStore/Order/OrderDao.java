package com.fdmgroup.OnlineBookStore.Order;
import java.sql.Date;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;

import com.fdmgroup.OnlineBookStore.User.User;


public class OrderDao {
	private EntityManagerFactory emf;
	public OrderDao(EntityManagerFactory emf) {
		this.emf = emf;
		
	}

	public void add(Order order) {
		
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		et.begin();
		em.persist(order);
		et.commit();
		em.close();
		
	}
	
	public Order get(int i) {
		EntityManager em = emf.createEntityManager();
		Order order = em.find(Order.class, i);
		em.close();
		return order;
	}

	public void deleteOrder(int orderId) {
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		Order order = em.find(Order.class, orderId);
		et.begin();
		em.remove(order);
		et.commit();
		em.close();
		
		
	}
	
	public Order update(int i, User user, String orderDate) {
		EntityManager em = emf.createEntityManager();
		Order order= em.find(Order.class, i);
		EntityTransaction et = em.getTransaction();
		
		et.begin();
		order.setUser(user);
		order.setOrderId(i);
		order.setOrderDate(orderDate);
		et.commit();
		em.close();
		
		return order;
		
		
	}
	
	
	
	
	

}
