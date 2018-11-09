package com.fdmgroup.OnlineBookStore.OrderDetail;

import java.beans.Transient;
import java.io.Serializable;

import javax.persistence.AssociationOverride;
import javax.persistence.AssociationOverrides;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.Table;

@Entity

@Table(name = "order_detail")
@AssociationOverrides({
	@AssociationOverride(name = "pk.order", 
		joinColumns = @JoinColumn(name = "order_id")),
	@AssociationOverride(name = "pk.book", 
		joinColumns = @JoinColumn(name = "book_id")) })
public class OrderDetail implements Serializable {
	
	private OrderDetailId pk = new OrderDetailId();
	private int num;
	
	public OrderDetail() {
		
	}

	public OrderDetail(OrderDetailId pk, int num) {
		super();
		this.pk = pk;
		this.num = num;
	}

	@EmbeddedId
	public OrderDetailId getPk() {
		return pk;
	}

	public void setPk(OrderDetailId pk) {
		this.pk = pk;
	}
	
	
	
	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}
	
	
	
}
