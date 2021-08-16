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
 * Servlet implementation class DisplayAuctionDetails
 */
@WebServlet( urlPatterns = "/AuctionDetails/*")
public class DisplayAuctionDetails extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DisplayAuctionDetails() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		

		ManagerAuction ma = ManagerAuction.getInstance();
		int articleId = Integer.parseInt(request.getParameter("id")); 
		AuctionComplete auction = ma.getOneAuctionComplete(articleId);
		request.setAttribute("auction", auction);
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/AuctionDetail.jsp");
		if (rd != null) {
			rd.forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
