package org.eniauction.controllers;

import java.io.IOException;
import java.util.List;

import org.eniauction.models.bll.UserManager;
import org.eniauction.models.bo.Users;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class DisplayUser
 */
@WebServlet("/login")
public class DisplayConnect extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * Default constructor.
	 */
	public DisplayConnect() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/login.jsp");
		if (rd != null) {
			rd.forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		UserManager manager = UserManager.getInstance();
		
		String userInput = request.getParameter("user");
		String passwordInput = request.getParameter("password");
		
		
		//if(users.getPseudo().equals(userInput) && users.getPassword().equals(passwordInput)){
		if(manager.ConnectUser(userInput, passwordInput)){
		
			//Création cookie permettant la connexion
			Cookie cookie = new Cookie("authentification", "1");

			response.addCookie(cookie);
		}
	
		
		doGet(request, response);
	}

}
