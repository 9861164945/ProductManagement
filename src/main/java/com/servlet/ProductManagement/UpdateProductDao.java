
package com.servlet.ProductManagement;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class UpdateProductDao 
{
	public int k=0;
	public int update(ProductBean pb) 
	{
		try 
		{
			Connection con=DbConnection.getCon();
			PreparedStatement ps=con.prepareStatement("update product79 set pprice=?,pqty=? where pcode=?");
			ps.setFloat(1, pb.getPprice());
			ps.setInt(2, pb.getPqty());
			ps.setInt(3, pb.getPcode());
			k=ps.executeUpdate();
			if(k>0) 
			{
				System.out.println("Update ban gaya");
				
			}
			else {
				System.out.println("Sayad Kuch Missing Kiya hain");
			}
			
		} catch (Exception e) 
		{
			e.printStackTrace();
		
		}
		return k;
		
	}

}
