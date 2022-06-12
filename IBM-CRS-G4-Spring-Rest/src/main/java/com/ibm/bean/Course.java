/**
 * 
 */
package com.ibm.bean;

/**
 * @author 003OQX744
 *
 */
public class Course {
	private int course_id;
	private String course_name;
	private String course_grade;
	private String course_type;
	private String course_status;
	private String course_fees;
	
	
	public Course(int course_id, String course_name, String course_grade, String course_type, String course_status, String course_fees )
	{
		this.setCours_id(course_id);
		this.setCourse_name(course_name);
		this.setCourse_grade(course_grade);
		this.setCourse_type(course_type);
		this.setCourse_status(course_status);
		this.setCourse_fees(course_fees);
	}
	
	
	public int getCours_id() {
		return course_id;
	}
	public void setCours_id(int cours_id) {
		this.course_id = cours_id;
	}
	public String getCourse_name() {
		return course_name;
	}
	public void setCourse_name(String course_name) {
		this.course_name = course_name;
	}
	public String getCourse_grade() {
		return course_grade;
	}
	public void setCourse_grade(String course_grade) {
		this.course_grade = course_grade;
	}
	public String getCourse_type() {
		return course_type;
	}
	public void setCourse_type(String course_type) {
		this.course_type = course_type;
	}
	public String getCourse_status() {
		return course_status;
	}
	public void setCourse_status(String course_status) {
		this.course_status = course_status;
	}
	public String getCourse_fees() {
		return course_fees;
	}
	public void setCourse_fees(String course_fees) {
		this.course_fees = course_fees;
	}


 
	

}
