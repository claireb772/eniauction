package org.eniauction.controllers;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

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
 * Servlet implementation class ComptesAdmin
 */
@WebServlet("/comptes")
public class ComptesAdmin extends HttpServlet {

	static Logger log = Logger.getLogger(ComptesAdmin.class);
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ComptesAdmin() {
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
		List<String> listeErreurs = new ArrayList<>();
		List<Users> usersList = new ArrayList<>();

		try {
			usersList = um.getAllUsers();

		} catch (DALException e) {
			listeErreurs.add("problème lors de la récupération du profil");
			log.error(listeErreurs.toArray());
			request.setAttribute("listeErreurs", listeErreurs.toArray());
		}
		request.setAttribute("usersList", usersList.toArray());
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/comptes.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
