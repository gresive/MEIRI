package com.meiri.jsp.product.model.vo;

import java.io.Serializable;

public class Product implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private int pno;
	private String pname;
	private int pprice;
	private String ptype;
	private String pcolor;
	private int previews;
	
	
	
	public Product() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Product(int pno, String pname, int pprice, String ptype, String pcolor, int previews) {
		super();
		this.pno = pno;
		this.pname = pname;
		this.pprice = pprice;
		this.ptype = ptype;
		this.pcolor = pcolor;
		this.previews = previews;
	}


	public Product(String pname, int pprice, String ptype, String pcolor) {
		super();
		this.pname = pname;
		this.pprice = pprice;
		this.ptype = ptype;
		this.pcolor = pcolor;
	}

	public int getPno() {
		return pno;
	}

	public void setPno(int pno) {
		this.pno = pno;
	}

	public String getPname() {
		return pname;
	}

	public void setPname(String pname) {
		this.pname = pname;
	}

	public int getPprice() {
		return pprice;
	}

	public void setPprice(int pprice) {
		this.pprice = pprice;
	}

	public String getPtype() {
		return ptype;
	}

	public void setPtype(String ptype) {
		this.ptype = ptype;
	}

	public String getPcolor() {
		return pcolor;
	}

	public void setPcolor(String pcolor) {
		this.pcolor = pcolor;
	}

	public int getPreviews() {
		return previews;
	}

	public void setPreviews(int previews) {
		this.previews = previews;
	}
}
