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

/**
 * Servlet implementation class ShowAllOrdersServlet
 */
@WebServlet("/ShowOrderBook")
public class ShowAllOrdersServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShowAllOrdersServlet() {
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
		OrderDAO dao = new OrderDAOImpl();
		//System.out.println("5");
		List<Order> AllOrders=dao.findAllOrders(email);
			request.setAttribute("orders", AllOrders);
			RequestDispatcher dispatcher = request.getRequestDispatcher("ShowOrderBook.jsp");
			dispatcher.forward(request,response);

	}

}
