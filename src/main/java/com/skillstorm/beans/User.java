package com.skillstorm.beans;

public class User {
	
	private int userId;
	private String userFN;
	private String userLN;
	private String userRoleId;
	private String jobId;
	private String password;
	
	public User(int userId, String userFN, String userLN, String userRoleId, String jobId, String password) {
		super();
		this.userId = userId;
		this.userFN = userFN;
		this.userLN = userLN;
		this.userRoleId = userRoleId;
		this.jobId = jobId;
		this.password = password;
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



	public String getUserRoleId() {
		return userRoleId;
	}



	public void setUserRoleId(String userRoleId) {
		this.userRoleId = userRoleId;
	}



	public String getJobId() {
		return jobId;
	}



	public void setJobId(String jobId) {
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
		result = prime * result + ((jobId == null) ? 0 : jobId.hashCode());
		result = prime * result + ((password == null) ? 0 : password.hashCode());
		result = prime * result + ((userFN == null) ? 0 : userFN.hashCode());
		result = prime * result + userId;
		result = prime * result + ((userLN == null) ? 0 : userLN.hashCode());
		result = prime * result + ((userRoleId == null) ? 0 : userRoleId.hashCode());
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
		if (jobId == null) {
			if (other.jobId != null)
				return false;
		} else if (!jobId.equals(other.jobId))
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
		if (userRoleId == null) {
			if (other.userRoleId != null)
				return false;
		} else if (!userRoleId.equals(other.userRoleId))
			return false;
		return true;
	}



	@Override
	public String toString() {
		return "User [userId=" + userId + ", userFN=" + userFN + ", userLN=" + userLN + ", userRoleId=" + userRoleId
				+ ", jobId=" + jobId + ", password=" + password + "]";
	}
	
	

	

}
