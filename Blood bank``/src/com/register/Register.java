package com.register;



import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bean.Bean;
import com.connect.Connect;
@WebServlet("/Register")
public class Register extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		
		String name=request.getParameter("name");
		String p=request.getParameter("phoneno");
		String em=request.getParameter("email");
		String c=request.getParameter("city");
		String ad=request.getParameter("address");
		String ag=request.getParameter("age");
		String bg=request.getParameter("bloodgroup");
		String pw=request.getParameter("password");
		
		Bean e=new Bean();
		e.setName(name);
		e.setPhoneno(p);
		e.setEmail(em);
		e.setCity(c);
		e.setAddress(ad);
		e.setAge(ag);
		e.setBloodgroup(bg);
		e.setPassword(pw);
		
		
		int status=Connect.save(e);
		if(status>0){
			out.print("<p>Record saved successfully!</p>");
			response.sendRedirect("signin.html");

		}else{
			out.println("Sorry! unable to save record");
		}
		
		out.close();
	}

}
