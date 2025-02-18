package com.servlet.ProductManagement;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class AddProductDAO 
{
	public int k=0;
	public int insert(ProductBean pb)
	{
		try 
		{
			Connection con=DbConnection.getCon();
			PreparedStatement ps=con.prepareStatement("insert into Product79 values(?,?,?,?)");

			ps.setString(1, pb.getCode());
			ps.setString(2, pb.getName());
			ps.setFloat(3, pb.getPrice());
			ps.setInt(4, pb.getQty());
			
		} catch (Exception e) 
		{
		e.printStackTrace();	
		}
		return k;
		
	}

}
