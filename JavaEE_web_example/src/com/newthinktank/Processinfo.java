package com.newthinktank;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.sql.*;

/**
 * Servlet implementation class Processinfo
 */
@WebServlet("/Processinfo")
public class Processinfo extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Processinfo() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String url = "/DisplayInfo.jsp";
		String fName = request.getParameter("fname");
		String lName = request.getParameter("lname");
		String phone = request.getParameter("phone");
		
		updateDB(fName, lName, phone);
		Customer cust = new Customer(fName, lName, phone);
		
		request.setAttribute("cust", cust);
		//request.setAttribute("usersName", usersName);
		getServletContext().getRequestDispatcher(url).forward(request, response);
	}
	
	protected void updateDB(String fName, String lName, String phone) {
		Connection con;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			String url = "jdbc:mysql://localhost/test1";
			String user = "test_user1";
			String pw = "test_user1";
			
			con = DriverManager.getConnection(url, user, pw);
//			Statement s = con.createStatement();
//			String query = "INSERT INTO customer (first_name, last_name, phone, cust_id) "
//					+ "VALUES ('" + fName + "', '" + lName + "', '" + phone + "', NULL)";
			
			//executeUpdate execute sql statement that insert/update/delete data
			//executeQuery execute statement that returns a result set by fetching data from database
			//s.executeUpdate(query);
			String query = "INSERT INTO customer (first_name, last_name, phone, cust_id) VALUES (?, ?, ?, NULL)";
			PreparedStatement pr = con.prepareStatement(query);
			pr.setString(1, fName);
			pr.setString(2, lName);
			pr.setString(3, phone);
			pr.execute();
			con.close();
		}
		catch(ClassNotFoundException e) {
			e.printStackTrace();
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
	}

}
