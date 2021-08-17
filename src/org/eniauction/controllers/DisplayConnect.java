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

	static Logger log = Logger.getLogger(DisplayConnect.class);

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
						System.out.println(remindUser);
					}
					if (cookies[i].getName().equals("passwordCookie")) {
						String remindPassword = cookies[i].getValue();
						request.setAttribute("remindPassword", remindPassword);
						System.out.println(remindPassword);
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

		try {
			if (manager.ConnectUser(userInput, passwordInput)) {

				// Création session permettant la connexion
				HttpSession session = request.getSession();

				session.setAttribute("authentification", "1");
				session.setAttribute("id", manager.getActualUser().getUser_nb());
				session.setMaxInactiveInterval(300);

				log.info("Connexion de l'utilisateur numero " + manager.getActualUser().getUser_nb());

				// Feature "Se souvenir de moi" stocker dans des cookies
				if (remind != null) {
					Cookie userCookie = new Cookie("userCookie", userInput);
					Cookie passwordCookie = new Cookie("passwordCookie", passwordInput);
					response.addCookie(userCookie);
					response.addCookie(passwordCookie);
				}

			}
		} catch (DALException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		doGet(request, response);
	}

}
