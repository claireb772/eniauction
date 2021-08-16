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
 * Servlet implementation class DisplayAuction
 */
@WebServlet("/")
public class DisplayAuction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public DisplayAuction() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ManagerAuction manager = ManagerAuction.getInstance();
		List<AuctionComplete> listAuction = null;

		try {
			listAuction = manager.GetAuction();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		request.setAttribute("listAuction", listAuction.toArray());
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/Index.jsp");

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
		// TODO Auto-generated method stub

		String searchInput = request.getParameter("search");

		ManagerAuction manager = ManagerAuction.getInstance();
		List<AuctionComplete> listAuction = null;
		try {
			listAuction = manager.GetSearch(searchInput);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		request.setAttribute("listAuction", listAuction.toArray());
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/Index.jsp");

		doGet(request, response);
	}

}
