package org.eniauction.controllers;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.eniauction.models.bll.ManagerAuction;
import org.eniauction.models.bll.UserManager;
import org.eniauction.models.bo.Categories;
import org.eniauction.models.bo.SoldArticles;
import org.eniauction.models.bo.Users;
import org.eniauction.models.bo.Withdrawals;

/**
 * Servlet implementation class DisplayNewAuction
 */
@WebServlet("/NewAuction")
public class DisplayNewAuction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	static Logger log = Logger.getLogger(DisplayNewAuction.class);

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public DisplayNewAuction() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		UserManager um = UserManager.getInstance();
		if (um.getActualUser() != null) {
			ManagerAuction manager = ManagerAuction.getInstance();
			List<Categories> listCategories = manager.GetCategories();
			request.setAttribute("listCategories", listCategories.toArray());
			SimpleDateFormat dt1 = new SimpleDateFormat("yyyy-MM-dd");
			request.setAttribute("today", dt1.format(new Date()));
			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/NewAuction.jsp");
			if (rd != null) {
				rd.forward(request, response);
			}
		} else {
			response.sendRedirect("./login");
		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		String product_name = request.getParameter("product_name");
		String product_desc = request.getParameter("product_desc");
		int product_category = Integer.parseInt(request.getParameter("product_category"));
		// String product_image = request.getParameter("product_image");
		String product_start = request.getParameter("product_start").toString();
		String product_end = request.getParameter("product_end").toString();
		int product_price = Integer.parseInt(request.getParameter("product_price"));
		String takeaway_city = request.getParameter("takeaway_city");
		String takeaway_street = request.getParameter("takeaway_street");
		String takeaway_postal_code = request.getParameter("takeaway_postal_code");
		UserManager um = UserManager.getInstance();
		Users user = um.getActualUser();

		try {
			SoldArticles sa = new SoldArticles(0, product_name, product_desc, dateFormatter(product_start),

					dateFormatter(product_end), product_price, product_price, user.getUser_nb(), product_category,
					true);

			ManagerAuction ma = ManagerAuction.getInstance();

			SoldArticles saReturn = ma.SetNewAuction(sa);
			Withdrawals wd = new Withdrawals(saReturn.getArticle_nb(), takeaway_street, takeaway_postal_code,
					takeaway_city);
			ma.setWithdrawals(wd);

			log.info("Nouvelle enchère de l'utilisateur " + um.getActualUser().getUser_nb());
		} catch (ParseException e) {
			e.printStackTrace();
		}

		response.sendRedirect("./");
	}

	public Date dateFormatter(String dateString) throws ParseException {
		String input = dateString.replaceAll("-", "");
		Date date = new SimpleDateFormat("yyyyMMdd").parse(input);
		return date;
	}

}
