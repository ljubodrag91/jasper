package com.report;

import java.math.BigDecimal;

public class Product {

	public Product() {
		
	}
	
	public Product(BigDecimal pROD_ID, String nAME, String iMAGE, String dESCRIPTION) {
		super();
		PROD_ID = pROD_ID;
		NAME = nAME;
		IMAGE = iMAGE;
		DESCRIPTION = dESCRIPTION;
	}

	public BigDecimal getPROD_ID() {
		return PROD_ID;
	}
	public void setPROD_ID(BigDecimal pROD_ID) {
		PROD_ID = pROD_ID;
	}
	public String getNAME() {
		return NAME;
	}
	public void setNAME(String nAME) {
		NAME = nAME;
	}
	public String getIMAGE() {
		return IMAGE;
	}
	public void setIMAGE(String iMAGE) {
		IMAGE = iMAGE;
	}
	public String getDESCRIPTION() {
		return DESCRIPTION;
	}
	public void setDESCRIPTION(String dESCRIPTION) {
		DESCRIPTION = dESCRIPTION;
	}
	private BigDecimal PROD_ID;
	private String NAME;
	private String IMAGE;
	private String DESCRIPTION;
	
}
