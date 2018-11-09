package com.fdmgroup.OnlineBookStore.Book;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;

public class BookDao {

	private EntityManagerFactory emf;
	
	public BookDao(EntityManagerFactory emf) {
		this.emf = emf;
	}


	public void add(Book book) {
		
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		et.begin();
		em.persist(book);
		et.commit();
		em.close();
		
	}

	public Book get(int i) {
		EntityManager em = emf.createEntityManager();
		Book book = em.find(Book.class, i);
		em.close();
		return book;
	}

	public double update_price(int i,double d) {
		EntityManager em = emf.createEntityManager();
		Book book= em.find(Book.class, i);
		EntityTransaction et = em.getTransaction();
		
		et.begin();
		book.setPrice(d);
		double newPrice = book.getPrice();
		et.commit();
		em.close();
		
		return newPrice;
		
		
	}

	public void deleteBook(int i) {
		
		EntityManager em = emf.createEntityManager();
		Book book= em.find(Book.class, i);
		EntityTransaction et = em.getTransaction();
		
		et.begin();
		em.remove(book);
		et.commit();
		em.close();
		

		
		
	}
}
