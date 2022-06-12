/**
 * 
 */
package com.ibm.rest;

import java.util.List;

import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ibm.bean.Exam;
import com.ibm.bean.Result;
import com.ibm.dao.ProfessorDaoService;

/**
 * @author 003OQX744
 *
 */

@RestController
@CrossOrigin
public class ProfessorRestController {
	
	@Autowired
	ProfessorDaoService professordaoservice;
	
	/**path="/add-exam" for Add Student Exam Details
	 * Method CreateExam call from ProfessorDaoService
	 * @param student_id
	 * @param student_name	 
	 * @param course_name
	 * @param exam_approval
	 **/
	
	@GetMapping(path="/add-exam/{studentid}/{studentname}/{coursename}/{examapproval}")
	@Produces(MediaType.APPLICATION_JSON)
	public void addexam(@PathVariable("studentid")int student_id, @PathVariable("studentname") String student_name,
			 @PathVariable("coursename") String course_name, @PathVariable("examapproval") String exam_approval)
	{
		professordaoservice.CreateExam(student_id, student_name, course_name, exam_approval);
	}
	
	/**path="/show-exam" for Display Student Exam Details
	 * @return Method listexam call from ProfessorDaoService
	 */
	
	@RequestMapping(produces = MediaType.APPLICATION_JSON, method = RequestMethod.GET, value = "/show-exam")
	@GetMapping("/show-exam")
	@Produces(MediaType.APPLICATION_JSON)
	
	public List<Exam> listexam() 
	{
		return professordaoservice.listsExam();
	}
	
	/**path="/add-result" for Add Student Result Details
	 * Method CreateResult call from ProfessorDaoService
	 * @param student_id
	 * @param student_name	 
	 * @param course_name
	 * @param result
	 **/
	
	@GetMapping(path="/add-result/{studentid}/{studentname}/{coursename}/{result}")
	@Produces(MediaType.APPLICATION_JSON)
	public void addresult(@PathVariable("studentid")int student_id, @PathVariable("studentname") String student_name,
			 @PathVariable("coursename") String course_name, @PathVariable("result") String result)
	{
		professordaoservice.CreateResult(student_id, student_name, course_name, result);
	}
	
	/**path="/show-result" for Display Student Exam Details
	 * @return Method listsResult call from ProfessorDaoService
	 */	
	
	@RequestMapping(produces = MediaType.APPLICATION_JSON, method = RequestMethod.GET, value = "/show-result")
	@GetMapping("/show-result")
	@Produces(MediaType.APPLICATION_JSON)
	
	public List<Result> listsResult() 
	{
		return professordaoservice.listsResult();
	}
	
	/**path="/updateresult" for Update Student Result Details
	 * @return Method updateresult call from ProfessorDaoService
	 */
	
	@GetMapping(path="/updateresult/{studentid}/{result}")
	@Produces(MediaType.APPLICATION_JSON)
	public void updateresult(@PathVariable("studentid")int student_id, @PathVariable("result") String result)
	{
		professordaoservice.updateresult(student_id, result);
	}
	
	/**path="/updaterexam" for Update Student Exam Details
	 * @return Method updateexam call from ProfessorDaoService
	 */
	
	@GetMapping(path="/updaterexam/{studentid}/{exam_approval}")
	@Produces(MediaType.APPLICATION_JSON)
	public void updateexam(@PathVariable("studentid")int student_id, @PathVariable("exam_approval") String exam_approval)
	{
		professordaoservice.updateexam(student_id, exam_approval);
	}

}
