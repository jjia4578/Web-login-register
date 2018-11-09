package com.fdmgroup.servlets;

import java.io.IOException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fdmgroup.OnlineBookStore.OnlineBookStoreRunner;
import com.fdmgroup.OnlineBookStore.User.User;
import com.fdmgroup.OnlineBookStore.User.UserDao;

public class UserLoginServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		RequestDispatcher rd = req.getRequestDispatcher("userlogin.jsp");
		rd.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String username = req.getParameter("username");
		String password = req.getParameter("password");

		req.setAttribute("password", password);
		req.setAttribute("username", username);

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa");
		EntityManager em = emf.createEntityManager();
		UserDao uDao = new UserDao(emf);
		User user = uDao.get(username);

		// better to call a login service class here
		RequestDispatcher rd = null;
		if (!user.getPassword().equals(password)) {
			rd = req.getRequestDispatcher("wrongpassword.jsp");
		} else if (user.getPassword().equals(password)) {
			// allow login
			rd = req.getRequestDispatcher("welcome.jsp");

		} else {
			rd = req.getRequestDispatcher("error.jsp");
		}
		rd.forward(req, resp);
	}

}
