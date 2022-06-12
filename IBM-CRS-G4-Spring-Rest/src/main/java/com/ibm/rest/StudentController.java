/**
 * 
 */
package com.ibm.rest;

import java.util.List;

import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.ibm.bean.Student;
import com.ibm.dao.AdminDaoService;
import com.ibm.dao.StudentDaoService;
import com.ibm.exception.UserNotFound;

/**
 * @author 003OQX744
 *
 */
@RestController
@CrossOrigin
public class StudentController {
	
	@Autowired
	private StudentDaoService StudentDaoSrv;

	@RequestMapping(produces = MediaType.APPLICATION_JSON, method = RequestMethod.GET, value = "/show-student")
	@GetMapping("/show-student")
	@Produces(MediaType.APPLICATION_JSON)
	
	public List<Student> GetStudent() 
	{
		StudentDaoSrv.displaystudent(); //Create List of students and appends student info one by one
		return StudentDaoSrv.GetStudents();
	}
	
	
	@GetMapping(path="/add-student/{studentid}/{studentname}/{address}/{coursename}/{email}")
	@Produces(MediaType.APPLICATION_JSON)
	public void addstudent(@PathVariable("studentid")int student_id, @PathVariable("studentname") String student_name,
			@PathVariable("address") String address, @PathVariable("coursename") String course_name, @PathVariable("email") String email)
	{
		StudentDaoSrv.addstudents(student_id, student_name, address, course_name, email);
	}
	
	
	@GetMapping(path="/add-course/{courseid}/{coursename}/{studentid}")
	@Produces(MediaType.APPLICATION_JSON)
	public void addcourse(@PathVariable("courseid") int course_id, @PathVariable("coursename") String course_name, 
			@PathVariable("studentid") int student_id)
	{
		StudentDaoSrv.Addcourse(course_id, course_name, student_id);
	}	
	
	@RequestMapping(produces = MediaType.APPLICATION_JSON, method = RequestMethod.GET, value = "/delete-course/{courseid}")
	@DeleteMapping(path="/delete-course/{courseid}")
	@Produces(MediaType.APPLICATION_JSON)
	public void deletecourse(@PathVariable("courseid") int course_id)			
	{
		StudentDaoSrv.deletecourse(course_id);
	}
	
	@GetMapping(path="/add-payment/{paymentmod}/{cardno}/{studentid}/{courseid}/{amount}")
	@Produces(MediaType.APPLICATION_JSON)
	public void addpayment(@PathVariable("paymentmod") String payment_mode, @PathVariable("cardno") long card_no, 
			@PathVariable("studentid") int student_id, @PathVariable("courseid") int course_id, @PathVariable("amount") int amount)
	{
		StudentDaoSrv.Payment(payment_mode, card_no, student_id, course_id, amount);
	}
}
