package com.skillstorm.controllers;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.skillstorm.beans.User;
import com.skillstorm.data.TimesheetDAO;

/**
 * Servlet Filter implementation class AuthFilter
 */

public class AuthFilter implements Filter {

    /**
     * Default constructor. 
     */
    public AuthFilter() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		System.out.println("Filter Destroyed");
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		System.out.println("Started Filtering");
		
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse res = (HttpServletResponse) response;

		if (req.getSession().getAttribute("username") != null) {
			//res.sendRedirect("/yourtime");
			System.out.println("Session is not null");
			System.out.println("This is what recieve in AuthFilter Username: "  + req.getParameter("username"));
			System.out.println("This is what recieve in AuthFilter Password: "  + req.getParameter("password"));

			chain.doFilter(req, response);
		}
		else {
		TimesheetDAO dao = new TimesheetDAO();
		User authUser = new User();
		String username = request.getParameter("username");
		//System.out.println("Username: " + username);
		String password = request.getParameter("password");
		//System.out.println("Password: " + password);		
		authUser = dao.checkUser(username, password);
		if(authUser!=null) {		
		//System.out.println("Auth User: " + authUser.getUsername());
		//System.out.println("Auth User Password: " + authUser.getPassword());
		System.out.println("*************\n Auth User Object: " + authUser+"\n"+ username + " " +password + "\n***************");
		//Obtain the session object, create a new session if doesn't exist
		HttpSession session = req.getSession(true);
		//set a string session attribute
		session.setAttribute("username", username);
		chain.doFilter(req, response);
		}
		else {
			//System.out.println("This is the type of request: " + req.getMethod());
			System.out.println("This received in AuthFilter session: "  + req.getParameter("username"));
			res.sendRedirect("login.html");
		}
		}
		
		
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
		System.out.println("Filter Init");
	}

}
