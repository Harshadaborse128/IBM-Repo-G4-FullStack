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
	
	@Override
	public String toString() {
		return "Student[professor_id = "+ professor_id +", professor_name = "+ professor_name +", address = "+ address +",course_name = " + course_name +",email = "+ email +"]";
	}

}
