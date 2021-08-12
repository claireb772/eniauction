package org.eniauction.controllers;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.eniauction.models.bll.ManagerAuction;
import org.eniauction.models.bll.ManagerConnect;
import org.eniauction.models.bo.SoldArticles;
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
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/welcome.jsp");
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
		ManagerConnect manager = ManagerConnect.getInstance();
		List<Users> Users = manager.GetUsers();
		
		String user = request.getParameter("user");
		String password = request.getParameter("password");
		
		
		for (Users users : Users)s {
			
			if(users.getPseudo.equals("123") && password.equals("123")){
				
				//Création cookie permettant la connexion
				//Cookie cookie = new Cookie("Connect", "true");

				//response.addCookie(cookie);
			}
		}
		
		doGet(request, response);
	}

}