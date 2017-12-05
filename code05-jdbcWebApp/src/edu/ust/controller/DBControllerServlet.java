package edu.ust.controller;

import java.io.IOException;

import javax.annotation.PostConstruct;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.ust.helper.DBUtility;
import edu.ust.model.DBConfigurationBean;

import java.sql.*;

@WebServlet("/index.html")
public class DBControllerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private Connection connection;
	private DBConfigurationBean connectionBean;
	@PostConstruct
	public void performDBAdminTasks() {
		DBUtility utility = new DBUtility();
		utility.createXMLDatabaseConfiguration();
		connectionBean = utility.getConnectionBean();
		
		if (connectionBean != null) {
			System.out.println("not null");
		} else {
			System.err.println("NULL");
		}
				
	}
	
	public void init(ServletConfig config) throws ServletException {
		try {	
			Class.forName(connectionBean.getDriver());
			
			String url = connectionBean.getJdbcPartURL()+connectionBean.getServer()+":"+connectionBean.getPort()+"/"+connectionBean.getDatabase(); 
			
			connection = 
			  DriverManager.getConnection(url,connectionBean.getUserName(), connectionBean.getPassword());
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
