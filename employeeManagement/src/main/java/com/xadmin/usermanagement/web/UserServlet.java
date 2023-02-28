package com.xadmin.usermanagement.web;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.xadmin.usermanagement.bean.User;
import com.xadmin.usermanagement.dao.UserDao;

/**
 * Servlet implementation class UserServlet
 */
@WebServlet("/")
public class UserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       private UserDao userDao;
   

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init() throws ServletException {
		userDao = new UserDao();
	}

	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String action = request.getServletPath();

		try {
			switch (action) {
			case "/new":
				showNewForm(request, response);
				break;
			case "/insert":
				insertUser(request, response);
				break;
			case "/delete":
				deleteUser(request, response);
				break;
			case "/edit":
				showEditForm(request, response);
				break;
			case "/update":
				updateUser(request, response);
				break;
			default:
				listUser(request, response);
				break;
			}
		} catch (SQLException ex) {
			throw new ServletException(ex);
		}
		
	}
	
	
	
	//default
	
	private void listUser(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException, ServletException {
		// TODO Auto-generated method stub

		List<User> listUser = userDao.selectAllUsers();
		request.setAttribute("listUser", listUser);
		RequestDispatcher dispatcher = request.getRequestDispatcher("user-list.jsp");
		dispatcher.forward(request, response);
	}


	//update
	
	private void updateUser(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
		// TODO Auto-generated method stub
		int id = Integer.parseInt(request.getParameter("id"));
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String NIC = request.getParameter("NIC");
		String department = request.getParameter("department");
		String designation = request.getParameter("designation");
		String joinedDate = request.getParameter("joinedDate");
		User book = new User(id, name, email, NIC, department, designation, joinedDate);
		userDao.updateUser(book);
		response.sendRedirect("list");
	}

	
	
	
	

	//edit
	private void showEditForm(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
		// TODO Auto-generated method stub
		int id = Integer.parseInt(request.getParameter("id"));
		User existingUser = userDao.selectUser(id);
		RequestDispatcher dispatcher = request.getRequestDispatcher("user-form.jsp");
		request.setAttribute("user", existingUser);
		dispatcher.forward(request, response);
	}
	
	
	
	
	


	//delete

private void deleteUser(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException  {
		// TODO Auto-generated method stub
	
		int id = Integer.parseInt(request.getParameter("id"));
		userDao.deleteUser(id);
		response.sendRedirect("list");

	}






	//INSERT
	private void insertUser(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException{
		// TODO Auto-generated method stub
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String NIC = request.getParameter("NIC");
		String department = request.getParameter("department");
		String designation = request.getParameter("designation");
		String joinedDate = request.getParameter("joinedDate");
		User newUser = new User(name, email, NIC, department, designation, joinedDate);
		userDao.insertUser(newUser);
		response.sendRedirect("list");
	}
	
	
	
	
	

//SHOW NEW FORM 
	private void showNewForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
				RequestDispatcher dispatcher = request.getRequestDispatcher("user-form.jsp");
				dispatcher.forward(request, response);
	}

	
}
