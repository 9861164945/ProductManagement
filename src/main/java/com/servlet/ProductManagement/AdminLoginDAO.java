package com.servlet.ProductManagement;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AdminLoginDAO 
{
    public AdminBean ab = null;

    public AdminBean login(String uname, String pword) 
    {
        try 
        {
            // Accessing Database Connection
            Connection con = DbConnection.getCon();
            
            if (con == null) {
                System.out.println("Database connection failed.");
                return null;
            }

            // Prepare the query to select the admin user
            PreparedStatement ps = con.prepareStatement(
            	    "SELECT * FROM admin79 WHERE LOWER(uname) = LOWER(?) AND LOWER(pword) = LOWER(?)"
            	);
            	ps.setString(1, uname.toLowerCase());
            	ps.setString(2, pword.toLowerCase());
            // Execute the query
            ResultSet rs = ps.executeQuery();

            // Check if a row is returned
            if (rs.next()) 
            {
                ab = new AdminBean();
                ab.setuName(rs.getString("uname"));  // Use column name instead of index
                ab.setPword(rs.getString("pword"));
                ab.setFname(rs.getString("fname"));
                ab.setCity(rs.getString("city"));
                ab.setEmail(rs.getString("email"));
                ab.setPhNo(rs.getLong("phno"));
                System.out.println("Admin found.");
            } 
            else {
                System.out.println("No admin found.");
            }

        } catch (SQLException e) {
            e.printStackTrace();  // Log SQL exceptions
        }

        return ab;  // Return null if no admin is found
    }
}
