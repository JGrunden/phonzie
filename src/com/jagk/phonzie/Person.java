package com.jagk.phonzie;

public class Person {

	private String fname="FirstName";
	private String lname="LastName";
	private Integer pnumber;

	public Person(){
	}

	public String getFname() {
		return fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

	public String getLname() {
		return lname;
	}

	public void setLname(String lname) {
		this.lname = lname;
	}

	public Integer getPnumber() {
		return pnumber;
	}

	public void setPnumber(Integer pnumber) {
		this.pnumber = pnumber;
	}

	public Person(String fname, String lname, Integer pnumber){
		this.fname = fname;
		this.lname = lname;
		this.pnumber = pnumber;
	}

}
