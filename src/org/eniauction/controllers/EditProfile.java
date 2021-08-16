package org.eniauction.controllers;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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

		int user_nb = um.getActualUser().getUser_nb();

		Users userProfile = null;
		try {
			userProfile = um.getUser(user_nb);
		} catch (Exception e) {
			e.printStackTrace();

			String message = "problème lors de la récupération du profil";
			request.setAttribute("message", message);

		}
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
		List<String> messagesErreur = new ArrayList<>();

		String pseudo = request.getParameter("pseudo").trim();
		String name = request.getParameter("name").trim();
		String surname = request.getParameter("surname").trim();
		String email = request.getParameter("email").trim();
		String phone_nb = request.getParameter("phoneNb").trim();
		String street = request.getParameter("street").trim();
		String postal_code = request.getParameter("postalCode").trim();
		String city = request.getParameter("city").trim();

		String password = request.getParameter("password");

		Pattern passwordPattern = Pattern
				.compile("(?=^.{8,}$)((?=.*\\d)|(?=.*\\W+))(?![.\\n])(?=.*[A-Z])(?=.*[a-z]).*$"); // Min 1maj 1min 1
																									// chiffre 1 char
																									// special
		Matcher matchingPassword = passwordPattern.matcher(password);
		// boolean isMatches = matchingPassword.matches();
		boolean isMatches = false;

		if (isMatches == false) {
			messagesErreur.add(
					"Les mots de passe ne concordent pas. Il faut au moins une majuscule, 1 chiffre et 1 caractère spécial");

		} else {

			Users users = new Users(user_nb, pseudo, name, surname, email, phone_nb, street, postal_code, city,
					password);

			try {
				um.editProfile(users);
				response.sendRedirect("./profil");
			} catch (Exception e) {

				e.printStackTrace();
				messagesErreur.add("problème lors de la mise à jour du profil");
			}
		}

		if (messagesErreur.size() > 0) {
			request.setAttribute("message", messagesErreur);
		}

	}

}
