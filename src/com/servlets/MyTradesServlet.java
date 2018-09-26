package com.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.LoginDao;
import com.dao.impl.LoginDaoImpl;

/**
 * Servlet implementation class MyTradesServlet
 */
@WebServlet("/mytrades")
public class MyTradesServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MyTradesServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String email =(String) request.getAttribute("uname");
		
		response.setContentType("text/html");
		PrintWriter writer = response.getWriter();
		OrderDao dao = new OrderDaoImpl();
		//System.out.println("5");
		List<Order> Orderlist=dao.gettradesofclient(email);
			request.setAttribute("orders", Orderlist);
			RequestDispatcher dispatcher = request.getRequestDispatcher("MyTrades.jsp");
			dispatcher.forward(request,response);

		} 
		
	}

