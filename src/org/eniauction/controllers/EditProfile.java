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
@WebServlet(urlPatterns = "/editProfile")
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

		UserManager um = UserManager.getInstance();
		String param = request.getParameter("param");
		int user_nb = Integer.valueOf(param);
		Users userProfile = um.getUser(user_nb);
		request.setAttribute("userProfile", userProfile);
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/editProfile.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		UserManager um = UserManager.getInstance();
		int user_nb = um.getActualUser().getUser_nb();

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

		String message = null;
		try {
			um.editProfile(users);
			response.sendRedirect("./profil");
		} catch (Exception e) {

			e.printStackTrace();
			message = "problème lors de la mise à jour du profil";
			request.setAttribute("message", message);

		}

	}

}
