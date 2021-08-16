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
 * Servlet implementation class DisplayUser
 */
@WebServlet("/profil")
public class DisplayUser extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * Default constructor.
	 */
	public DisplayUser() {
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

		int user_nb = Integer.parseInt(request.getParameter("id"));
		int actualUser = 0;

		if (um.getActualUser() != null) {
			actualUser = um.getActualUser().getUser_nb();
		}

		boolean isActualUser = false;

		Users userProfile = null;

		if (user_nb == actualUser) {
			isActualUser = true;
		}

		try {
			userProfile = um.getUser(user_nb);
		} catch (Exception e) {
			e.printStackTrace();
			String message = "problème lors de la récupération du profil";
			request.setAttribute("message", message);
		}

		request.setAttribute("userProfile", userProfile);
		request.setAttribute("isActualUser", isActualUser);

		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/profile.jsp");
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
		doGet(request, response);
	}

}
