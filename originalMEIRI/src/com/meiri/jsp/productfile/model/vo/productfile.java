package com.meiri.jsp.productfile.model.vo;

import java.io.Serializable;

public class productfile implements Serializable {

	private static final long serialVersionUID = 123123123L;
	
	private int fcode;
	private int pcode;
	private String originname;
	private String changename;
	private String filepath;
	
	public productfile() {
		super();
		// TODO Auto-generated constructor stub
	}

	public productfile(int fcode, int pcode, String originname, String changename, String filepath) {
		super();
		this.fcode = fcode;
		this.pcode = pcode;
		this.originname = originname;
		this.changename = changename;
		this.filepath = filepath;
	}

	@Override
	public String toString() {
		return "productfile [fcode=" + fcode + ", pcode=" + pcode + ", originname=" + originname + ", changename="
				+ changename + ", filepath=" + filepath + "]";
	}

	public int getFcode() {
		return fcode;
	}

	public void setFcode(int fcode) {
		this.fcode = fcode;
	}

	public int getPcode() {
		return pcode;
	}

	public void setPcode(int pcode) {
		this.pcode = pcode;
	}

	public String getOriginname() {
		return originname;
	}

	public void setOriginname(String originname) {
		this.originname = originname;
	}

	public String getChangename() {
		return changename;
	}

	public void setChangename(String changename) {
		this.changename = changename;
	}

	public String getFilepath() {
		return filepath;
	}

	public void setFilepath(String filepath) {
		this.filepath = filepath;
	}
	
	
	
	
	
}
