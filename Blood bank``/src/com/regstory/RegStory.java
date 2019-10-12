package com.regstory;
import java.awt.*;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JButton;
import javax.swing.JFrame;

import com.sharemp.EmpShare;
import com.shareemp.ShareEmp;
@WebServlet("/RegStory")
public class RegStory extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

			
		
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		out.print("<html>");
			out.print("<head>");
	      	out.print("   <link type='text/css' rel='stylesheet' href='main.css'  media='screen,projection'/>");
	      	out.print("  <script src='https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js'></script>");

	         
	    
	      		out.print(" <link rel='stylesheet' href='https://cdnjs.cloudflare.com/ajax/libs/materialize/0.97.6/css/materialize.min.css'>");

	 
	      	out.print("<script src='https://cdnjs.cloudflare.com/ajax/libs/materialize/0.97.6/js/materialize.min.js'></script>");
	          out.print("  <script type='text/javascript'>	              $(document).ready(function(){	                 $('.button-collapse').sideNav();	                 $('.collapsible').collapsible();	              });");
	              out.print("   </script>");
	          out.print("    </head>");
	      out.print("   <body bgcolor=grey>");
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
	      		"");
		     
			
			List<ShareEmp> list=EmpShare.getAllEmployees();
			
		out.print("<table>\r\n" + 
				" \r\n" + 
				"  <tr>\r\n" + 
				"    <td width=\"30%\" style=\"text-align: center;\"><div class='con1'>\r\n" + 
				"     <form action=\"RegStory\">\r\n" + 
				"      <input type=\"text\" name=\"name\" placeholder='Search Your Story' style='width:230px;height:30px;font-family: interlude;font-size: 30px;color: grey'><br/>\r\n" + 
				"      <input type=\"submit\" value=\"search\" style=\"font-size: 30px;\">\r\n" + 
				"     </form></div>\r\n" + 
				"");
			
			String name=request.getParameter("name");
			
			try{
				Class.forName("com.mysql.cj.jdbc.Driver");
				 Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/share","root", "");
				
				PreparedStatement ps=con.prepareStatement("select * from story where name=?");
				ps.setString(1,name);
		ResultSet rs=ps.executeQuery();
				
				
				
			
			
		
				while(rs.next())
				{
					  out.print("   <div class='con2'>   \r\n" + 
					  		"<div class=\"card\" >\r\n" + 
					  		"    <div class=\"imgBox\">\r\n" + 
					  		"      <font style=\"color:black;\">");
					   
				    	out.print(rs.getString(1));   out.print("<br>");out.print("<br>"); 
				    	out.print(rs.getString(2));   out.print("<br>");out.print("<br>");
				    	out.print(rs.getString(3));   out.print("<br>");out.print("<br>");
				    	out.print("</div>");
				    	out.print("<div class='details'>");
					    out.print(rs.getString(4));   out.print("<br>");out.print("<br>");	out.print("</div>");
				    	out.print("</div>");
				    	out.print("</div>");	
						
					}
					
					
		
			
				
				
			}catch (Exception e2) {e2.printStackTrace();}
			
			out.print("</td>"); 
			out.print("<br>"); 
			out.print("<br>");out.print("<br>");out.print("<br>");  
		out.print("\r\n" + 
				"    <td width=\"40%\" style=\"text-align: center;position:relative;left:-50px;\">");   
		  

		   int pageid = 1;
		     int total=5;
		        if(request.getParameter("page") != null)
		            pageid = Integer.parseInt(request.getParameter("page"));
		         else{  
	           pageid=pageid-1;  
	           pageid=pageid*total+1;  
	       }  
		      
		    	
		    	List<ShareEmp> list1=EmpShare.getAllEmployees();
		    	out.print("<br>");  				
		    	out.print("<br>");  				
		    	
		    		String x=null;
		    		String r=null;
		    		String t=null; 
		    		String d=null;
		    	
		    		for(ShareEmp e:list1 ){
		    			x=e.getName();
		    			r=e.getBlood();
		    			t=e.getState();
		    			d=e.getDescription();
		    		  	

		    	     
		    	        out.print("<div class='con3'>\r\n" + 
		    	        		"          \r\n" + 
		    	        		"<div class=\"card\" style=\"top: -50px;\" >\r\n" + 
		    	        		"    <div class=\"imgBox\">\r\n" + 
		    	        		"      <font style=\"color: white;\">");
		    	        out.print("<br>");  out.print("<br>");  
		    	    	out.print(x);   out.print("<br>");out.print("<br>"); 
		    			out.print(r);   out.print("<br>");out.print("<br>"); 
		    	        out.print(t);   out.print("<br>");out.print("<br>"); 
		    	    	out.print("</font>");out.print("</div>");
		    			out.print("<div class='details'>");
		    		    out.print(d);
		    		    		    out.print("</div>");
		    		    out.print("</div>"); 
		    		   
		    		}
		    		    out.print("&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href='RegStory?page=1'>1</a> &nbsp;&nbsp;&nbsp;");  
		    	        out.print("&nbsp;&nbsp;&nbsp;<a href='RegStory?page=2'>2</a>&nbsp;&nbsp;&nbsp;");  
		    	        out.print("&nbsp;&nbsp;&nbsp;<a href='RegStory?page=3'>3</a>&nbsp;&nbsp;&nbsp;");  
		    		    out.print("</div");	  
		    	
		    		    out.print("</div");	 
			  out.print("</td>"); 
		
			
	out.print("\r\n" + 
			"    <td width=\"30%\" style=\"text-align: center;\">   \r\n" + 
			"    <div class='container'>\r\n" + 
			"       <h2 style=\"position: relative;left: -100px;bottom: 340px;font-family:  interlude\">Share your Story</h2>\r\n" + 
			"      <br><br> <form action='Share' method='post'>\r\n" + 
			"        <table>\r\n" + 
			"        <tr><td><p style=\"font-size: 25px;position:relative;left:-100px;top:-390px;\">Name</td><td><input type='text' name='name' style='width:270px;height:30px;font-size: 30px;position: relative;left: -40px;top:-390px;' ></p></td></tr>\r\n" + 
			"       <tr><td><p style=\"font-size: 25px;position:relative;left:-100px;top:-390px\">Blood</td><td><input type='text' name='blood' style='width:270px;height:30px;font-size: 30px;position: relative;left: -40px;top:-390px;' ></td></tr>\r\n" + 
			"       <tr><td><h2 style=\"font-size: 25px;position:relative;left:-100px;top:-390px\">State</td><td><input type='text' name='state' style='width:270px;height:30px;font-size: 30px;position: relative;left: -40px;top:-390px;' ></td></tr>\r\n" + 
			"     <tr><td><h2 style=\"font-size: 25px;position:relative;left:-100px;top:-390px\">Description:</td><td><input type='text' name='description' style='width:270px;height:100px;font-size: 30px;position: relative;left: -40px;top:-390px;' ></td></tr></h2>\r\n" + 
			"      <tr><td colspan='2' ><input type='submit' value='Save ' style=\"font-size: 25px;position:relative;left:-100px;top:-390px\"></td></tr>\r\n" + 
			"       </table>\r\n" + 
			"        </form>\r\n" + 
			"        </div> </div>\r\n" + 
			"        \r\n" + 
			"        </td>\r\n" + 
			"        \r\n" + 
			"      \r\n" + 
			"    </tr>\r\n" + 
			"      \r\n" + 
			"      \r\n" + 
			"      \r\n" + 
			"      \r\n" + 
			"      \r\n" + 
			"      \r\n" + 
			"  </table>");out.print("<br>");  out.print("<br>");  out.print("<br>");  out.print("<br>");  
			out.print("\r\n" + 
					"<br><br><br><br><br><br><br>\r\n" + 
					" <footer class=\"page-footer black\" style=\"height: 400px;color: black;position: relative;bottom: -100px;\">\r\n" + 
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
					"</footer>");
			
			out.print(" <script src=\"https://kit.fontawesome.com/fb965e2e7d.js\" crossorigin=\"anonymous\"></script>");
		 out.print("</body>");
		    out.print("</html>");

		
		
	}

	}

	