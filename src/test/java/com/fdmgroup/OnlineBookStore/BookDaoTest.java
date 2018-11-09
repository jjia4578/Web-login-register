package com.fdmgroup.OnlineBookStore;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import org.junit.Test;
import org.mockito.InOrder;

import com.fdmgroup.OnlineBookStore.Book.Book;
import com.fdmgroup.OnlineBookStore.Book.BookDao;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

public class BookDaoTest {
	
		@Test
		public void adding_book_persists_and_cleans_up_resources() {
			EntityManagerFactory mockEmf = mock(EntityManagerFactory.class);
			EntityManager mockEm = mock(EntityManager.class);
			EntityTransaction mockEt = mock(EntityTransaction.class);
			Book mockBook = mock(Book.class);
			
			when(mockEmf.createEntityManager()).thenReturn(mockEm);
			when(mockEm.getTransaction()).thenReturn(mockEt);
			
			BookDao bDao = new BookDao(mockEmf);
			bDao.add(mockBook);
			
			verify(mockEmf).createEntityManager();
			verify(mockEm).getTransaction();
			verify(mockEt).begin();
			verify(mockEm).persist(mockBook);
			verify(mockEt).commit();
			verify(mockEm).close();
			
			
		}
		
		@Test
		public void get_book_then_retrive_and_cleans_up_resources() {
			EntityManagerFactory mockEmf = mock(EntityManagerFactory.class);
			EntityManager mockEm = mock(EntityManager.class);
			EntityTransaction mockEt = mock(EntityTransaction.class);
			
			when(mockEmf.createEntityManager()).thenReturn(mockEm);
			when(mockEm.getTransaction()).thenReturn(mockEt);
			
			BookDao bDao = new BookDao(mockEmf);
			bDao.get(101);
			
			
			InOrder order = inOrder(mockEmf, mockEm);
			order.verify(mockEmf).createEntityManager();
			verify(mockEm).find(Book.class,101);
			verify(mockEm).close();
			
			
		}
		
		@Test
		public void update_book_price_then_cleans_up_resources() {
			EntityManagerFactory mockEmf = mock( EntityManagerFactory.class);
			EntityManager mockEm = mock(EntityManager.class);
			EntityTransaction mockEt = mock(EntityTransaction.class);
			Book mockBook = mock(Book.class);
			
			
			when(mockEmf.createEntityManager()).thenReturn(mockEm);
			when(mockEm.getTransaction()).thenReturn(mockEt);
			when(mockEm.find(Book.class,202)).thenReturn(mockBook);
			
			BookDao bDao = new BookDao(mockEmf);
			
			bDao.update_price(202,38);

			
			verify(mockEmf).createEntityManager();
			verify(mockEm).getTransaction();
			verify(mockEt).begin();
			verify(mockEm).find(Book.class,202);
			verify(mockBook).setPrice(38);
			verify(mockBook).getPrice();
			verify(mockEt).commit();
			verify(mockEm).close();

			
			
		}
		
		@Test
		public void delete_user() {
			EntityManagerFactory mockEmf = mock( EntityManagerFactory.class);
			EntityManager mockEm = mock(EntityManager.class);
			EntityTransaction mockEt = mock(EntityTransaction.class);
			Book mockBook = mock(Book.class);
			
			
			when(mockEmf.createEntityManager()).thenReturn(mockEm);
			when(mockEm.getTransaction()).thenReturn(mockEt);
			when(mockEm.find(Book.class,202)).thenReturn(mockBook);
			
			BookDao bDao = new BookDao(mockEmf);
			
			bDao.deleteBook(202);

			
			verify(mockEmf).createEntityManager();
			verify(mockEm).getTransaction();
			verify(mockEt).begin();
			verify(mockEm).find(Book.class,202);
			verify(mockEm).remove(mockBook);
			verify(mockEt).commit();
			verify(mockEm).close();

			
			
		}


}
