package com.skillstorm.data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;

import com.skillstorm.beans.Timesheet;
import com.skillstorm.beans.User;

//TimeSheetDAO Interface
public class TimesheetDAO implements TimesheetDAOInterface{
	
	public Connection getConnection() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/punchcarddb", "root", "root");
			return conn;
		} catch (SQLException | ClassNotFoundException e) {
			throw new RuntimeException("Error with Connection to db \n" +e);
		}
	}

	@Override
	public User checkUser(String username, String password) {
		Connection conn = getConnection();
		User user = null;
		try {
			PreparedStatement stmt = conn.prepareStatement("select * from users where u_username=? and u_password=?");
			stmt.setString(1, username);
			stmt.setString(2, password);
			ResultSet results = stmt.executeQuery();
			if(results.next()) {
			user = new User(results.getInt(1), results.getString(2), results.getString(3), results.getString(4), results.getString(5), results.getInt(6), results.getInt(7) );
			}
			
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				throw new RuntimeException(e);
			}
		}
		return user;
	}

	@Override
	public List<Timesheet> findById(int id) {
			Connection conn = getConnection();
			LinkedList<Timesheet> results = new LinkedList<>();
			try {
				PreparedStatement stmt = conn.prepareStatement("select * from timesheets where t_uid = ?");
				stmt.setInt(1, id);
				ResultSet rs = stmt.executeQuery();
				while (rs.next()) {
					Timesheet a = new Timesheet(rs.getInt(1),rs.getInt(2), rs.getInt(3), rs.getDouble(4), rs.getDouble(5), rs.getDouble(6),
							rs.getDouble(7), rs.getDouble(8), rs.getDouble(9), rs.getDouble(10), rs.getLong(11));
					results.add(a);
				}
			} catch (SQLException e) {
				throw new RuntimeException(e);
			} finally {
				try {
					conn.close();
				} catch (SQLException e) {
					throw new RuntimeException(e);
				}
			}
			return results;
	}

	@Override
	public Timesheet addTimesheet(Timesheet t, int id) {
		Connection conn = getConnection();
		try {
			PreparedStatement stmt = conn.prepareStatement("INSERT INTO timesheets(t_uid, t_statusid, t_monday, t_tuesday, t_wednesday, t_thursday, t_friday, t_saturday, t_sunday, t_weekend) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ? , ?)",
					new String[] { "t_id" });
			stmt.setInt(1, id);
			stmt.setInt(2, 1);
			stmt.setDouble(3, t.getMonday());
			stmt.setDouble(4, t.getTuesday());
			stmt.setDouble(5, t.getWednesday());
			stmt.setDouble(6, t.getThursday());
			stmt.setDouble(7, t.getFriday());
			stmt.setDouble(8, t.getSaturday());
			stmt.setDouble(9, t.getSunday());
			stmt.setLong(10, t.getWeekEnd()/1000);
			stmt.executeUpdate();
			ResultSet keys = stmt.getGeneratedKeys();
			while (keys.next()) {
				int t_id = keys.getInt(1);
				t.setTimesheetId(t_id);
			}
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				throw new RuntimeException(e);
			}
		}
		return t;
	}

	@Override
	public void updateTimesheet(Timesheet t, int tid) {
		System.out.println("We got to updateTimesheet DAO");
		Connection conn = getConnection();
		try {
			String sql = "UPDATE timesheets SET t_monday = ?, t_tuesday = ?, t_wednesday = ?, t_thursday = ?, t_friday = ?, t_saturday = ?, t_sunday = ?, t_weekend = ? WHERE t_id = ? ";
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setDouble(1, t.getMonday());
			stmt.setDouble(2, t.getTuesday());
			stmt.setDouble(3, t.getWednesday());
			stmt.setDouble(4, t.getThursday());
			stmt.setDouble(5, t.getFriday());
			stmt.setDouble(6, t.getSaturday());
			stmt.setDouble(7, t.getSunday());
			stmt.setLong(8, t.getWeekEnd());
			stmt.setInt(9, tid);
			stmt.executeUpdate();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				throw new RuntimeException(e);
			}
		}
	}

	public Timesheet findOne(int tid) {
		Connection conn = getConnection();
		Timesheet t;
		try {
			PreparedStatement stmt = conn.prepareStatement("select * from timesheets where t_id = ?");
			stmt.setInt(1, tid);
			ResultSet rs = stmt.executeQuery();
			rs.next();
			 t = new Timesheet(rs.getInt(1),rs.getInt(2), rs.getInt(3), rs.getDouble(4), rs.getDouble(5), rs.getDouble(6),
						rs.getDouble(7), rs.getDouble(8), rs.getDouble(9), rs.getDouble(10), rs.getLong(11));		
			 System.out.println("This is timesheet from constructor in find one: " + t);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				throw new RuntimeException(e);
			}
		}
		return t;
	}

	public void deleteTimesheet(int tid) {
		System.out.println("We got to deleteTimesheet DAO: " + tid);

		Connection conn = getConnection(); 
		try { String sql ="DELETE from timesheets WHERE t_id = ? "; 
		PreparedStatement stmt = conn.prepareStatement(sql); stmt.setInt(1, tid); stmt.executeUpdate(); }
		catch (SQLException e) 
		{ throw new RuntimeException(e); }
		finally { 
			try {
			conn.close(); 
			} catch (SQLException e) { 
				throw new RuntimeException(e); 
				} 
			}
		 
		
	}
	

}
