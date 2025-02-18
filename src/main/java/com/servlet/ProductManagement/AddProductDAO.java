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

			ps.setString(1, pb.getPcode());
			ps.setString(2, pb.getPname());
			ps.setFloat(3, pb.getPprice());
			ps.setInt(4, pb.getPqty());
			
		} catch (Exception e) 
		{
		e.printStackTrace();	
		}
		return k;
		
	}

}
