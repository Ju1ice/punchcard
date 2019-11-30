package com.skillstorm.beans;

public class User {
	
	private int userId = 0;
	private String userFN = "";
	private String userLN = "";
	private int userRoleId = 0;
	private String username = "";
	private int jobId = 0;
	private String password = "";
	
	public User(int userId, String userFN, String userLN, String username, String password, int userRoleId, int jobId) {
		super();
		this.userId = userId;
		this.userFN = userFN;
		this.userLN = userLN;
		this.userRoleId = userRoleId;
		this.username = username;
		this.jobId = jobId;
		this.password = password;
	}
	
	

	public String getUsername() {
		return username;
	}



	public void setUsername(String username) {
		this.username = username;
	}



	public User() {
		// TODO Auto-generated constructor stub
	}



	public int getUserId() {
		return userId;
	}



	public void setUserId(int userId) {
		this.userId = userId;
	}



	public String getUserFN() {
		return userFN;
	}



	public void setUserFN(String userFN) {
		this.userFN = userFN;
	}



	public String getUserLN() {
		return userLN;
	}



	public void setUserLN(String userLN) {
		this.userLN = userLN;
	}



	public int getUserRoleId() {
		return userRoleId;
	}



	public void setUserRoleId(int userRoleId) {
		this.userRoleId = userRoleId;
	}



	public int getJobId() {
		return jobId;
	}



	public void setJobId(int jobId) {
		this.jobId = jobId;
	}



	public String getPassword() {
		return password;
	}



	public void setPassword(String password) {
		this.password = password;
	}



	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + jobId;
		result = prime * result + ((password == null) ? 0 : password.hashCode());
		result = prime * result + ((userFN == null) ? 0 : userFN.hashCode());
		result = prime * result + userId;
		result = prime * result + ((userLN == null) ? 0 : userLN.hashCode());
		result = prime * result + userRoleId;
		result = prime * result + ((username == null) ? 0 : username.hashCode());
		return result;
	}



	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		if (jobId != other.jobId)
			return false;
		if (password == null) {
			if (other.password != null)
				return false;
		} else if (!password.equals(other.password))
			return false;
		if (userFN == null) {
			if (other.userFN != null)
				return false;
		} else if (!userFN.equals(other.userFN))
			return false;
		if (userId != other.userId)
			return false;
		if (userLN == null) {
			if (other.userLN != null)
				return false;
		} else if (!userLN.equals(other.userLN))
			return false;
		if (userRoleId != other.userRoleId)
			return false;
		if (username == null) {
			if (other.username != null)
				return false;
		} else if (!username.equals(other.username))
			return false;
		return true;
	}



	@Override
	public String toString() {
		return "User [userId=" + userId + ", userFN=" + userFN + ", userLN=" + userLN + ", userRoleId=" + userRoleId
				+ ", username=" + username + ", jobId=" + jobId + ", password=" + password + "]";
	}
	
	

	

}
