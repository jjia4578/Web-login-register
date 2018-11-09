package com.fdmgroup.OnlineBookStore.Order;

import java.sql.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fdmgroup.OnlineBookStore.User.User;

@Entity

@Table(name = "user_order")
public class Order {

	@Id
	private int orderId;
	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.MERGE)
	@JoinColumn(name = "user_id")
	private User user;

	private String orderDate;

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(String orderDate) {
		this.orderDate = orderDate;
	}

	public Order(int orderId, User user, String orderDate) {
		super();
		this.orderId = orderId;
		this.user = user;
		this.orderDate = orderDate;
	}

	public Order() {

	}

	@Override
	public String toString() {
		return "Order [orderId=" + orderId + ", user=" + user + ", orderDate=" + orderDate + "]";
	}

}
