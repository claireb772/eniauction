package org.eniauction.controllers;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.eniauction.dal.jdbc.DALException;
import org.eniauction.models.bll.UserManager;

/**
 * Servlet implementation class DisplayUser
 */
@WebServlet("/login")
public class DisplayConnect extends HttpServlet {
	private static final long serialVersionUID = 1L;

	Logger log = Logger.getLogger(DisplayConnect.class);

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
		if (um.getActualUser() != null) {
			response.sendRedirect("./");

		} else {

			Cookie cookies[] = request.getCookies();
			if (cookies != null) {
				for (int i = 0; i < cookies.length; i++) {
					if (cookies[i].getName().equals("userCookie")) {
						String remindUser = cookies[i].getValue();
						request.setAttribute("remindUser", remindUser);
					}
					if (cookies[i].getName().equals("passwordCookie")) {
						String remindPassword = cookies[i].getValue();
						request.setAttribute("remindPassword", remindPassword);
					}
				}
			}
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
		boolean isAdmin = false;

		try {
			if (manager.ConnectUser(userInput, passwordInput)) {

				// Création session permettant la connexion
				HttpSession session = request.getSession();

				session.setAttribute("authentification", "1");
				session.setAttribute("id", manager.getActualUser().getUser_nb());
				// utilisateur déconnecté au bout de 300 secondes d'inactivité (5 min)
				session.setMaxInactiveInterval(300);

				System.out.println(manager.getActualUser().isAdministrator());

				if (manager.getActualUser().isAdministrator()) {
					isAdmin = true;
				}
				session.setAttribute("isAdmin", isAdmin);

				log.info("Connexion de l'utilisateur " + manager.getActualUser().getName() + ", identifiant numéro : "
						+ manager.getActualUser().getUser_nb());

				// Feature "Se souvenir de moi" stocker dans des cookies
				// Les cookies se réactualisent si vous recochez "se souvenir de moi"
				if (remind != null) {
					Cookie cookies[] = request.getCookies();
					for (int i = 0; i < cookies.length; i++) {
						if (cookies[i].getName().equals("userCookie")) {

							cookies[i].setValue(userInput);

						} else {

							Cookie userCookie = new Cookie("userCookie", userInput);
							response.addCookie(userCookie);

						}
						if (cookies[i].getName().equals("passwordCookie")) {

							cookies[i].setValue(passwordInput);

						} else {

							Cookie passwordCookie = new Cookie("passwordCookie", passwordInput);
							response.addCookie(passwordCookie);

						}
					}

				}

			}else{
				String Erreur = "Adresse où mot de passe incorrect";
				request.setAttribute("Erreur", Erreur);
			}
		} catch (DALException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		doGet(request, response);
	}

}
