package com.fdmgroup.OnlineBookStore;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import org.junit.Test;
import org.mockito.InOrder;

import com.fdmgroup.OnlineBookStore.OrderDetail.OrderDetail;
import com.fdmgroup.OnlineBookStore.OrderDetail.OrderDetailDao;
import com.fdmgroup.OnlineBookStore.User.User;
import com.fdmgroup.OnlineBookStore.User.UserDao;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

public class OrderDetailDaoTest {
	
	@Test
	public void adding_order_detail_persists_and_cleans_up_resources() {
		EntityManagerFactory mockEmf = mock( EntityManagerFactory.class);
		EntityManager mockEm = mock(EntityManager.class);
		EntityTransaction mockEt = mock(EntityTransaction.class);
		OrderDetail mockOrderDetail = mock(OrderDetail.class);
		
		when(mockEmf.createEntityManager()).thenReturn(mockEm);
		when(mockEm.getTransaction()).thenReturn(mockEt);
		
		OrderDetailDao odDao = new OrderDetailDao(mockEmf);
		odDao.add(mockOrderDetail);
		
		verify(mockEmf).createEntityManager();
		verify(mockEm).getTransaction();
		verify(mockEt).begin();
		verify(mockEm).persist(mockOrderDetail);
		verify(mockEt).commit();
		verify(mockEm).close();
		
		
	}
	
	@Test
	public void update_orderdetail_then_cleans_up_resources() {
		EntityManagerFactory mockEmf = mock( EntityManagerFactory.class);
		EntityManager mockEm = mock(EntityManager.class);
		EntityTransaction mockEt = mock(EntityTransaction.class);
		User mockUser = mock(User.class);
		
		
		when(mockEmf.createEntityManager()).thenReturn(mockEm);
		when(mockEm.getTransaction()).thenReturn(mockEt);
		when(mockEm.find(User.class,2)).thenReturn(mockUser);
		
		UserDao uDao = new UserDao(mockEmf);
		
		uDao.update_name(2, "Warren", "G");

		
		verify(mockEmf).createEntityManager();
		verify(mockEm).getTransaction();
		verify(mockEt).begin();
		verify(mockEm).find(User.class,2);
		verify(mockUser).setFirstName("Warren");
		verify(mockUser).getFirstName();
		verify(mockEt).commit();
		verify(mockEm).close();

		
		
	}
	


}
