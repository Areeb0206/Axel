package com.connect;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bean.Bean;



import java.util.*;




import java.sql.*;

public class Connect {

	public static Connection getConnection(){
		Connection con=null;
		try{
			Class.forName("com.mysql.cj.jdbc.Driver");
			 con = DriverManager.getConnection("jdbc:mysql://localhost:3306/claret","root","");
			 
}
		catch(Exception e){System.out.println(e);}
		return con;
	}
	public static int save(Bean e){
		int status=0;
		try{
			Connection con=Connect.getConnection();
			PreparedStatement ps=con.prepareStatement("insert into claret(name,phoneno,email,city,address,age,bloodgroup,password) values (?,?,?,?,?,?,?,?)");
			
			ps.setString(1,e.getName());
			ps.setString(2,e.getPhoneno());
			ps.setString(3,e.getEmail());
			ps.setString(4,e.getCity());
			ps.setString(5,e.getAddress());
			ps.setString(6,e.getAge());
			ps.setString(7,e.getBloodgroup());
			ps.setString(8,e.getPassword());	
			
			status=ps.executeUpdate();
			
			con.close();
		}catch(Exception ex){ex.printStackTrace();}
		
		return status;
	}
}