package com.fdmgroup.OnlineBookStore;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import org.junit.Test;
import org.mockito.InOrder;

import com.fdmgroup.OnlineBookStore.Order.Order;
import com.fdmgroup.OnlineBookStore.User.User;
import com.fdmgroup.OnlineBookStore.User.UserDao;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

public class UserDAOTest {
	
		@Test
		public void adding_user_persists_and_cleans_up_resources() {
			EntityManagerFactory mockEmf = mock( EntityManagerFactory.class);
			EntityManager mockEm = mock(EntityManager.class);
			EntityTransaction mockEt = mock(EntityTransaction.class);
			User mockUser = mock(User.class);
			
			when(mockEmf.createEntityManager()).thenReturn(mockEm);
			when(mockEm.getTransaction()).thenReturn(mockEt);
			
			UserDao uDao = new UserDao(mockEmf);
			uDao.add(mockUser);
			
			verify(mockEmf).createEntityManager();
			verify(mockEm).getTransaction();
			verify(mockEt).begin();
			verify(mockEm).persist(mockUser);
			verify(mockEt).commit();
			verify(mockEm).close();
			
			
		}
		
		@Test
		public void get_user_then_retrive_and_cleans_up_resources() {
			EntityManagerFactory mockEmf = mock(EntityManagerFactory.class);
			EntityManager mockEm = mock(EntityManager.class);
			EntityTransaction mockEt = mock(EntityTransaction.class);
			
			when(mockEmf.createEntityManager()).thenReturn(mockEm);
			when(mockEm.getTransaction()).thenReturn(mockEt);
			
			UserDao uDao = new UserDao(mockEmf);
			uDao.get(1);
			
			
			InOrder order = inOrder(mockEmf, mockEm);
			order.verify(mockEmf).createEntityManager();
			verify(mockEm).find(User.class,1);
			verify(mockEm).close();
			
			
		}
		
		@Test
		public void update_user_name_then_cleans_up_resources() {
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
		
		@Test
		public void delete_user() {
			EntityManagerFactory mockEmf = mock( EntityManagerFactory.class);
			EntityManager mockEm = mock(EntityManager.class);
			EntityTransaction mockEt = mock(EntityTransaction.class);
			User mockUser = mock(User.class);
			
			
			when(mockEmf.createEntityManager()).thenReturn(mockEm);
			when(mockEm.getTransaction()).thenReturn(mockEt);
			when(mockEm.find(User.class,2)).thenReturn(mockUser);
			
			UserDao uDao = new UserDao(mockEmf);
			
			uDao.deleteUser(2);

			
			verify(mockEmf).createEntityManager();
			verify(mockEm).getTransaction();
			verify(mockEt).begin();
			verify(mockEm).find(User.class,2);
			verify(mockUser).setStatus("Non-active");
		
			verify(mockEt).commit();
			verify(mockEm).close();

			
			
		}


}
