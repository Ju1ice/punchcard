package com.skillstorm.controllers;

import java.io.IOException;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import com.skillstorm.beans.User;
import com.skillstorm.data.TimesheetDAO;

public class FrontController extends HttpServlet{
	private TimeSheetController timeSheetController = new TimeSheetController();

	
	protected void doDispatch(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		/*
		 * 
		 * System.out.println("This is what recieved in FrontController: " +
		 * req.getParameter("username")); if(req.getRequestURI().contains("yourtime")) {
		 */ 
		System.out.println("You are in doDIspatch");
		
		}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		if(req.getRequestURI().contains("/punchcard/yourtime/timesheets/")) {
			System.out.println("GET GET GET");
			TimesheetDAO dao = new TimesheetDAO();
			User authUser = new User();
			timeSheetController.getTimesheet(req, res);
		}
		else if(req.getRequestURI().contains("/punchcard/yourtime/updateTimesheet/")) {
			System.out.println("You are here: Update Timesheet in Front Controller");
			if(req.getParameter("tid") != null) {
				HttpSession session = req.getSession(true);
				//set a string session attribute
				session.setAttribute("tid", req.getParameter("tid"));
				System.out.println("setting tid session");
				RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/update.html");
				dispatcher.forward(req, res);
			}else {
				System.out.println("calling timesheet controller");
			timeSheetController.updateTimesheet(req, res);
	
			}
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		if(req.getRequestURI().contains("/punchcard/yourtime/addTimesheet")) {
			//System.out.println("This is a obj from js: " + req.getParameterMap());
			timeSheetController.addTimesheet(req, res);
System.out.println("You are in addTimesheet in doPost");
}
		else if(req.getRequestURI().contains("/punchcard/yourtime/updateTimesheet")) {
			System.out.println("You are in updateTimesheet in doPost");
			timeSheetController.updateTimesheet(req, res);
		}
		else if(req.getRequestURI().contains("/punchcard/yourtime/")) {
			String uri = req.getRequestURI();
			System.out.println("URI....." +  req.getRequestURI());
			 //req.getRequestDispatcher("index.html").forward(req, resp);	
				//System.out.println("BINGO");
				if(req.getMethod().equals("POST")) {
					//System.out.println("BINGO2");
				if (req.getSession().getAttribute("authuser") != null) {
					RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/index.html");
					dispatcher.forward(req, res);	
					System.out.println("Session is not null");
					//System.out.println("This is what recieve in AuthFilter Username: "  + req.getParameter("username"));
					//System.out.println("This is what recieve in AuthFilter Password: "  + req.getParameter("password"));

				}
				else {
					//System.out.println("BINGO3");
				TimesheetDAO dao = new TimesheetDAO();
				User authUser = new User();
				String username = req.getParameter("username");
				String password = req.getParameter("password");
				authUser = dao.checkUser(username, password);
				if(authUser!=null) {
					//System.out.println("BINGO4");
				System.out.println("*************\n Auth User Object: " + authUser+"\n"+ username + " " +password + "\n***************");
				//Obtain the session object, create a new session if doesn't exist
				HttpSession session = req.getSession(true);
				//set a string session attribute
				session.setAttribute("authuser", authUser);
				RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/index.html");
				dispatcher.forward(req, res);	
				}
				else {
					//System.out.println("This is the type of request: " + req.getMethod());
					System.out.println("ELSE : : This received in AuthFilter session: "  + req.getParameter("username"));
					res.sendRedirect("/punchcard/login.html");

				}
				}
			}
			
		}
		else {
		doDispatch(req, res);
		}
	}

	@Override
	public void init() throws ServletException {
		System.out.println("Servlet initialized");
	}

	
	

}
