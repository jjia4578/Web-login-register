package com.fdmgroup.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		RequestDispatcher rd = req.getRequestDispatcher("login.jsp");
		rd.forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		
		req.setAttribute("lucky_numbers", new int[] {1,2,3});
		

		
		//better to call a login service class here
		RequestDispatcher rd = null;
		if (username.equals("Jiang") || password.contains("#")) {
			//block login
			rd = req.getRequestDispatcher("block.jsp");
		}
		else {
			//allow login
			rd = req.getRequestDispatcher("home.jsp");
			
			HttpSession session1 = req.getSession();
			session1.setAttribute("logged_in_user",username);
		}
		rd.forward(req,resp);
	}

}
