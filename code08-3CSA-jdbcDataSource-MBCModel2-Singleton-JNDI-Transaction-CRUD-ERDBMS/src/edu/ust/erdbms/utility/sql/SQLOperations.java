package edu.ust.erdbms.utility.sql;

import java.sql.*;
import javax.sql.*;

import javax.naming.InitialContext;
import javax.naming.NamingException;

import edu.ust.erdbms.utility.sql.SQLCommands;
import edu.ust.erdbms.model.StudentBean;

public class SQLOperations implements SQLCommands {

	private static Connection connection;
	
	private SQLOperations() {
	}
	
	private static Connection getDBConnection() {
		try {
		    InitialContext context = new InitialContext();
		    DataSource dataSource = (DataSource) 
		     context.lookup("java:comp/env/jdbc/UST-3CSA-DS");
		    
		    if (dataSource != null) {
		    	connection = dataSource.getConnection();
		    } else {
		    	System.err.println("DataSource is NULL.");
		    }
		} catch (NamingException e) {
		    e.printStackTrace();
		} catch (SQLException e) {
		    e.printStackTrace();
		}
		return connection;
	 }
	
	public static Connection getConnection() {
		return (connection!=null)?connection:getDBConnection();
	}
	
	public static boolean addStudent(StudentBean student, 
		Connection connection) {
		
		try {
	        PreparedStatement pstmt = connection.prepareStatement(INSERT_STUDENT);
	        pstmt.setString(1, student.getID());
	        pstmt.setString(2, student.getLastName()); 
	        pstmt.setString(3, student.getFirstName());
	        pstmt.setString(4, student.getYearLevel());
	        pstmt.setString(5, student.getCourse());            
	        pstmt.executeUpdate(); // execute insert statement  
		} catch (SQLException sqle) {
			System.out.println("SQLException - addStudent: " + sqle.getMessage());
			return false; 
		}	
		return true;
	}
	
	public static StudentBean searchStudent(int id, 
		Connection connection) {
		StudentBean student = new StudentBean();
		 
		try {
	        PreparedStatement pstmt = 
	        	connection.prepareStatement(SEARCH_STUDENT);
	        pstmt.setInt(1, id);             
	        ResultSet rs  = pstmt.executeQuery();
	        
	        while (rs.next()) { 
	        	student.setID(rs.getString("ID"));
	        	student.setLastName(rs.getString("LASTNAME"));
	        	student.setFirstName(rs.getString("FIRSTNAME"));
	        	student.setYearLevel(rs.getString("YEARLEVEL"));
	        	student.setCourse(rs.getString("COURSE"));
	        }
		} catch (SQLException sqle) {
			System.out.println("SQLException - searchStudent: " 
					+ sqle.getMessage());
			return student; 
		}	
		return student;
	}
	
	public static ResultSet getAllStudents(Connection connection) {
		ResultSet rs = null;
		try {
			Statement stmt = connection.createStatement();
			rs = stmt.executeQuery(GET_ALL_STUDENTS);  
		} catch (SQLException sqle) {
			System.out.println("SQLException - getALLStudents: " 
			  + sqle.getMessage());
			return rs; 
		}	
		return rs;
	}
	
	public static int updateStudent(StudentBean student, 
		int id, Connection connection) {
		int updated = 0;
		try {
			connection.setAutoCommit(false);
	        PreparedStatement pstmt = 
	        	connection.prepareStatement(UPDATE_STUDENT);
	        pstmt.setString(2, student.getLastName()); 
	        pstmt.setString(3, student.getFirstName());
	        pstmt.setString(4, student.getYearLevel());
	        pstmt.setString(5, student.getCourse()); 
	        pstmt.setInt(1, id); 
	        updated = pstmt.executeUpdate();   
	        connection.commit();
		} catch (SQLException sqle) {
			System.out.println("SQLException - updateStudent: " 
				+ sqle.getMessage());
			
			try {
				connection.rollback();
			} catch (SQLException sql) {
				System.err.println("Error on Update Connection Rollback - " 
					+ sql.getMessage());
			}
			return updated; 
		}	
		return updated;
	}
	
	public static synchronized int deleteStudent(int id, Connection connection) {
		int updated = 0;
		
		try {
			connection.setAutoCommit(false);
	        PreparedStatement pstmt = connection.prepareStatement(DELETE_STUDENT);
	        pstmt.setInt(1, id);             
	        updated  = pstmt.executeUpdate();
	        connection.commit();
		} catch (SQLException sqle) {
			System.out.println("SQLException - deleteStudent: " + sqle.getMessage());
			
			try {
				connection.rollback();
			} catch (SQLException sql) {
				System.err.println("Error on Delete Connection Rollback - " + sql.getMessage());
			}
			return updated; 
		}	
		return updated;
	}
}
