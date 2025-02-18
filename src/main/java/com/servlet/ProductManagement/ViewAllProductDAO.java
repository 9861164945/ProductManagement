package com.servlet.ProductManagement;

import java.net.http.HttpRequest.BodyPublisher;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class ViewAllProductDAO 
{
	public ArrayList<ProductBean>al=new ArrayList<ProductBean>();
	public ArrayList<ProductBean>retrieve()
	{
		
		try 
		{
			Connection con=DbConnection.getCon();
			PreparedStatement ps=con.prepareStatement("Select * from Product79");
			ResultSet rs=ps.executeQuery();
			while(rs.next()) 
			{
				ProductBean pb=new ProductBean();
				pb.setPcode(rs.getString(1));
				pb.setPname(rs.getString(2));
				pb.setPprice(rs.getFloat(3));
				pb.setPqty(rs.getInt(4));
				al.add(pb);//Bean Added to ArrayList
				
				
			}
		}
		catch (Exception e) 
		{
		
			e.printStackTrace();
		}
		return al;
	}

}
 