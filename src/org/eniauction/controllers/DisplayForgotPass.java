package org.eniauction.controllers;

import java.io.IOException;
import java.util.List;

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
import org.eniauction.models.bo.Question;

/**
 * Servlet implementation class DisplayUser
 */
@WebServlet("/forgotpass")
public class DisplayForgotPass extends HttpServlet {
	private static final long serialVersionUID = 1L;

	static Logger log = Logger.getLogger(DisplayForgotPass.class);

	/**
	 * Default constructor.
	 */
	public DisplayForgotPass() {
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

		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/forgotpass.jsp");
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
		int Question_id = Integer.parseInt(request.getParameter("question"));
		String Réponse = request.getParameter("answer").trim();
		String Email = request.getParameter("Email").trim();

		ManagerQuestion manager = ManagerQuestion.getInstance();
		try {
			if (manager.VerifUser(Question_id, Réponse, Email)) {
				// Création session permettant la connexion
				HttpSession session = request.getSession();

				session.setAttribute("newpassword", Email);
				response.sendRedirect("./newpass");
			} else {
				response.sendRedirect("./forgotpass");
			}
		} catch (DALException e) {
			e.printStackTrace();
		}

	}

}
