package org.eniauction.controllers;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.eniauction.models.bll.UserManager;

/**
 * Servlet implementation class DeleteProfil
 */
@WebServlet("/deleteProfil")
public class DeleteProfil extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public DeleteProfil() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		List<String> messagesErreur = new ArrayList<>();

		UserManager um = UserManager.getInstance();

		int user_nb = um.getActualUser().getUser_nb();

		try {
			um.deleteProfile(user_nb);
			response.sendRedirect("./logout");

		} catch (Exception e) {
			e.printStackTrace();
			messagesErreur.add("problème lors de la suppression du profil");
			request.setAttribute("message", messagesErreur);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
