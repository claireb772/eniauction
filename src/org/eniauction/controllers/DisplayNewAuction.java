package org.eniauction.controllers;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Paths;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import org.apache.tomcat.util.http.fileupload.FileItemFactory;
import org.apache.tomcat.util.http.fileupload.disk.DiskFileItemFactory;
import org.apache.tomcat.util.http.fileupload.servlet.ServletFileUpload;
import org.eniauction.models.bll.ManagerAuction;
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
		UserManager um = UserManager.getInstance();
		if(um.getActualUser() != null) {
			ManagerAuction manager = ManagerAuction.getInstance();
			List<Categories> listCategories = manager.GetCategories();
			request.setAttribute("listCategories", listCategories.toArray());
			
			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/NewAuction.jsp");
			if (rd != null) {
				rd.forward(request, response);
			}
		}
		else {
			response.sendRedirect("./login");
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println(request.getParameter("product_image"));
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
		UserManager um = UserManager.getInstance();
		Users user = um.getActualUser();
		try {
			SoldArticles sa = new SoldArticles(0, product_name, product_desc, dateFormatter(product_start), dateFormatter(product_end), product_price, product_price, 1/*user.getUser_nb()*/, product_category);
			ManagerAuction ma = ManagerAuction.getInstance();
			ma.SetNewAuction(sa);
		} catch (ParseException e) {
			System.out.println("creation sa servlet");
			e.printStackTrace();
		}

	}
	
	public Date dateFormatter(String dateString) throws ParseException {
		String input = dateString.replaceAll("-","");
		Date date = new SimpleDateFormat( "yyyyMMdd" ).parse( input );
		return date;
	}

}
