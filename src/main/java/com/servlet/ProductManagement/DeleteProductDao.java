package com.servlet.ProductManagement;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class DeleteProductDao {
    public int delete(ProductBean pb) {
        int k=0;
        try {
            Connection con = DbConnection.getCon();
            PreparedStatement ps = con.prepareStatement("DELETE FROM product79 WHERE pcode=?");
            ps.setInt(1, pb.getPcode());
             k= ps.executeUpdate();

            if (k > 0) {
                System.out.println("Product deleted successfully.");
                
            } else {
                System.out.println("Product not found.");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return k;
    }
}
