package com.userManagement.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.userManagement.dao.UserDao;
import com.userManagement.model.*;

@WebServlet(name="FrontController",urlPatterns="/")
public class FrontController extends HttpServlet {
	
	
	private UserDao dao;
	public void init() {
		dao=new UserDao();	
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		String action=request.getServletPath();
		System.out.println(action);
		try {
			switch(action) {
			case "/new":
				newForm(request,response);
				
				break;
			case "/delete":
				deleteUser(request,response);
				break;
			case "/insert":
				insertUser(request,response);
				break;
			case "/edit":
				showEditForm(request,response);
				break;
			case "/update":
				updateUser(request,response);
				break;
			case "/login":	
				logincheck(request,response);
					break;
			case "/list":
				listUser(request,response);
				break;
				
			case "/logout":
				logoutHandle(request,response);
				break;
				
				default:
					firstIncomingHandle(request,response);
				break;
			
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		/*RequestDispatcher dispatcher=request.getRequestDispatcher("/WEB-INF/UserList.jsp");
		dispatcher.forward(request,response);*/
	}
	
	private void logoutHandle(HttpServletRequest request,HttpServletResponse response) throws IOException {
		HttpSession session=request.getSession();
		session.invalidate();
		PrintWriter out=response.getWriter();
		out.println("You are sucessfully logged out!");
		out.println("<a href='login'>Login</a>");
		//response.sendRedirect("WEB-INF/Login.jsp");
		
	}
	private  void newForm(HttpServletRequest request,HttpServletResponse response) throws SQLException,ServletException,IOException {
		try {
			RequestDispatcher dispatcher=request.getRequestDispatcher("WEB-INF/UserForm.jsp");
			dispatcher.forward(request, response);
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	private void logincheck(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session=request.getSession(false);
		if(session==null) {
			//System.out.println("*****"+session+"****");
			RequestDispatcher dispatcher=request.getRequestDispatcher("WEB-INF/Login.jsp");
			dispatcher.forward(request, response);
			//response.sendRedirect("WEB-INF/Login.jsp");
		}
		else {
		List<User> users=new ArrayList<User>();
		users=dao.selectAllUser();
		//User user1=null;
		boolean count=true;
		//HttpSession session =request.getSession();
		session.setAttribute("name", request.getParameter("username"));
		PrintWriter out=response.getWriter();
		for(User user:users) {
			if(user.getName().equalsIgnoreCase(request.getParameter("username"))) {
				String username=request.getParameter("username");
				request.setAttribute("user",username);
				request.setAttribute("usersList", users);
				RequestDispatcher dispatcher=request.getRequestDispatcher("WEB-INF/UserList.jsp");
				dispatcher.forward(request, response);
			}
			else {
				
				while(count) {
				out.println("<html>");
				out.println("<body>");
				out.println("<h1>Login Failed!</h1>");
				out.println("</body>");
				out.println("</html>");
				count=false;
				}
			}}
		}
	}
	private void firstIncomingHandle(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
		//response.sendRedirect("WEB-INF/Login.jsp");
		RequestDispatcher dispatcher=request.getRequestDispatcher("WEB-INF/Login.jsp");
		dispatcher.forward(request, response);
		
	}
private void listUser(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
	HttpSession session=request.getSession(false);
	if(session!=null) {
	List<User> users=new ArrayList<User>();
	users=dao.selectAllUser();
	request.setAttribute("usersList", users);
	RequestDispatcher dispatcher=request.getRequestDispatcher("WEB-INF/UserList.jsp");
	dispatcher.forward(request, response);
	}
	else {
		response.sendRedirect("WEB-INF/Login.jsp");
	}
}

private void showEditForm(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
	int id=Integer.parseInt(request.getParameter("id"));
	User existingUser=dao.selectUser(id);
	RequestDispatcher dispatcher=request.getRequestDispatcher("WEB-INF/EditForm.jsp");
	request.setAttribute("user",existingUser);
	dispatcher.forward(request, response);
	
}

private void insertUser(HttpServletRequest request, HttpServletResponse response)throws SQLException,IOException{
	int id=Integer.parseInt(request.getParameter("id"));
	String name=request.getParameter("name");
	String address=request.getParameter("address");
	int age=Integer.parseInt(request.getParameter("age"));
	String email=request.getParameter("email");
	dao.insertUser(new User(id,name,address,age,email));
	response.sendRedirect("list");
}

private void deleteUser(HttpServletRequest request, HttpServletResponse response) throws IOException {
	int id=Integer.parseInt(request.getParameter("id"));
	System.out.println(id);
	//request.setAttribute("id",id);
	dao.deleteUser(id);
	response.sendRedirect("list");
	
}
	private void updateUser(HttpServletRequest request, HttpServletResponse response) throws IOException {
		//RequestDispatcher dispatcher=request.getRequestDispatcher("WEB-INF/UserForm.jsp");
		int id=Integer.parseInt(request.getParameter("id"));
		String name=request.getParameter("name");
		String address=request.getParameter("address");
		int age=Integer.parseInt(request.getParameter("age"));
		String email=request.getParameter("email");
		dao.updateUser(new User(id,name,address,age,email));
		response.sendRedirect("list");
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
