package com.servlet.ProductManagement;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class CustomerLoginDao 
{
	public CustomerBean cb=null;
	public CustomerBean login(String cuname,String cpword)
	{
		try 
		{
			Connection con=DbConnection.getCon();
			if(con==null) 
			{
				System.out.println("Database Connection Failed for Customer..");
				
			}
			PreparedStatement ps=con.prepareStatement("Select * from Customer79 where LOWER(cuname)=LOWER(?) AND LOWER(cpword)=LOWER(?)");
			ps.setString(1, cuname.toLowerCase());
			//check both uppercase and Lower Case
			ps.setString(2, cpword.toLowerCase());
			
			ResultSet rs=ps.executeQuery();
			if(rs.next()) 
			{
				cb=new CustomerBean();
				cb.setCfname(rs.getString("cfname"));
				cb.setClname(rs.getString("clname"));
				cb.setCemail(rs.getString("cemail"));
				cb.setCphno(rs.getLong("cphno"));
				cb.setAddress(rs.getString("address"));
				cb.setCpword(rs.getString("cpword"));
				cb.setCuname(rs.getString("cuname"));
				
				
			}
			else 
			{
				System.out.println("User not Found");
			}
			
		} catch (Exception e) 
		
		{
			e.printStackTrace();
			// TODO: handle exception
		}
		
		return cb;
		
	}

}
