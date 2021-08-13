package org.eniauction.controllers;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.eniauction.models.bll.UserManager;


/**
 * Servlet implementation class DisplayUser
 */
@WebServlet("/logout")
public class DisplayLogout extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * Default constructor.
	 */
	public DisplayLogout() {
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
		//TODO Auto-generated constructor stub
		HttpSession session = request.getSession();
		
		
		// Quand l'utilisateur clique sur "se deconnecter" la variable de session authentification passe de 0 à 1
		session.setAttribute("authentification", "0");
		UserManager um = UserManager.getInstance();
		um.setActualUser(null);
		response.sendRedirect("./");
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
