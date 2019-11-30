package com.skillstorm.beans;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Timesheet {
	
	private int timesheetId = 0;
	private int userId = 0;
	private int statusId = 0;
	private double monday = 0;
	private double tuesday = 0;
	private double wednesday = 0;
	private double thursday = 0;
	private double friday = 0;
	private double saturday = 0;
	private double sunday = 0;
	private int weekend = 0;
	
	
		
	
	public Timesheet() {
		super();
	}

	@JsonCreator
	public Timesheet( @JsonProperty("id")int timesheetId,  @JsonProperty("uid") int userId,  @JsonProperty("sid")int statusId, @JsonProperty("monday") double monday, @JsonProperty("tuesday") double tuesday, @JsonProperty("wednesday") double wednesday,
			@JsonProperty("thursday") double thursday, @JsonProperty("friday") double friday,@JsonProperty("saturday") double saturday, @JsonProperty("sunday") double sunday, @JsonProperty("weekend") int weekend) {
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
		this.weekend = weekend;
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
	public int getWeekEnd() {
		return weekend;
	}
	public void setWeekEnd(int weekend) {
		this.weekend = weekend;
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
		return "Timesheet [timesheetId=" + timesheetId + ", userId=" + userId + ", statusId=" + statusId + ", monday="
				+ monday + ", tuesday=" + tuesday + ", wednesday=" + wednesday + ", thursday=" + thursday + ", friday="
				+ friday + ", saturday=" + saturday + ", sunday=" + sunday + ", weekend=" + weekend + "]";
	}
	
	
	
	
	
}
