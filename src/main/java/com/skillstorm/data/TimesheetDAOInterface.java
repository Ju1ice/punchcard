package com.skillstorm.data;

import java.util.List;

import com.skillstorm.beans.Timesheet;
import com.skillstorm.beans.User;

public interface TimesheetDAOInterface {
	public List<Timesheet> findById(int id);
	public Timesheet findOne(int tid);
	public Timesheet addTimesheet(Timesheet t, int id);
	public User checkUser(String username, String password);
	void updateTimesheet(Timesheet t, int tid);
}
