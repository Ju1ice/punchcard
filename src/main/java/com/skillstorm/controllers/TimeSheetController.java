package com.skillstorm.controllers;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.skillstorm.beans.Timesheet;
import com.skillstorm.beans.User;
import com.skillstorm.service.TimesheetService;

public class TimeSheetController {
	
	private TimesheetService timesheetService = new TimesheetService();

	public void getTimesheet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int userId=((User)req.getSession().getAttribute("authuser")).getUserId();

			resp.getWriter().println(new ObjectMapper()
					.writeValueAsString(timesheetService.findById(userId)));

	}
	
	public void addTimesheet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int userId=((User)req.getSession().getAttribute("authuser")).getUserId();
		resp.setContentType("application/json");
		Timesheet timesheetFromjs = new ObjectMapper().readValue(req.getInputStream(), Timesheet.class);	
		System.out.println("This is timeshetjs from js "+ timesheetFromjs.toString() );
		resp.getWriter().println(new ObjectMapper().writeValueAsString(timesheetService.addTimesheet(timesheetFromjs, userId)));
			
		// headers
		resp.setStatus(201);
	}
	
	public void updateTimesheet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int tid = Integer.parseInt((String) req.getSession().getAttribute("tid"));
		System.out.println("This is tid: " +tid);
		System.out.println("You are in timesheet controller");
		//resp.setContentType("application/json");
		//Timesheet timesheetFromjs = new ObjectMapper().readValue(req.getInputStream(), Timesheet.class);	
		//System.out.println("This is timeshetjs from js "+ timesheetFromjs.toString() );
		//resp.getWriter().println(new ObjectMapper().writeValueAsString(timesheetService.updateTimesheet(timesheetFromjs, timesheetId)));
		if(req.getMethod().equals("POST")) {
			Timesheet timesheetFromjs = new ObjectMapper().readValue(req.getInputStream(), Timesheet.class);	
			System.out.println("This is timeshetjs from js in update "+ timesheetFromjs.toString() );
			timesheetService.updateTimesheet(timesheetFromjs, tid);
			resp.getWriter().println("SUCCESS UPDATING");

		}
		else {
		resp.getWriter().println(new ObjectMapper()
				.writeValueAsString(timesheetService.findOne(tid)));		// headers
		resp.setStatus(201);
		}
	}
	
	
	

}
