package org.eniauction.controllers;

import java.io.IOException;
import java.time.LocalDate;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.eniauction.models.bll.UserManager;
import org.eniauction.models.bo.*;

/**
 * Servlet implementation class DisplayNewAuction
 */
@WebServlet("/NewAuction")
public class DisplayNewAuction extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DisplayNewAuction() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		//SoldArticles sold = new SoldArticles(0,product_name,product_desc,datedebut,datefin,product_price,product_price,user,product_category);
		
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/NewAuction.jsp");
		if (rd != null) {
			rd.forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String product_name = request.getParameter("product_name");
		String product_desc = request.getParameter("product_desc");
		int product_category = Integer.parseInt(request.getParameter("product_category"));
		String product_image = request.getParameter("product_image");
		String product_start = request.getParameter("product_start").toString();
		String product_end = request.getParameter("product_end").toString();
		int product_price = Integer.parseInt(request.getParameter("product_price"));
		String takeaway_city = request.getParameter("takeaway_city");
		String takeaway_street = request.getParameter("takeaway_street");
		String takeaway_postal_code = request.getParameter("takeaway_postal_code");
		
		SoldArticles sa = new SoldArticles(0, product_name, product_desc, null, null, product_price, product_price, 0, product_category);
		//LocalDate ld = LocalDate.parse(product_start, null);
		UserManager um = UserManager.getInstance();
		//Users user = um.GetActualUser();
		System.out.println(product_start);
		System.out.println(product_end);
		doGet(request, response);
	}

}
