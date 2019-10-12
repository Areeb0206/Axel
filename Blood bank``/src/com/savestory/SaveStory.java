
package com.savestory;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sharemp.EmpShare;
import com.shareemp.ShareEmp;
@WebServlet("/Share")
public class SaveStory extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		String name=request.getParameter("name");
		String blood=request.getParameter("blood");
		String state=request.getParameter("state");
		String description=request.getParameter("description");
		
		
		ShareEmp e=new ShareEmp();
		e.setName(name);
		e.setBlood(blood);
		e.setState(state);
		e.setDescription(description);
		
		
		int status=EmpShare.save(e);
		if(status>0){
		out.print("ok");
		}else{
			
			request.getRequestDispatcher("/RegStory").include(request, response);
			
		}
		
		out.close();
	}

}
