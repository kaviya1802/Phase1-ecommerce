package com.ecommerce.servlet;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.Properties;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ecommerce.jdbc.DBConnection;

/**
 * Servlet implementation class TestJDBC
 */
@WebServlet("/TestJDBC")
public class TestJDBC extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TestJDBC() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//Initialize JDBC Connection
		try {
			PrintWriter out = response.getWriter();
			
			//load data from config. properties
			InputStream in = getServletContext().getResourceAsStream("/config.properties");
			Properties properties = new Properties();
			properties.load(in);
			
			//fetch properties
			String url = properties.getProperty("url");
			String username = properties.getProperty("username");
			String password = properties.getProperty("password");
			
			//create connection
			DBConnection conn = new DBConnection(url, username, password);
			
			//Print response
			out.println("<html><body>");
			out.println("<h1>DB Connection is Initialized!!</h1>");
			out.println("</body></html>");
			
			//close connection
			
			conn.closeConnection();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
