package com.servlet.ProductManagement;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class ResgisterDao {
    public int insert(CustomerBean cb) {
        int k = 0;

        try {
            Connection conn = DbConnection.getCon();
            PreparedStatement ps = conn.prepareStatement(
                "INSERT INTO Customer79 (cfname, clname, cemail, cphno, address, cpword, cuname) VALUES (?, ?, ?, ?, ?, ?, ?)");

            ps.setString(1, cb.getCfname());
            ps.setString(2, cb.getClname());
            ps.setString(3, cb.getCemail());
            ps.setLong(4, cb.getCphno());
            ps.setString(5, cb.getAddress());
            ps.setString(6, cb.getCpword());
            ps.setString(7, cb.getCuname());

            k = ps.executeUpdate();

            if (k > 0) {
                System.out.println("Successfully Added Customer Details");
            } else {
                System.err.println("Something went wrong while insertion");
            }
            ps.close();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return k;
    }
}
