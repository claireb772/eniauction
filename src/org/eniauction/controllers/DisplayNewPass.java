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

import org.apache.log4j.Logger;
import org.eniauction.dal.jdbc.DALException;
import org.eniauction.models.bll.ManagerQuestion;
import org.eniauction.models.bll.UserManager;
import org.eniauction.models.bo.Question;

/**
 * Servlet implementation class DisplayUser
 */
@WebServlet("/newpass")
public class DisplayNewPass extends HttpServlet {
	private static final long serialVersionUID = 1L;

	static Logger log = Logger.getLogger(DisplayForgotPass.class);

	/**
	 * Default constructor.
	 */
	public DisplayNewPass() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		try {
			ManagerQuestion manager = ManagerQuestion.getInstance();
			List<Question> listQuestion = manager.getAllQuestion();
			request.setAttribute("listAuction", listQuestion.toArray());
		} catch (Exception e) {
			e.getStackTrace();
		}

		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/newpass.jsp");
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
		HttpSession session = request.getSession();
		if (session.getAttribute("newpassword") == null || session.getAttribute("newpassword") == "") {
			response.sendRedirect("./");
		}
		List<String> ListeErreur = new ArrayList<String>();
		String Password = request.getParameter("Password").trim();
		Pattern p = Pattern.compile("(?=^.{8,}$)((?=.*\\d)|(?=.*\\W+))(?![.\\n])(?=.*[A-Z])(?=.*[a-z]).*$");
		Matcher m = p.matcher(Password);
		boolean b = m.matches();
		String Confirmation = request.getParameter("Confirmation").trim();
		String email = (String) session.getAttribute("newpassword");

		if (b == false) {
			ListeErreur.add(
					"Le mot de passe ne respecte pas les crit�res de s�curit�: doit contenir 1 majuscule,1 minuscule, 1 chiffre ainsi qu'un charact�re sp�cial (*$)");
		}
		if (!Password.equals(Confirmation)) {
			ListeErreur.add("Les mots de passe ne correspondent pas"); // Password doit �tre �gal a Confirmation, et B=
																		// respecte les crit�res
		}
		if (ListeErreur.size() > 0) {
			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/sign.jsp");
			if (rd != null) {
				rd.forward(request, response);
			}
		} else {

			UserManager manager = UserManager.getInstance();
			try {
				manager.setNewPasswordByEmail(email, Password);
				session.setAttribute("newpassword", null);
				response.sendRedirect("./login");
			} catch (DALException e) {
				e.printStackTrace();
			}
		}
	}

}
