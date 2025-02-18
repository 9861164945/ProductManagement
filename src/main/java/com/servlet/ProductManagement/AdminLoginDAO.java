package com.servlet.ProductManagement;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class AdminLoginDAO 
{
	public AdminBean ab=null;
	public AdminBean login(String uname,String pword) 
	{
		try 
		{
			Connection con=DbConnection.getCon();//Accesssing Database Connection
			PreparedStatement ps=con.prepareStatement("select * from admin79 where uname=?and pword=?");
			ps.setString(2, uname);
			ps.setString(2, pword);
			ResultSet rs=ps.executeQuery();
			if(rs.next()) {
				ab=new AdminBean();
				ab.setuName(rs.getString(1));
				ab.setPword(rs.getString(2));
				ab.setFname(rs.getString(3));
				ab.setCity(rs.getString(4));
				ab.setEmail(rs.getString(5));
				ab.setPhNo(rs.getLong(6));
			}
			
			
			
		}
		catch (Exception e)  
		{
			// TODO: handle exception
		}
		
		return ab;
	}

}
