package com.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class StudentDAO {

	public Connection getConnection() {
		Connection connection = null;
		String URL = "jdbc:mysql://localhost:3306/results";
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection = DriverManager.getConnection(URL,"root","root");
		}catch(ClassNotFoundException e) {
			e.printStackTrace();
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return connection;
	}
	
	public int insertStudent(StudentDTO student) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		int result = 0;
		String INSERT = "Insert into studentdetails values (?,?)";
		connection = getConnection();
		try {
			preparedStatement = connection.prepareStatement(INSERT);
			preparedStatement.setString(1,student.getRegNumber());
			preparedStatement.setString(2,student.getEmailId());
			
			result = preparedStatement.executeUpdate();
			return result;
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
//		finally {
//			try {
//				if(connection != null) {
//					connection.close();
//					preparedStatement.close();
//				}
//			}catch(SQLException e) {
//				e.printStackTrace();
//			}
//		}
		return 0;
	}

	public int insertStudentMarks(StudentMarkDTO studentmark) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		int result = 0;
		String INSERT = "Insert into studentmarks values (?,?,?,?,?,?,?)";
		connection = getConnection();
		try {
			preparedStatement = connection.prepareStatement(INSERT);
			preparedStatement.setString(1,studentmark.getRegNumber());
			preparedStatement.setInt(2,studentmark.getDwdm());
			preparedStatement.setInt(3,studentmark.getInfosec());
			preparedStatement.setInt(4,studentmark.getWt());
			preparedStatement.setInt(5,studentmark.getCc());
			preparedStatement.setInt(6,studentmark.getAjp());
			preparedStatement.setInt(7,studentmark.getEcom());
			
			result = preparedStatement.executeUpdate();
			return result;
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}
}
