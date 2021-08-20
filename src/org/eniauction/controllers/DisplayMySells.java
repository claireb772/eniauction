package org.eniauction.controllers;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.eniauction.models.bll.ManagerAuction;
import org.eniauction.models.bo.AuctionComplete;

/**
 * Servlet implementation class myauction
 */
@WebServlet("/mysells")
public class DisplayMySells extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public DisplayMySells() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		try {
			ManagerAuction manager = ManagerAuction.getInstance();
			List<AuctionComplete> listAuction = manager.GetMySells();
			request.setAttribute("listAuction", listAuction.toArray());

		} catch (Exception e) {
			e.getStackTrace();
		}

		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/mysells.jsp");
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
		doGet(request, response);
	}

}
