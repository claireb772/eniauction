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

import org.apache.log4j.Logger;
import org.eniauction.dal.jdbc.DALException;
import org.eniauction.models.bll.UserManager;
import org.eniauction.models.bo.Users;

/**
 * Servlet implementation class EditProfile
 */
@WebServlet(urlPatterns = "/editProfile")
public class EditProfile extends HttpServlet {
	private static final long serialVersionUID = 1L;

	static Logger log = Logger.getLogger(EditProfile.class);

	UserManager um = UserManager.getInstance();;
	int user_nb;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public EditProfile() {
		super();

	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		user_nb = um.getActualUser().getUser_nb();

		List<String> listeErreurs = new ArrayList<>();
		Users userProfile = null;

		try {
			userProfile = um.getUser(user_nb);
			log.info(userProfile + " a modifié son profil");
		} catch (DALException e) {
			e.printStackTrace();
			listeErreurs.add("problème lors de la récupération du profil");
			log.error(listeErreurs.toArray());
			request.setAttribute("listeErreurs", listeErreurs.toArray());
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

		List<String> listeErreurs = new ArrayList<>();

		String pseudo = request.getParameter("pseudo").trim();
		String name = request.getParameter("name").trim();
		String surname = request.getParameter("surname").trim();
		String confirmation = request.getParameter("confirmation");
		String email = request.getParameter("email").trim();
		String phone_nb = request.getParameter("phoneNb").trim();
		String street = request.getParameter("street").trim();
		String postal_code = request.getParameter("postalCode").trim();
		String city = request.getParameter("city").trim();

		String password = request.getParameter("password");

		Pattern passwordPattern = Pattern
				.compile("(?=^.{8,}$)((?=.*\\d)|(?=.*\\W+))(?![.\\n])(?=.*[A-Z])(?=.*[a-z]).*$"); // Min 1maj 1min 1
																									// chiffre 1 char
		Matcher matchingPassword = passwordPattern.matcher(password);
		boolean isMatches = matchingPassword.matches();

		if (isMatches == false) {
			listeErreurs.add(
					"Le mot de passe ne respecte pas les critères de sécurité : doit contenir 1 majuscule,1 minuscule, 1 chiffre ainsi qu'un charactère spécial (*$)");
		}
		if (!password.equals(confirmation)) {
			listeErreurs.add("Les mots de passe ne correspondent pas"); // Password doit �tre �gal a Confirmation, et B=
																		// // respecte les crit�res
		}
		if (pseudo.isBlank()) {
			listeErreurs.add("Merci d'entrer un pseudo");
		}
		if (name.isBlank()) {
			listeErreurs.add("Merci d'entrer un prénom");
		}
		if (surname.isBlank()) {
			listeErreurs.add("Merci d'entrer un nom");
		}
		if (phone_nb.isBlank()) {
			listeErreurs.add("Merci d'entrer un numéro de téléphone");
		}
		if (email.isBlank()) {
			listeErreurs.add("Merci d'entrer une adresse mail");
		}
		if (street.isBlank()) {
			listeErreurs.add("Merci d'entrer une rue");
		}
		if (city.isBlank()) {
			listeErreurs.add("Merci d'entrer une ville");
		}
		if (postal_code.isBlank()) {
			listeErreurs.add("Merci d'entrer un code postal");
		}

		request.setAttribute("listeErreurs", listeErreurs.toArray());

		if (listeErreurs.size() > 0) {
			doGet(request, response);

		} else {

			Users users = new Users(user_nb, pseudo, name, surname, email, phone_nb, street, postal_code, city,
					password);
			System.out.println(user_nb);

			try {
				um.editProfile(users);
				response.sendRedirect("./profil?id=" + user_nb);

			} catch (DALException e) {
				e.printStackTrace();
				listeErreurs.add("problème lors de la mise à jour du profil");
				log.error(listeErreurs.toArray());
				request.setAttribute("listeErreurs", listeErreurs.toArray());
				doGet(request, response);
			}
		}

	}

}
