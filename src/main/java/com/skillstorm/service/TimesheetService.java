package com.skillstorm.service;

import java.util.List;

import com.skillstorm.beans.Timesheet;
import com.skillstorm.data.TimesheetDAO;

public class TimesheetService {
	private TimesheetDAO timesheetDAO = new TimesheetDAO();
	
	


	public List<Timesheet> findById(int id) {
			return timesheetDAO.findById(id);
	}

	public Timesheet addTimesheet(Timesheet t, int id) {
		return timesheetDAO.addTimesheet(t, id);
	}

	public void updateTimesheet(Timesheet t, int tid) {
		 timesheetDAO.updateTimesheet(t, tid);
	}
	public void	deleteTimesheet(int tid) {
		 timesheetDAO.deleteTimesheet(tid);
	}


	public Timesheet findOne(int tid) {
		return timesheetDAO.findOne(tid);
	}


}
