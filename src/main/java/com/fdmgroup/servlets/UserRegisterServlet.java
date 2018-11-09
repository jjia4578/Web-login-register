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

import com.fdmgroup.OnlineBookStore.User.User;
import com.fdmgroup.OnlineBookStore.User.UserDao;

public class UserRegisterServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		RequestDispatcher rd = req.getRequestDispatcher("register.jsp");
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
		List<String> allUserName = uDao.listUserName();

		RequestDispatcher rd = null;
		if (password.equals(null) || allUserName.contains(username) || username.equals(null)) {
			// block register
			rd = req.getRequestDispatcher("failure.jsp");
		} else {
			// allow register
			
			User user2 = new User();
			user2.setUsername(username);
			user2.setPassword(password);
			uDao.add(user2);
			rd = req.getRequestDispatcher("userlogin.jsp");

		}
		rd.forward(req, resp);
	}

}
