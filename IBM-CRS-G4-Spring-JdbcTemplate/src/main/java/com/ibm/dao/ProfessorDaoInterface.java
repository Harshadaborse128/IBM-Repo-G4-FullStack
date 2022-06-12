/**
 * 
 */
package com.ibm.dao;

import java.util.List;

import com.ibm.bean.Exam;
import com.ibm.bean.Result;


/**
 * @author 003OQX744
 *
 */
public interface ProfessorDaoInterface {
	
	public void CreateExam(int student_id, String student_name, String course_name, String exam_approval);
	
	public List<Exam> listsExam();
	
	public void CreateResult(int student_id, String student_name, String course_name, String result);
	
	public List<Result> listsResult();
	
	public void updateresult(int student_id, String result) ;
	
	public void updateexam(int student_id, String exam_approval);

}
