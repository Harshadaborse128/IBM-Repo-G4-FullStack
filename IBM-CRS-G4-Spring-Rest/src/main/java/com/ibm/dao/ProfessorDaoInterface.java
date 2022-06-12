/**
 * 
 */
package com.ibm.dao;

/**
 * @author 003OQX744
 *
 */
public interface ProfessorDaoInterface {
	public void details();
	public void CreateExam(int student_id, String student_name, String course_name, String exam_approval);
	public void result(int student_id, String student_name, String course_name, String result);
	public void Displayexam();
	public void Displayresult();

}
