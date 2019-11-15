package punchcardcom.skillstorm.data;

import java.util.List;

public class TimesheetDAO {
	
	public User findByUsername(String username) {}
	public List<Timesheet> findTimesheetByUser(int id) {}
	public Timesheet findTimesheetById(int id) {}
	public Timesheet save(Timesheet t) {}
	public Timesheet update(Timesheet t) {}
}
