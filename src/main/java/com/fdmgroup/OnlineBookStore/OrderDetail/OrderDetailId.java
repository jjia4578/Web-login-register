package com.fdmgroup.OnlineBookStore.OrderDetail;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.ManyToAny;

import com.fdmgroup.OnlineBookStore.Book.Book;
import com.fdmgroup.OnlineBookStore.Order.Order;
import com.fdmgroup.OnlineBookStore.User.User;

@Embeddable
public class OrderDetailId implements Serializable{

	private Order order;
	private Book book;

	@ManyToOne
	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

	@ManyToOne
	public Book getBook() {
		return book;
	}

	public void setBook(Book book) {
		this.book = book;
	}

	public OrderDetailId(Order order, Book book) {
		super();
		this.order = order;
		this.book = book;
	}

	public OrderDetailId() {
		super();
	}
	
	

}
