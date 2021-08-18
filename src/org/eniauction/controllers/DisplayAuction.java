package org.eniauction.controllers;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import org.eniauction.models.bll.ManagerAuction;
import org.eniauction.models.bo.*;

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
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		

		ManagerAuction manager = ManagerAuction.getInstance();
		if(request.getParameter("validSearch") == null) 
		{
			try 
			{
				
				int page = 0;
				if(request.getParameter("page") != null) {
					page = Integer.parseInt(request.getParameter("page"));
				}
				
				List<AuctionComplete> listAuction = manager.GetAuction("",page);
				request.setAttribute("listAuction", listAuction.toArray());
				}catch(Exception e){
					e.getStackTrace();
				}
			}
		int nbPage = (int) Math.ceil(manager.GetAllSoldArticlesCount()/9)+1;
		List<Button>listPage = new ArrayList<Button>();
		for(int i = 0; i<nbPage;i++) {
			
			Button btn = new Button(i, String.valueOf(i+1));
			listPage.add(btn);
		}
		request.setAttribute("listPage", listPage.toArray());
		request.setAttribute("actualPage", request.getParameter("page"));
		request.setAttribute("maxPage", nbPage);
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/Index.jsp");
		if (rd != null) {
				rd.forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String searchInput = request.getParameter("search");
		try {
			int page = 0;
			if(request.getParameter("page") != null) {
				page = Integer.parseInt(request.getParameter("page"));
			}
			
			ManagerAuction manager = ManagerAuction.getInstance();
			List<AuctionComplete> listAuction = manager.GetSearch(searchInput,page);
			request.setAttribute("listAuction", listAuction.toArray());
			request.setAttribute("searchInput", searchInput);
			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/Index.jsp");
		}catch(Exception e){
			e.getStackTrace();
	}
		doGet(request, response);
	}

}
