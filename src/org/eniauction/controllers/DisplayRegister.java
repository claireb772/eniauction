package org.eniauction.controllers;

import java.io.IOException;
import java.net.URL;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.regex.*;

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
		String Pseudo = request.getParameter("Pseudo").trim();
		String Name = request.getParameter("Name").trim();
		String Password = request.getParameter("Password").trim();
		Pattern p = Pattern.compile("(?=^.{8,}$)((?=.*\\d)|(?=.*\\W+))(?![.\\n])(?=.*[A-Z])(?=.*[a-z]).*$") ;    // Min 1maj 1min 1 chiffre 1 char special
		Matcher m = p.matcher(Password) ;    
		boolean b = m.matches() ;
		String Confirmation = request.getParameter("Confirmation").trim();
		String Surname = request.getParameter("Surname").trim();
		String Phone = request.getParameter("Phone").trim();
		String Email = request.getParameter("Email").trim();
		String Street = request.getParameter("Street").trim();
		String City = request.getParameter("City").trim();
		String PostalCode = request.getParameter("PostalCode").trim();
		
 
		if(b == false || !Password.equals(Confirmation)){  // Password doit être égal a Confirmation, et B= respecte les critères
			response.sendRedirect("./sign");
			
		}else{
			Users user = new Users(0, Pseudo, Name, Surname, Email, Phone, Street, PostalCode, City, Password, 0, false);
			UserManager um= UserManager.getInstance();
			var o = um.newUser(user);
			response.sendRedirect("./");

		}


	}


}