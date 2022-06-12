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
	
	public Result(int student_id, String student_name, String course_name, String result)
	{
		this.setStudent_id(student_id);
		this.setStudent_name(student_name);
		this.setCourse_name(course_name);
		this.setExam_approval(result);
	}
	
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
	public String getExam_approval() {
		return result;
	}
	public void setExam_approval(String exam_approval) {
		this.result = result;
	}


}
