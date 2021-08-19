package com.web;

import java.security.Security;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
//
//import com.model.StudentDAO;
//import com.model.StudentDTO;
//import com.model.StudentMarkDTO;

import com.model.StudentMarkDTO;



public class App 
{
	
	public static Connection getConnection() {
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
	
public static List<StudentMarkDTO> fetchEmailId() {
		
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		connection = getConnection();
		List<StudentMarkDTO> studentlist = new ArrayList<StudentMarkDTO>();
		String SELECT = "select * from studentmarks natural join studentdetails";
		
		try {
			preparedStatement = connection.prepareStatement(SELECT);
			resultSet = preparedStatement.executeQuery();
			
			while(resultSet.next()) {
				
				StudentMarkDTO studentmarkdto = new StudentMarkDTO();
				studentmarkdto.setRegNumber(resultSet.getString(1));
				studentmarkdto.setDwdm(resultSet.getInt(2));
				studentmarkdto.setInfosec(resultSet.getInt(3));
				studentmarkdto.setWt(resultSet.getInt(4));
				studentmarkdto.setCc(resultSet.getInt(5));
				studentmarkdto.setAjp(resultSet.getInt(6));
				studentmarkdto.setEcom(resultSet.getInt(7));
				studentmarkdto.setEmailId(resultSet.getString(8));

				studentlist.add(studentmarkdto);
			}
			return studentlist;
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return studentlist;
	}
	
    public static void main( String[] args )
    {
    	System.out.println("Preparing to send");
    	List<StudentMarkDTO> studentmarklist = new ArrayList<StudentMarkDTO>();
    	studentmarklist = fetchEmailId();
    	String subject = "III B.TECH II SEM (R18) REGULAR CONSOLIDATED RESULTS AUGUST-2021";
    	
    	String from = "hemavarshini5f4@gmail.com";
    	System.out.println(studentmarklist.size());
    	
    	for(int i = 0;i < studentmarklist.size();i++) {
    	
    		String message = "DWDM : ";
    		
    		String to = studentmarklist.get(i).getEmailId();
    		System.out.println(to);
    		
    		message += studentmarklist.get(i).getDwdm();
    		message += "\nIS : ";
    		message += studentmarklist.get(i).getInfosec();
    		message += "\nWT : ";
    		message += studentmarklist.get(i).getWt();
    		message += "\nCC : ";
    		message += studentmarklist.get(i).getCc();
    		message += "\nAJP : ";
    		message += studentmarklist.get(i).getAjp();
    		message += "\nECOM : ";
    		message += studentmarklist.get(i).getEcom();
    		
    		sendEmail(message,subject,to,from);
    	}
    
    }
    
//    Used to send email...
	private static void sendEmail(String message, String subject, String to, String from) {
		
//		gmail variable
		String host="smtp.gmail.com"; 
		
		Properties properties = System.getProperties();
		System.out.println("PROPERTIES "+properties);
		
		properties.put("mail.smtp.host", host);
		properties.put("mail.smtp.port", "465");
		properties.put("mail.smtp.ssl.enable", "true");
		properties.put("mail.smtp.auth", "true");
	
//		1. get session object
		Session session = Session.getInstance(properties, new Authenticator() {

			@Override
			protected PasswordAuthentication getPasswordAuthentication() {
				// TODO Auto-generated method stub
				return new PasswordAuthentication("hemavarshini5f4@gmail.com","*******");
			}
			
		});
		
		//session.setDebug(true);
		
//		2.compose message(text,multimedia)
		
		MimeMessage mimeMessage = new MimeMessage(session);
		try {
			
			mimeMessage.setFrom(from);
			mimeMessage.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
			mimeMessage.setSubject(subject);
			mimeMessage.setText(message);
			session.setDebug(true);
			Transport.send(mimeMessage);
			System.out.println("sent successfully...");
		
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}
