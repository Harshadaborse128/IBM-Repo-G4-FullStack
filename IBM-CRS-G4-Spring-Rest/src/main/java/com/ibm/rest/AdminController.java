/**
 * 
 */
package com.ibm.rest;

import java.util.List;

import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ibm.bean.Professor;
import com.ibm.dao.AdminDaoService;

/**
 * @author 003OQX744
 *
 */
@RestController
@CrossOrigin
public class AdminController {
	
	@Autowired
	private AdminDaoService adminDaoSrv;
	
	
	/**path="/show-professor" for Display Professor Details
	 * Method Displayprofessor call from AdminDaoService
	 * @return GetProfessor
	 */
	
	
	@RequestMapping(produces = MediaType.APPLICATION_JSON, method = RequestMethod.GET, value = "/show-professor")
	@GetMapping("/show-professor")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Professor> GetProfessor() 
	{
		adminDaoSrv.Displayprofessor();
		return adminDaoSrv.GetProfessor();
	}
	
	
	/**path="/add-professor" for Add Professor Details
	 * Method professor call from AdminDaoService
	 * @param professor_id
	 * @param professor_name
	 * @param address
	 * @param course_name
	 * @param email
	 */
	
	
	@GetMapping(path="/add-professor/{professorid}/{professorname}/{address}/{coursename}/{email}")
	@Produces(MediaType.APPLICATION_JSON)
	public void addstudent(@PathVariable("professorid")int professor_id, @PathVariable("professorname") String professor_name,
			@PathVariable("address") String address, @PathVariable("coursename") String course_name, @PathVariable("email") String email)
	{
		adminDaoSrv.profesosr(professor_id, professor_name, address, course_name, email);
	}
	
	
	/**path="/create-course" for Add Professor Details
	 * Method course call from AdminDaoService
	 * @param course_id
	 * @param course_name
	 * @param course_grade
	 * @param course_type
	 * @param course_status
	 * @param course_fees
	 */
	
	
	@GetMapping(path = "/create-course/{courseid}/{coursename}/{coursegrade}/{coursetype}/{coursestatuse}/{coursefees}")	
	@Produces(MediaType.APPLICATION_JSON)
	public void CreateCourse(@PathVariable("courseid")int course_id, @PathVariable("coursename") String course_name,
			@PathVariable("coursegrade") String course_grade, @PathVariable("coursetype") String course_type, 
			@PathVariable("coursestatuse") String course_status,@PathVariable("coursefees") String course_fees)
	{
		adminDaoSrv.course(course_id, course_name, course_grade, course_type, course_status, course_fees);
	}
	
	
	@RequestMapping(produces = MediaType.APPLICATION_JSON, method = RequestMethod.GET, value = "/show-course")
	@GetMapping("/show-course")	
	public List GetCourse()
	{
		adminDaoSrv.displaycourse();
		return adminDaoSrv.GetCourse();
	}
	
	
	@RequestMapping(produces = MediaType.APPLICATION_JSON, method = RequestMethod.GET, value = "/show-payment")
	@GetMapping("/show-payment")	
	public List GetPayment()
	{
		adminDaoSrv.Displaypayment();
		return adminDaoSrv.GetPayment();
	}
	
	
	@RequestMapping(produces = MediaType.APPLICATION_JSON, method = RequestMethod.GET, value = "/show-newuser")
	@GetMapping("/show-newuser")	
	public List GetUser()
	{
		adminDaoSrv.Displaynewuser();
		return adminDaoSrv.GetUser();
	}	
	
	@RequestMapping(produces = MediaType.APPLICATION_JSON, method = RequestMethod.GET, value = "/check-student-payment/{studentid}")
	@GetMapping(path = "/check-student-payment/{studentid}")	
	public void ValidateStudentFees(@PathVariable("studentid") int student_id)
	{
		adminDaoSrv.student(student_id);
	}
	
	@RequestMapping(produces = MediaType.APPLICATION_JSON, method = RequestMethod.GET, value = "/admin-delete-course/{courseid}")
	@DeleteMapping(path="/admin-delete-course/{courseid}")
	@Produces(MediaType.APPLICATION_JSON)
	public void admindeletecourse(@PathVariable("courseid") int course_id)
	{
		adminDaoSrv.dropcourse(course_id);
	}	

	
	@RequestMapping(produces = MediaType.APPLICATION_JSON, method = RequestMethod.GET, value = "/login-approval/{userid}")
	@GetMapping("/login-approval/{userid}")	
	public void LoginAproval(@PathVariable("userid")String user_id)
	{
		adminDaoSrv.Admin_approval(user_id);
	}
	
}
