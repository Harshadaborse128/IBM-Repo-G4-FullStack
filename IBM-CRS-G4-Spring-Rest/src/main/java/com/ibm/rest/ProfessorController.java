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
import com.ibm.bean.Student;
import com.ibm.dao.ProfessorDaoService;

/**
 * @author 003OQX744
 *
 */
@RestController
@CrossOrigin
public class ProfessorController {
	
	@Autowired
	private ProfessorDaoService ProfessorDaoSrv;
	
	@RequestMapping(produces = MediaType.APPLICATION_JSON, method = RequestMethod.GET, value = "/show-exam")
	@GetMapping("/show-exam")
	@Produces(MediaType.APPLICATION_JSON)
	
	public List<Exam> GetExam() 
	{
		ProfessorDaoSrv.Displayexam(); 
		return ProfessorDaoSrv.GetExam();
	}
	
	
	@GetMapping(path="/add-exam/{studentid}/{studentname}/{coursename}/{examapproval}")
	@Produces(MediaType.APPLICATION_JSON)
	public void addexam(@PathVariable("studentid")int student_id, @PathVariable("studentname") String student_name,
			 @PathVariable("coursename") String course_name, @PathVariable("examapproval") String exam_approval)
	{
		ProfessorDaoSrv.CreateExam(student_id, student_name, course_name, exam_approval);
	}
	
	
	@RequestMapping(produces = MediaType.APPLICATION_JSON, method = RequestMethod.GET, value = "/show-result")
	@GetMapping("/show-result")
	@Produces(MediaType.APPLICATION_JSON)
	
	public List<Exam> GetResult() 
	{
		ProfessorDaoSrv.Displayresult(); 
		return ProfessorDaoSrv.GetResult();
	}
	
	
	@GetMapping(path="/add-result/{studentid}/{studentname}/{coursename}/{result}")
	@Produces(MediaType.APPLICATION_JSON)
	public void addresult(@PathVariable("studentid")int student_id, @PathVariable("studentname") String student_name,
			 @PathVariable("coursename") String course_name, @PathVariable("result") String result)
	{
		ProfessorDaoSrv.CreateExam(student_id, student_name, course_name, result);
	}
	

}
