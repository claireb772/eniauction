package org.eniauction.controllers;

import java.io.IOException;

import org.eniauction.models.bll.UserManager;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

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
		

		UserManager um = UserManager.getInstance();
		if(um.getActualUser() != null) {
			response.sendRedirect("./");
			
		}else {
			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/login.jsp");
			if (rd != null) {
				rd.forward(request, response);
			}
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
		String remind = request.getParameter("remind");
		
		
		if(manager.ConnectUser(userInput, passwordInput)){
		
			//Création session permettant la connexion
			HttpSession session = request.getSession();
			
			session.setAttribute("authentification", "1");
			session.setAttribute("id", manager.getActualUser().getUser_nb());
			session.setMaxInactiveInterval(300);
			
			// Feature "Se souvenir de moi" stocker dans des cookies 
			if(remind != null){
				Cookie userCookie = new Cookie("userCookie", userInput);
				Cookie passwordCookie = new Cookie("passwordCookie", passwordInput);
				response.addCookie(userCookie);
				response.addCookie(passwordCookie);
			}
			
		}
		
		
		doGet(request, response);
	}

}
