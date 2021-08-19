package org.eniauction.controllers;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.eniauction.models.bll.ManagerAuction;
import org.eniauction.models.bll.UserManager;
import org.eniauction.models.bo.Users;
/**
 * Servlet Filter implementation class DarkModeFilter
 */
@WebFilter("/*")
public class DarkModeFilter implements Filter {

    /**
     * Default constructor. 
     */
    public DarkModeFilter() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		
		HttpServletRequest httpRequest = (HttpServletRequest)request;
		HttpSession session =  httpRequest.getSession();
		
		UserManager um = UserManager.getInstance();
		if(um.getActualUser() != null) {
			Users user = um.getActualUser();
			session.setAttribute("money", String.valueOf(user.getCredit()));
			System.out.println(session.getAttribute("money"));
		}
		

		if (session.getAttribute("darkMode") == null) {
		    session.setAttribute("darkMode", "0");
		}
		
		if (request.getParameter("darkMode") != null) {
		    session.setAttribute("darkMode", request.getParameter("darkMode"));
		}
		chain.doFilter(request, response);
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
