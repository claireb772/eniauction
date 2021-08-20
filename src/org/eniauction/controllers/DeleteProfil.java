package org.eniauction.controllers;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.eniauction.dal.jdbc.DALException;
import org.eniauction.models.bll.UserManager;

/**
 * Servlet implementation class DeleteProfil
 */
@WebServlet("/deleteProfil")
public class DeleteProfil extends HttpServlet {
	private static final long serialVersionUID = 1L;

	static Logger log = Logger.getLogger(DeleteProfil.class);

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public DeleteProfil() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		List<String> messagesErreur = new ArrayList<>();

		UserManager um = UserManager.getInstance();

		int user_nb = Integer.parseInt(request.getParameter("id"));

		try {
			um.deleteProfile(user_nb);
			log.info("L'utilisateur " + user_nb + "a supprimé son profil");

			if (!um.getActualUser().isAdministrator()) {
				response.sendRedirect("./logout");
			} else {
				response.sendRedirect("./comptes");
			}

		} catch (DALException e) {
			e.printStackTrace();
			messagesErreur.add("problème lors de la suppression du profil");
			log.error("L'utilisateur" + user_nb + " a eu un problème pendant la suppression de son compte");
			request.setAttribute("message", messagesErreur);
		}
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
