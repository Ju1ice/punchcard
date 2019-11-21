package com.skillstorm.beans;

public class Timesheet {
	
	private int timesheetId;
	private int userId;
	private int statusId;
	private double monday;
	private double tuesday;
	private double wednesday;
	private double thursday;
	private double friday;
	private double saturday;
	private double sunday;
	private double weekEnd;
	
	
		
	
	public Timesheet() {
		super();
	}


	public Timesheet(int timesheetId, int userId, int statusId, double monday, double tuesday, double wednesday,
			double thursday, double friday, double saturday, double sunday, double weekEnd) {
		super();
		this.timesheetId = timesheetId;
		this.userId = userId;
		this.statusId = statusId;
		this.monday = monday;
		this.tuesday = tuesday;
		this.wednesday = wednesday;
		this.thursday = thursday;
		this.friday = friday;
		this.saturday = saturday;
		this.sunday = sunday;
		this.weekEnd = weekEnd;
	}
	
	
	public int getTimesheetId() {
		return timesheetId;
	}
	public void setTimesheetId(int timesheetId) {
		this.timesheetId = timesheetId;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public int getStatusId() {
		return statusId;
	}
	public void setStatusId(int statusId) {
		this.statusId = statusId;
	}
	public double getMonday() {
		return monday;
	}
	public void setMonday(double monday) {
		this.monday = monday;
	}
	public double getTuesday() {
		return tuesday;
	}
	public void setTuesday(double tuesday) {
		this.tuesday = tuesday;
	}
	public double getWednesday() {
		return wednesday;
	}
	public void setWednesday(double wednesday) {
		this.wednesday = wednesday;
	}
	public double getThursday() {
		return thursday;
	}
	public void setThursday(double thursday) {
		this.thursday = thursday;
	}
	public double getFriday() {
		return friday;
	}
	public void setFriday(double friday) {
		this.friday = friday;
	}
	public double getSaturday() {
		return saturday;
	}
	public void setSaturday(double saturday) {
		this.saturday = saturday;
	}
	public double getSunday() {
		return sunday;
	}
	public void setSunday(double sunday) {
		this.sunday = sunday;
	}
	public double getWeekEnd() {
		return weekEnd;
	}
	public void setWeekEnd(double weekEnd) {
		this.weekEnd = weekEnd;
	}
	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return super.hashCode();
	}
	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		return super.equals(obj);
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString();
	}
	
	
	
	
	
}
