package org.eniauction.controllers;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.eniauction.models.bll.ManagerCategories;
import org.eniauction.models.bo.Categories;

/**
 * Servlet implementation class EditCategory
 */
@WebServlet("/editCategory")
public class EditCategory extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private int category_nb = 0;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public EditCategory() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ManagerCategories mc = ManagerCategories.getInstance();

		category_nb = Integer.parseInt(request.getParameter("id"));

		Categories category = mc.GetCategoryById(category_nb);

		request.setAttribute("category", category);

		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/editCategory.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ManagerCategories mc = ManagerCategories.getInstance();

		String wording = request.getParameter("wording").trim();

		Categories cat = new Categories(category_nb, wording);

		try {
			mc.updateCategory(cat);
			response.sendRedirect("./categories");

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			doGet(request, response);
		}

	}

}
