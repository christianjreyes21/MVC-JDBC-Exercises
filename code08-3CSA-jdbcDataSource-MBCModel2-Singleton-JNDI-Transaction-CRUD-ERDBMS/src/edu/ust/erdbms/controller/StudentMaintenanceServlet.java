package edu.ust.erdbms.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.ust.erdbms.model.StudentBean;
import edu.ust.erdbms.utility.sql.SQLOperations;

import java.sql.*;

@WebServlet("/studentmaintenance.html")
public class StudentMaintenanceServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private Connection connection;
	
	public void init() throws ServletException {
		connection = (Connection) 
			getServletContext().getAttribute("dbConnection");
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			RequestDispatcher dispatcher = null; 
			if (request.getParameter("action").equals("edit")) {
				int id = Integer.parseInt(request.getParameter("id"));
				StudentBean student  = 
				  SQLOperations.searchStudent(id, connection);
				request.setAttribute("studentRec", student);
				dispatcher = 
				 getServletContext().getRequestDispatcher("/editstudent.jsp?id="+id);
			} else if (request.getParameter("action").equals("delete")){
				int id = Integer.parseInt(request.getParameter("id"));
				
				SQLOperations.deleteStudent(id, connection);
				ResultSet rs = 
						  SQLOperations.getAllStudents(connection);
				request.setAttribute("recordStudents", rs);
				dispatcher = 
				 getServletContext().getRequestDispatcher("/liststudents.jsp");	
			}
			dispatcher.forward(request, response);		
		} catch (Exception e) {
			System.err.println("Exception e - " + e.getMessage());
			e.printStackTrace();
		} 
	}

}
