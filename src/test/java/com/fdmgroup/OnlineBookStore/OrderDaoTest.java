package com.fdmgroup.OnlineBookStore;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import org.junit.Test;
import org.mockito.InOrder;

import com.fdmgroup.OnlineBookStore.Order.Order;
import com.fdmgroup.OnlineBookStore.Order.OrderDao;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

public class OrderDaoTest {
	
	@Test
	public void adding_order_then_persists_and_cleans_up_resources() {
		EntityManagerFactory mockEmf = mock( EntityManagerFactory.class);
		EntityManager mockEm = mock(EntityManager.class);
		EntityTransaction mockEt = mock(EntityTransaction.class);
		Order mockOrder = mock(Order.class);
		
		when(mockEmf.createEntityManager()).thenReturn(mockEm);
		when(mockEm.getTransaction()).thenReturn(mockEt);
		
		OrderDao oDao = new OrderDao(mockEmf);
		oDao.add(mockOrder);
		
		verify(mockEmf).createEntityManager();
		verify(mockEm).getTransaction();
		verify(mockEt).begin();
		verify(mockEm).persist(mockOrder);
		verify(mockEt).commit();
		verify(mockEm).close();
		
		
	}
	
	@Test
	public void delete_order_information() {
		EntityManagerFactory mockEmf = mock( EntityManagerFactory.class);
		EntityManager mockEm = mock(EntityManager.class);
		EntityTransaction mockEt = mock(EntityTransaction.class);
		Order mockOrder = mockEm.find(Order.class, 3);
		
		when(mockEmf.createEntityManager()).thenReturn(mockEm);
		when(mockEm.getTransaction()).thenReturn(mockEt);
		
		OrderDao oDao = new OrderDao(mockEmf);
		oDao.deleteOrder(3);
		
		verify(mockEmf).createEntityManager();
		verify(mockEm).getTransaction();
		verify(mockEt).begin();
		verify(mockEm).remove(mockOrder);
		verify(mockEt).commit();
		verify(mockEm).close();
		
		
	}
	

}
