/**
 * 
 */
package com.ibm.bean;

/**
 * @author 003OQX744
 *
 */
public class Student {
	
	private int stud_id;
	private String stud_name;
	private String address;
	private String stud_course;
	private String stud_email;

	
	public Student(int stud_id,String stud_name,String address,String stud_course,String stud_email )
	{
		this.setStud_id(stud_id) ;
		this.setStud_name(stud_name);
		this.setAddress(address);
		this.setStud_course(stud_course);
		this.setStud_email(stud_email);
		
	}
	
	
	public int getStud_id() {
		return stud_id;
	}


	public void setStud_id(int stud_id) {
		this.stud_id = stud_id;
	}


	public String getStud_name() {
		return stud_name;
	}


	public void setStud_name(String stud_name) {
		this.stud_name = stud_name;
	}


	public String getAddress() {
		return address;
	}


	public void setAddress(String address) {
		this.address = address;
	}


	public String getStud_course() {
		return stud_course;
	}


	public void setStud_course(String stud_course) {
		this.stud_course = stud_course;
	}


	public String getStud_email() {
		return stud_email;
	}


	public void setStud_email(String stud_email) {
		this.stud_email = stud_email;
	}

	
}
