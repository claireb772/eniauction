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
import javax.servlet.http.HttpSession;

import org.eniauction.dal.jdbc.DALException;
import org.eniauction.models.bll.ManagerQuestion;
import org.eniauction.models.bll.UserManager;
import org.eniauction.models.bo.Question;
import org.eniauction.models.bo.Users;

/**
 * Servlet implementation class DisplayRegister
 */
@WebServlet("/sign")
public class DisplayRegister extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public DisplayRegister() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		try {
			ManagerQuestion manager = ManagerQuestion.getInstance();
			List<Question> listQuestion = manager.getAllQuestion();
			request.setAttribute("listAuction", listQuestion.toArray());
		} catch (Exception e) {
			e.getStackTrace();
		}

		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/sign.jsp");
		if (rd != null) {
			rd.forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		List<String> ListeErreur = new ArrayList<String>();
		String Pseudo = request.getParameter("Pseudo").trim();
		String Name = request.getParameter("Name").trim();
		String Password = request.getParameter("Password").trim();
		Pattern p = Pattern.compile("(?=^.{8,}$)((?=.*\\d)|(?=.*\\W+))(?![.\\n])(?=.*[A-Z])(?=.*[a-z]).*$");
		Matcher m = p.matcher(Password);
		boolean b = m.matches();
		String Confirmation = request.getParameter("Confirmation").trim();
		String Surname = request.getParameter("Surname").trim();
		String Phone = request.getParameter("Phone").trim();
		String Email = request.getParameter("Email").trim();
		String Street = request.getParameter("Street").trim();
		String City = request.getParameter("City").trim();
		String PostalCode = request.getParameter("PostalCode").trim();
		String Answer = request.getParameter("Answer").trim();
		int Question_id = Integer.parseInt(request.getParameter("question"));

		if (b == false) {
			ListeErreur.add(
					"Le mot de passe ne respecte pas les crit�res de s�curit�: doit contenir 1 majuscule,1 minuscule, 1 chiffre ainsi qu'un charact�re sp�cial (*$)");
		}
		if (!Password.equals(Confirmation)) {
			ListeErreur.add("Les mots de passe ne correspondent pas"); // Password doit �tre �gal a Confirmation, et B=
																		// respecte les crit�res
		}
		if (Pseudo.isBlank()) {
			ListeErreur.add("Merci d'entrer un pseudo");
		}
		if (Name.isBlank()) {

			ListeErreur.add("Merci d'entrer un pr�nom");
		}
		if (Surname.isBlank()) {
			ListeErreur.add("Merci d'entrer un nom");
		}
		if (Phone.isBlank()) {

			ListeErreur.add("Merci d'entrer un num�ro de téléphone");
		}
		if (Email.isBlank()) {
			ListeErreur.add("Merci d'entrer une adresse mail");
		}
		if (Street.isBlank()) {
			ListeErreur.add("Merci d'entrer une rue");
		}
		if (City.isBlank()) {
			ListeErreur.add("Merci d'entrer une ville");
		}
		if (PostalCode.isBlank()) {
			ListeErreur.add("Merci d'entrer un code postal");
		}

		request.setAttribute("ListeErreur", ListeErreur.toArray());

		if (ListeErreur.size() > 0) {
			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/sign.jsp");
			if (rd != null) {
				rd.forward(request, response);

			}

		} else {
			Users user = new Users(0, Pseudo, Name, Surname, Email, Phone, Street, PostalCode, City, Password, Answer,
					0, 0, Question_id, false, true);
			UserManager um = UserManager.getInstance();
			String message = null;

			try {
				var o = um.newUser(user);
			} catch (DALException e) {
				e.printStackTrace();

			}

			try {
				if (um.ConnectUser(Email, Password)) {

					// Création session permettant la connexion
					HttpSession session = request.getSession();

					session.setAttribute("authentification", "1");
					session.setAttribute("id", um.getActualUser().getUser_nb());
					session.setMaxInactiveInterval(300);

					response.sendRedirect("./");

				}
			} catch (IOException e) {

				e.printStackTrace();
			} catch (DALException e) {

				e.printStackTrace();
			}

		}

	}
}