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

import com.fdmgroup.OnlineBookStore.User.User;
import com.fdmgroup.OnlineBookStore.User.UserDao;

public class FindPasswordServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		RequestDispatcher rd = req.getRequestDispatcher("findpassword.jsp");
		rd.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String username = req.getParameter("username");
		String firstname = req.getParameter("firstname");
		String lastname = req.getParameter("lastname");

		
		req.setAttribute("username", username);
		req.setAttribute("firstname", firstname);
		req.setAttribute("lastname", lastname);

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa");
		UserDao uDao = new UserDao(emf);
		User user = uDao.get(username);
		String un = user.getUsername();
		String fn = user.getFirstName();
		String ln = user.getLastName();

		RequestDispatcher rd = null;
		if ( username.equals(un) && lastname.equals(ln)  && firstname.equals(fn)) {
			// get password
			String password = user.getPassword();
			HttpSession session1 = req.getSession();
			session1.setAttribute("password",password);
			rd = req.getRequestDispatcher("getpassword.jsp");
		} else {
			// fail
			rd = req.getRequestDispatcher("error.jsp");

		}
		rd.forward(req, resp);
	}

}
