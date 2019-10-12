package com.sharemp;


import java.util.*;

import com.shareemp.ShareEmp;

import java.sql.*;

public class EmpShare {

	public static Connection getConnection(){
		Connection con=null;
		try{
			Class.forName("com.mysql.cj.jdbc.Driver");
			 con = DriverManager.getConnection("jdbc:mysql://localhost:3306/share","root","");
			 
}
		catch(Exception e){System.out.println(e);}
		return con;
	}
	public static int save(ShareEmp e){
		int status=0;
		try{
			Connection con=EmpShare.getConnection();
			PreparedStatement ps=con.prepareStatement("insert into story(name,blood,state,description) values (?,?,?,?)");
			ps.setString(1,e.getName());
			ps.setString(2,e.getBlood());
			ps.setString(3,e.getState());
			ps.setString(4,e.getDescription());
	
			
			
			status=ps.executeUpdate();
			
			con.close();
		}catch(Exception ex){ex.printStackTrace();}
		
		return status;
	}

	public static int update(ShareEmp e){
		int status=0;
		try{
			Connection con=EmpShare.getConnection();
			PreparedStatement ps=con.prepareStatement("update story set blood=?,state=? ,description=? where name=?");
		   	ps.setString(1,e.getBlood());
			ps.setString(2,e.getState());
			ps.setString(3,e.getDescription());
			ps.setString(4,e.getName());
	        status=ps.executeUpdate();
			
			con.close();
		}catch(Exception ex){ex.printStackTrace();}
		
		return status;
	}
	
	public static int delete(String name){
		int status=0;
		try{
			Connection con=EmpShare.getConnection();
			PreparedStatement ps=con.prepareStatement("delete from story where name=?");
			ps.setString(1,name);
			status=ps.executeUpdate();
			
			con.close();
		}catch(Exception e){e.printStackTrace();}
		
		return status;
	}
	
	public static ShareEmp getEmployeeById(String name1){
		ShareEmp e=new ShareEmp();
		
		try{
			Connection con=EmpShare.getConnection();
			PreparedStatement ps=con.prepareStatement("select  from story where name=?,blood=?,state=?,description=? where name1=?");
		    ps.setString(1,name1);
		    ResultSet rs=ps.executeQuery();
			while(rs.next()){
				e.setName(rs.getString(1));
				e.setBlood(rs.getString(2));
				e.setState(rs.getString(3));
				e.setDescription(rs.getString(4));
				
				
			}
			con.close();
		}catch(Exception ex){ex.printStackTrace();}
		
		return e;
	}
	public static List<ShareEmp> getAllEmployees(){
		List<ShareEmp> list=new ArrayList<ShareEmp>();
		
		try{
			Connection con=EmpShare.getConnection();
			PreparedStatement ps=con.prepareStatement("select * from story");
			ResultSet rs=ps.executeQuery();
			while(rs.next()){
				ShareEmp e=new ShareEmp();
				e.setName(rs.getString(1));
				e.setBlood(rs.getString(2));
				e.setState(rs.getString(3));
				e.setDescription(rs.getString(4));
				
				
				list.add(e);
			}
			con.close();
		}catch(Exception e){e.printStackTrace();}
		
		return list;
	}

	public static List<ShareEmp> getEmployees(String name){
		List<ShareEmp> list=new ArrayList<ShareEmp>();
		
		try{
			Connection con=EmpShare.getConnection();
			PreparedStatement ps=con.prepareStatement("select * from story where name=?");
			ps.setString(1, name);
			ResultSet rs=ps.executeQuery();
			while(rs.next()){
				ShareEmp e=new ShareEmp();
				e.setName(rs.getString(1));
				e.setBlood(rs.getString(2));
				e.setState(rs.getString(3));
				e.setDescription(rs.getString(4));
				
				
				list.add(e);
			}
			con.close();
		}catch(Exception e){e.printStackTrace();}
		
		return list;
	  
    } 
    public static List<ShareEmp> getEmployees(int start,int total){  
        List<ShareEmp> list=new ArrayList<ShareEmp>();  
        try{  
            Connection con=getConnection();  
            PreparedStatement ps=con.prepareStatement("select * from story limit "+(start-1)+","+total);  
            ResultSet rs=ps.executeQuery();  
            while(rs.next()){  
                ShareEmp e=new ShareEmp();  
                e.setName(rs.getString(1));  
                e.setBlood(rs.getString(2));  
                e.setState(rs.getString(3));  
                e.setDescription(rs.getString(4));  
                
                list.add(e);  
            }  
            con.close();  
        }catch(Exception e){System.out.println(e);}  
        return list;  
    }  
}  