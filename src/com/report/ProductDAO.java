package com.report;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ProductDAO {

	public List<Product> getAllProducts() throws SQLException {
		List<Product> products = new ArrayList<>();
		Connection conn = DBConnection.getInstance().getConnection();
		
		Statement stmt = conn.createStatement();
		ResultSet rset = stmt.executeQuery("SELECT * FROM products");
		
		while(rset.next()) {
			products.add(new Product(rset.getBigDecimal(1), rset.getString(2), rset.getString(3), rset.getString(4)));
		}
		conn.close();
		return products;
	}
}
