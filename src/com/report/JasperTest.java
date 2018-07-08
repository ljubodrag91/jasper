package com.report;

import java.io.IOException;
import java.sql.SQLException;

import net.sf.jasperreports.engine.JRException;

public class JasperTest {

	public static void main(String[] args) throws JRException, SQLException, IOException {

		JasperUtils ju = new JasperUtils();
		System.out.println("Start...");
			ju.toPdfFile("oracle");
		System.out.println("Finish...");
	}
}