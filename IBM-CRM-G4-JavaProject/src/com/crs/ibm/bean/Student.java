/**
 * 
 */
package com.crs.ibm.bean;

/**
 * @author 003OQX744
 *
 */
public class Student {

	/**
	 * @param args
	 */
	
	//constructor
	
	private int studid;
	private String name;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getBatch() {
		return batch;
	}
	public void setBatch(String batch) {
		this.batch = batch;
	}
	private String batch;
	public int getStudid() {
		return studid;
	}
	public void setStudid(int studid) {
		this.studid = studid;
	}
	public String getCourse() {
		return course;
	}
	public void setCourse(String course) {
		this.course = course;
	}
	private String course;
}
	
	/*
	 * public Student(int student_id, String student_name, String address, String
	 * course_name, String email) { this.student_id = student_id; this.student_name
	 * = student_name; this.address = address; this.course_name = course_name;
	 * this.email = email; bIsLogin = true; } private String userName; private
	 * String password; private Boolean bIsLogin; private String name; private int
	 * EnrollID; private String CourseName; private int LoginID;
	 * 
	 * //student table private int student_id; private String student_name; private
	 * String address; private String course_name; private String email;
	 * 
	 * 
	 * //student table method public int getStudent_ID() { return student_id; }
	 * public void setStudent_ID(int student_id) { this.student_id = student_id; }
	 * public String getStudent_Name() { return student_name; } public void
	 * setStudent_Name(String student_name) { this.student_name = student_name; }
	 * public String getAddress() { return address; } public void setAddress(String
	 * address) { this.address = address; } public String getEmail() { return email;
	 * } public void setEmail(String email) { this.email = email; }
	 * 
	 * 
	 * 
	 * 
	 * ///
	 * 
	 * public String getName() { return name; } public void setName(String name) {
	 * this.name = name; } public int getEnrollID() { return EnrollID; } public void
	 * setEnrollID(int enrollID) { this.EnrollID = enrollID; } public String
	 * getCourseName() { return CourseName; } public void setCourseName(String
	 * courseName) { this.CourseName = courseName; } public int getLoginID() {
	 * return LoginID; } public void setLoginID(int LoginId) { this.LoginID =
	 * LoginID; } public boolean auth() { // TODO Auto-generated method stub return
	 * bIsLogin; }
	 * 
	 * 
	 * 
	 * }
	 */