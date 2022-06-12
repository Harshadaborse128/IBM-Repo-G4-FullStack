/**
 * 
 */
package com.ibm.bean;

/**
 * @author 003OQX744
 *
 */
public class Professor {
	private int professor_id;
	private String professor_name;
	private String address;
	private String course_name;
	private String email;
	
	public Professor(int professor_id, String professor_name, String address,  String course_name, String email)
	{
		this.setProfessorid(professor_id);
		this.setProfessorname(professor_name);
		this.setAddress(address);
		this.setCoursename(course_name);
		this.setEmail(email);
	}
	
	
	public int getProfessorid() {
		return professor_id;
	}
	public void setProfessorid(int professorid) {
		this.professor_id = professorid;
	}
	public String getProfessorname() {
		return professor_name;
	}
	public void setProfessorname(String professorname) {
		this.professor_name = professorname;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getCoursename() {
		return course_name;
	}
	public void setCoursename(String coursename) {
		this.course_name = coursename;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}


}
