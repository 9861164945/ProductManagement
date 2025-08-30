package com.servlet.ProductManagement;

import java.sql.Connection;
import java.sql.DriverManager;

public class DbConnection 
{
	private static Connection con=null;
	@SuppressWarnings("unused")
	private  void DBonnection() {}

		static//Start Of Static Block 
		{
			try 
		{
			Class.forName(DBInfo.driver);
			con=DriverManager.getConnection(DBInfo.dbUrl,DBInfo.dbUname,DBInfo.dbPword);
			
			
		}
		catch (Exception e)
		{
	System.err.println("Something went Wrong While COnntecting the Database" + e.getMessage()) ;
		}
		
	}//end of static block
		public static Connection getCon() 
		{
			return con;
			
		}
		

}
