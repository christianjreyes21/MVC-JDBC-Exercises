package bpi.forex.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bpi.forex.model.ForexBean;
import bpi.forex.utility.Factory;


@WebServlet("/processconversion.do")
public class ConversionForexServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//step 2 - servlet reads request parameters, check for missing or malforrmed
		double phpAmount = Double.parseDouble(request.getParameter("phpAmount"));
		String currencyType = request.getParameter("currencyType");
		
		//step 3 - populate the beans
		ForexBean forex = Factory.getInstance(phpAmount, currencyType);
		
		//step 4 - store the bean in request (or session or servletcontext)
		request.setAttribute("forexObj", forex);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("displayvalues.jsp");
		dispatcher.forward(request, response);
	}

}
