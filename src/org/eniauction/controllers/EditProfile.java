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
 * Servlet implementation class EditProfile
 */
@WebServlet(urlPatterns = "/editProfile/*")
public class EditProfile extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public EditProfile() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// TODO
		// recupération du nb_user

		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/editProfile.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		int user_nb = 1;

		String pseudo = request.getParameter("pseudo");
		String name = request.getParameter("name");
		String surname = request.getParameter("surname");
		String email = request.getParameter("email");
		String phone_nb = request.getParameter("phoneNb");
		String street = request.getParameter("street");
		String postal_code = request.getParameter("postalCode");
		String city = request.getParameter("city");

		String password = request.getParameter("password");
		// Faire la verif de la confirmation du mot de passe avant
		// String confirmation = request.getParameter("confirmation");

		Users users = new Users(user_nb, pseudo, name, surname, email, phone_nb, street, postal_code, city, password);

		UserManager um = UserManager.getInstance();

		um.editProfile(users);

		// rajouter un message si l'ajout a bien été fait

		doGet(request, response);
	}

}
