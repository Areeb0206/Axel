package com.donor;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/DonorS")
public class DonorS extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
 

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.print("<html>");
		out.print("<head>");
      	out.print("   <link type='text/css' rel='stylesheet' href='main.css'  media='screen,projection'/>");
      	out.print("  <script src='https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js'></script>");

         
    
      		out.print(" <link rel='stylesheet' href='https://cdnjs.cloudflare.com/ajax/libs/materialize/0.97.6/css/materialize.min.css'>");

 
      	out.print("<script src='https://cdnjs.cloudflare.com/ajax/libs/materialize/0.97.6/js/materialize.min.js'></script>");
          out.print("  <script type='text/javascript'>	              $(document).ready(function(){	                 $('.button-collapse').sideNav();	                 $('.collapsible').collapsible();	              });");
              out.print("   </script>");
          out.print("    </head>");
      out.print("   <body >");
      out.print(" <div class=\"black\">\r\n" + 
      		"  <a href=\"#\" data-activates=\"slide-out\" class=\"button-collapse\">\r\n" + 
      		"   <div class=\"connn\"> CLARET</div></a>\r\n" + 
      		"    \r\n" + 
      		"\r\n" + 
      		"    <ul id=\"slide-out\" class=\"side-nav\" style=\"background-color: black;\">\r\n" + 
      		"        <li><a href=\"#!\"><i class=\"fas fa-house-damage\"></i></a></li><br><br>\r\n" + 
      		"        <li><a href=\"#!\"><i class=\"fas fa-user-plus\"></i></a></li><br><br>\r\n" + 
      		"         <li><a href=\"#!\"><i class=\"fas fa-fire\"></i></a></li><br><br>\r\n" + 
      		"          <li><a href=\"#!\"><i class=\"fas fa-blog\"></i></i></a></li></div>\r\n" + 
      		"    </ul>\r\n" + 
      		"</div>\r\n" +
"\r\n" + 
"\r\n" +"<br>"+"<br>"+"<br>"+ 
"\r\n" + 
"<div class=\"card-container\">\r\n" + 
"<div class=\"upper-container\">\r\n" + 
"\r\n" + 
"<!-- materail icons-->\r\n" + 
"<i class=\"fas fa-user-circle\" style=\"color: white;position: relative;top: ;font-size: 90px;left: 60px;\" ></i>\r\n" + 
"\r\n" + 
"</div>\r\n" + 
"<div class=\"lowe-container\">\r\n"


      		);
		String city=request.getParameter("city");
		String bloodgroup=request.getParameter("bloodgroup");
		
		try{
			Class.forName("com.mysql.cj.jdbc.Driver");
			 Connection  con = DriverManager.getConnection("jdbc:mysql://localhost:3306/claret","root","");
			
			PreparedStatement ps=con.prepareStatement("select * from claret where city=? and bloodgroup=?");
			ps.setString(1,city);
			ps.setString(2,bloodgroup);
			
			
			ResultSet rs=ps.executeQuery();
			
		
	
			
			/* Printing result */
			while(rs.next())
			{
				out.print("<p style=color:#583759;font-size:20px;text-align:center>"+"<font style=color:black>Name : </font>"+ rs.getString(1)+"<br>"+"<font style=color:black>Phone No : </font>"+ rs.getString(2)+"<br>"+"<font style=color:black>Email : </font>"+ rs.getString(3)+"<br>"+"<font style=color:black>City : </font>"+ rs.getString(4)+"<br>"+"<font style=color:black>Age : </font>"+ rs.getString(5)+"<br>"+"<font style=color:black>Address : </font>"+ rs.getString(6)+"<br>"+"<font style=color:black>Blood-Group : </font>"+ rs.getString(7)+"</p>");
			}
				
				
			
			out.print("\r\n" + 
					"</div>\r\n" + 
					"\r\n" + 
					"\r\n" + 
					"\r\n" + 
					"\r\n" + 
					"\r\n" + 
					"</div>\r\n" + 
					"<br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br>\r\n" + 
					" <footer class=\"page-footer black\" style=\"height: 450px;color: black;position: relative;bottom: -356px;height:360px;\">\r\n" + 
					"\r\n" + 
					"<div class=\"row\">\r\n" + 
					"<div class=\"col s4 m4 l4\" style=\"font-family: interlude;font-size: 40px;color: white;position: relative;bottom: -70px;\">CLARET</div>\r\n" + 
					"                    <div class=\"col s1 m1 l1\" style=\"position: relative;bottom: -70px;\">\r\n" + 
					"\r\n" + 
					"                        \r\n" + 
					"\r\n" + 
					"                        <h5 class=\"white-text\">Project by:</h5>  \r\n" + 
					"    \r\n" + 
					"                        <ul>\r\n" + 
					"\r\n" + 
					"                            <li><a class=\"white-text\" href=\"https://github.com/ayush12451\">Ayush</a></li>                        \r\n" + 
					"\r\n" + 
					"                            <li><a class=\"white-text\" href=\"https://github.com/achyutshantanu\">Shantanu</a></li>\r\n" + 
					"\r\n" + 
					"                            <li><a class=\"white-text\" href=\"https://github.com/devashsih\">Devashish</a></li>\r\n" + 
					"\r\n" + 
					"                            <li><a class=\"white-text\" href=\"https://github.com/Areeb0206\">Areeb</a></li>\r\n" + 
					"<br>\r\n" + 
					"    <p style=\"color: white;\">Using <a class=\"orange-text text-lighten-3\" href=\"http://materializecss.com\">Materialize</a></p>\r\n" + 
					"\r\n" + 
					"                        </ul>\r\n" + 
					"\r\n" + 
					"                \r\n" + 
					"</div>\r\n" + 
					"<div class=\"col s1\">&nbsp;</div>\r\n" + 
					"<div class=\"col s1\" style=\"position: relative;bottom: -70px;\">\r\n" + 
					"             \r\n" + 
					"                    <h5 class=\"white-text\">Links</h5>\r\n" + 
					"\r\n" + 
					"                    <ul>\r\n" + 
					"\r\n" + 
					"                    <li><a class=\"white-text\" href='login.php'>Login</a></li>\r\n" + 
					"\r\n" + 
					"                        <li><a class=\"white-text\" href=\"register.php\">Register</a></li>\r\n" + 
					"\r\n" + 
					"                        <li><a class=\"white-text\" href=\"donors.php\">Donors</a></li>\r\n" + 
					"\r\n" + 
					"                        <li><a class=\"white-text\" href=\"index.html\">Home</a></li>\r\n" + 
					"<br>\r\n" + 
					"  <p style=\"color: white\">Follow on <a class=\"orange-text text-lighten-3\" href=\"https://github.com/ayush12451/blood_bank\">Github</a></p>\r\n" + 
					"                    </ul></div>\r\n" + 
					"<div class=\"col s1\">&nbsp;</div>\r\n" + 
					"   \r\n" + 
					"<div class=\"col s1\"style=\"position: relative;bottom: -70px;\">\r\n" + 
					"             \r\n" + 
					"                    <h5 class=\"white-text\">Resources</h5>\r\n" + 
					"\r\n" + 
					"                    <ul>\r\n" + 
					"\r\n" + 
					"                    <li><a class=\"white-text\" href='login.php'>FAQs</a></li>\r\n" + 
					"\r\n" + 
					"                        <li><a class=\"white-text\" href=\"register.php\">Benefits</a></li>\r\n" + 
					"\r\n" + 
					"                        <li><a class=\"white-text\" href=\"donors.php\">Types of Blood</a></li>\r\n" + 
					"\r\n" + 
					"                        <li><a class=\"white-text\" href=\"index.html\">Share your Story</a></li>\r\n" + 
					"\r\n" + 
					"                    </ul></div>\r\n" + 
					"\r\n" + 
					"</div>\r\n" + 
					"\r\n" + 
					"\r\n" + 
					"</footer>\r\n" + 
					"\r\n" + 
					"\r\n" + 
					" <script src=\"https://kit.fontawesome.com/fb965e2e7d.js\" crossorigin=\"anonymous\"></script>\r\n" + 
					"\r\n" + 
					" <script type=\"text/javascript\">var slideIndex = 0;\r\n" + 
					"showSlides();\r\n" + 
					"\r\n" + 
					"function showSlides() {\r\n" + 
					"  var i;\r\n" + 
					"   var slides = document.getElementsByClassName(\"mySlides\");\r\n" + 
					"  for (i = 0; i < slides.length; i++) {\r\n" + 
					"    slides[i].style.display = \"none\"; \r\n" + 
					"  }\r\n" + 
					"  slideIndex++;\r\n" + 
					"   if (slideIndex > slides.length) {slideIndex = 1} \r\n" + 
					"  slides[slideIndex-1].style.display = \"block\"; \r\n" + 
					"  setTimeout(showSlides, 2000); // Change image every 2 seconds\r\n" + 
					"} </script>\r\n" + 
					"</body>\r\n" + 
					"</html>");
			
			
			out.close();
			
		}catch (Exception e2) {e2.printStackTrace();}
		
	}

}
