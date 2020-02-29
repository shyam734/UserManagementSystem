
package com.userManagement.dao;



import com.userManagement.model.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.userManagement.model.User;



public class UserDao {
	
	private String jdbcUrl="jdbc:h2:tcp://localhost/~/userManagement";
	private String username="user";
	private String password="user";
	
	private static final String insertIntoUsers="insert into users"+"(name,address,age,email)values"+"(?,?,?,?);";
	private static final String selectUserById="select * from users where id=?";
	private static final String deleteUser="delete from users where id=?";
	private static final String updateUser="update users set id=?,name=?,address=?,age=?,email=?  where id=?";
	private static final String selectAllUsers="select * from users";
	
	protected Connection getConnection() {
		Connection con=null;
		try {
			Class.forName("org.h2.Driver");
			System.out.println("connecting database");
			con=DriverManager.getConnection(jdbcUrl,username,password);
			System.out.println("Database Connected.");
		} catch (Exception e1) {
		
			e1.printStackTrace();
		}
		
		return con;
	}
	
	public void insertUser(User user) {
		try{
			Class.forName("org.h2.Driver");
			Connection con=DriverManager.getConnection("jdbc:h2:tcp://localhost/~/userManagement","user","user");
				PreparedStatement pst=con.prepareStatement("insert into users values(?,?,?,?,?)");
				pst.setInt(1,user.getId());
			pst.setString(2, user.getName()+"");
			pst.setString(3, user.getAddress()+"");
			pst.setInt(4, user.getAge());
			pst.setString(5, user.getEmail()+"");
			pst.executeUpdate();
			pst.close();
			con.close();
			
		}
		catch(Exception e) {
			
		}
	}
	public User selectUser(int id) {
		User user=null;
		try{Class.forName("org.h2.Driver");
		Connection con=DriverManager.getConnection("jdbc:h2:tcp://localhost/~/userManagement","user","user");
		PreparedStatement pst=con.prepareStatement("select * from users where id=?");
			pst.setInt(1,id);
			ResultSet rs=pst.executeQuery();
			while(rs.next()) {
				String name=rs.getString("name");
				String address=rs.getString("address");
				int age=rs.getInt("age");
				String email=rs.getString("email");
				
			user=new User(id,name,address,age,email);
			}
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return user;
	}
	
	public List<User> selectAllUser(){
		 System.out.println("Inside selectAllUser()");
		List <User> users=new ArrayList<> ();
		try{Class.forName("org.h2.Driver");
			Connection con=DriverManager.getConnection("jdbc:h2:tcp://localhost/~/userManagement","user","user");
				PreparedStatement pst=con.prepareStatement(selectAllUsers);
			ResultSet rs=pst.executeQuery();
			while(rs.next()) {
				int id=rs.getInt("id");
				String name=rs.getString("name");
				String address=rs.getString("address");
				int age=rs.getInt("age");
				String email=rs.getString("email");
				users.add(new User(id,name,address,age,email));
				System.out.println(id+"  "+name+"  "+address+"  "+age+"  "+email);
			}
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return users;
	}
	
	
	public boolean deleteUser(int id) {
		boolean rowDeleted=false;
		try{
			Class.forName("org.h2.Driver");
			Connection con=DriverManager.getConnection("jdbc:h2:tcp://localhost/~/userManagement","user","user");
				PreparedStatement pst=con.prepareStatement("delete from users where id=?");
			pst.setInt(1, id);
			rowDeleted=pst.executeUpdate()>0;
			System.out.println("inside delete method after query injection");
			pst.close();
			con.close();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return rowDeleted;
	}
	
	public boolean updateUser(User user) {
	boolean rowUpdated=false;
	try{
		Class.forName("org.h2.Driver");
		Connection con=DriverManager.getConnection("jdbc:h2:tcp://localhost/~/userManagement","user","user");
				PreparedStatement pst=con.prepareStatement("update users set name=?,address=?,age=?,email=?  where id=?");
				//pst.setInt(1,user.getId());
				pst.setString(1,user.getName());
			pst.setString(2, user.getAddress());
			pst.setInt(3, user.getAge());
			pst.setString(4, user.getEmail());
			pst.setInt(5,user.getId());
			rowUpdated=pst.executeUpdate()>0;
		}
		catch(Exception e ) {
			e.printStackTrace();
		}
		return rowUpdated;
	}
	
}
