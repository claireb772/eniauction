package org.eniauction.controllers;

import java.io.IOException;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.eniauction.models.bll.ManagerAuction;
import org.eniauction.models.bll.UserManager;
import org.eniauction.models.bo.Auction;
import org.eniauction.models.bo.AuctionComplete;
import org.eniauction.models.bo.Users;

/**
 * Servlet implementation class DisplayAuctionDetails
 */
@WebServlet(urlPatterns = "/AuctionDetails/*")
public class DisplayAuctionDetails extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public DisplayAuctionDetails() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		ManagerAuction ma = ManagerAuction.getInstance();
		int articleId = Integer.parseInt(request.getParameter("id"));
		AuctionComplete auction = null;
		try {
			auction = ma.getOneAuctionComplete(articleId);

		} catch (Exception e) {
			e.printStackTrace();
		}
		request.setAttribute("auction", auction);
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/AuctionDetail.jsp");
		if (rd != null) {
			rd.forward(request, response);
		}

	}

	/**
	 * @throws IOException
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
		UserManager um = UserManager.getInstance();
		Users user = um.getActualUser();
		int amount = Integer.parseInt(request.getParameter("input_new_amount"));
		int articleId = Integer.parseInt(request.getParameter("article"));
		if (user == null) {
			response.sendRedirect("./login");
		} else {
			Auction auction = new Auction(user.getUser_nb(), articleId, new Date(), amount);
			ManagerAuction ma = ManagerAuction.getInstance();
			ma.SetAuction(auction);
			if (um.getActualUser().getCredit() > auction.getAmount()) {
				um.getActualUser().setCredit(um.getActualUser().getCredit() - auction.getAmount());
			}

			response.sendRedirect("./AuctionDetails?id=" + articleId);

		}

	}

}
