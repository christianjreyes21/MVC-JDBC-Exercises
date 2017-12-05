package edu.ust.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.sql.*;

@WebServlet("/index.html")
public class DBControllerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private Connection connection;
	
	public void init(ServletConfig config) throws ServletException {
		try {	
			Class.forName("net.sourceforge.jtds.jdbc.Driver");
			String username = "admin";
			String password = "1234";
			String url = 
			  "jdbc:jtds:sqlserver://localhost:1433/CJ_DATABASE"; 
			
			connection = 
			  DriverManager.getConnection(url,username,password);
		} catch (SQLException sqle){
			System.out.println("SQLException error occured - " 
				+ sqle.getMessage());
		} catch (ClassNotFoundException nfe){
			System.out.println("ClassNotFoundException error occured - " 
		        + nfe.getMessage());
		}	
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {	
			if (connection != null) {
				Statement stmt = connection.createStatement();
				ResultSet rs = stmt.executeQuery("select * from Student");	
				System.out.println("Successful connection");
				
				request.setAttribute("talaan", rs);
				
				RequestDispatcher dispatcher = 
					request.getRequestDispatcher("displayrecords.jsp");
				dispatcher.forward(request, response);
			} else {
				response.sendRedirect("error.jsp");
			}
		} catch (SQLException sqle){
			sqle.printStackTrace();
			response.sendRedirect("error.jsp");
		}	
	}
}
