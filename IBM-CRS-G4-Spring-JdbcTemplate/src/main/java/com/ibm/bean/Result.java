/**
 * 
 */
package com.ibm.bean;

/**
 * @author 003OQX744
 *
 */

public class Result {
	
	private int student_id;
	private String student_name;
	private String course_name;
	private String result;
	
		
	public int getStudent_id() {
		return student_id;
	}
	public void setStudent_id(int student_id) {
		this.student_id = student_id;
	}
	public String getStudent_name() {
		return student_name;
	}
	public void setStudent_name(String student_name) {
		this.student_name = student_name;
	}
	public String getCourse_name() {
		return course_name;
	}
	public void setCourse_name(String course_name) {
		this.course_name = course_name;
	}
	public String getResult() {
		return result;
	}
	public void setResult(String result) {
		this.result = result;
	}
	
	@Override
	public String toString() {
		return "Student[stud_id = "+ student_id +", stud_name = "+ student_name +", course_name = " + course_name +", result = "+ result +"]";
	}


}
