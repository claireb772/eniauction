package org.eniauction.controllers;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.eniauction.models.bll.UserManager;
import org.eniauction.models.bo.Users;

/**
 * Servlet implementation class DisplayRegister
 */
@WebServlet("/sign")
public class DisplayRegister extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public DisplayRegister() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/sign.jsp");
		if (rd != null) {
			rd.forward(request, response);
		}
	}


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String Pseudo = request.getParameter("Pseudo");
		String Name = request.getParameter("Name");
		String Password = request.getParameter("Password");
		String Confirmation = request.getParameter("Confirmation");
		String Surname = request.getParameter("Surname");
		String Phone = request.getParameter("Phone");
		String Email = request.getParameter("Email");
		String Street = request.getParameter("Street");
		String City = request.getParameter("City");
		String PostalCode = request.getParameter("PostalCode");
		Users user = new Users(0, Pseudo, Name, Surname, Email, Phone, Street, PostalCode, City, Password, 0, false);
		UserManager um= UserManager.getInstance();
		var o = um.newUser(user);
		doGet(request, response);


	}

}