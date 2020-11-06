
package com.meiri.jsp.review.model.vo;

import java.io.Serializable;

public class productFile implements Serializable {

   private static final long serialVersionUID = 777L;
   
   private int fcode;
   private int pcode;
   private String filepath;
   private String originname;
   private String changename;
   
   public productFile() {
      super();
      // TODO Auto-generated constructor stub
   }

   public productFile(int fcode, int pcode, String filepath, String originname, String changename) {
      super();
      this.fcode = fcode;
      this.pcode = pcode;
      this.filepath = filepath;
      this.originname = originname;
      this.changename = changename;
   }

   @Override
   public String toString() {
      return "productFile [fcode=" + fcode + ", pcode=" + pcode + ", filepath=" + filepath + ", originname="
            + originname + ", changename=" + changename + "]";
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

   public String getFilepath() {
      return filepath;
   }

   public void setFilepath(String filepath) {
      this.filepath = filepath;
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
   
   
   
   
}