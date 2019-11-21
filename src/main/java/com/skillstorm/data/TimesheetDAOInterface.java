package com.skillstorm.data;

import java.util.List;

import com.skillstorm.beans.Timesheet;
import com.skillstorm.beans.User;

public interface TimesheetDAOInterface {
	
	public User findByUsername(String username);
	public List<Timesheet> findTimesheetByUser(int id);
	public Timesheet findTimesheetById(int id);
	public void save(Timesheet t);
	public void update(Timesheet t);

}
