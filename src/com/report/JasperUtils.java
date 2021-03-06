package com.report;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;

public class JasperUtils {

	private ProductDAO productDao;
	
	public JasperUtils(){
		productDao = new ProductDAO();
	}
	
	public void toPdfFile(String jrxmlFileName) throws FileNotFoundException, SQLException, JRException {
		InputStream inputStream = new FileInputStream("reports/"+jrxmlFileName+".jrxml");
		
		JRBeanCollectionDataSource beanColDataSource = new JRBeanCollectionDataSource(productDao.getAllProducts());
		
		Map parameters = new HashMap();
		
        JasperDesign jasperDesign = JRXmlLoader.load(inputStream);
        JasperReport jasperReport = JasperCompileManager.compileReport(jasperDesign);
        JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameters, beanColDataSource);
        
        JasperExportManager.exportReportToPdfFile(jasperPrint, "reports/"+jrxmlFileName+".pdf");
	}
}
