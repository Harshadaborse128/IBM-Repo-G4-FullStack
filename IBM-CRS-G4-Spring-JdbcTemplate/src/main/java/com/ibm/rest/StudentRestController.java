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

import com.ibm.bean.NewCourse;
import com.ibm.bean.Student;
import com.ibm.dao.StudentDaoService;

/**
 * @author 003OQX744
 *
 */

@RestController
@CrossOrigin
public class StudentRestController {
	
	@Autowired
	StudentDaoService studentdaoservice;
	

	/**path="/show-student" for Display student Details
	 * @return Method liststudent call from StudentDaoService
	 */
	
	@RequestMapping(produces = MediaType.APPLICATION_JSON, method = RequestMethod.GET, value = "/show-student")
	@GetMapping("/show-student")	
	public List<Student> liststudent() 
	{
		return studentdaoservice.liststudent();
	}
	

	/**path="/add-student" for Add Student Details
	 * Method addstudents call from StudentDaoService
	 * @param student_id
	 * @param student_name
	 * @param address
	 * @param course_name
	 * @param email
	 */
	
	@GetMapping(path="/add-student/{studentid}/{studentname}/{address}/{coursename}/{email}")
	@Produces(MediaType.APPLICATION_JSON)
	public void addstudent(@PathVariable("studentid")int student_id, @PathVariable("studentname") String student_name,
			@PathVariable("address") String address, @PathVariable("coursename") String course_name, @PathVariable("email") String email)
	{
		studentdaoservice.addstudents(student_id, student_name, address, course_name, email);
	}
	
	/**path="/add-course" for Student Add Course Details
	 * Method Addcourse call from StudentDaoService
	 * @param course_id
	 * @param course_name
	 * @param student_id
	 */
	
	@GetMapping(path="/add-course/{courseid}/{coursename}/{studentid}")
	@Produces(MediaType.APPLICATION_JSON)
	public void addcourse(@PathVariable("courseid") int course_id, @PathVariable("coursename") String course_name, 
			@PathVariable("studentid") int student_id)
	{
		studentdaoservice.Addcourse(course_id, course_name, student_id);
	}	
	

	/**path="/show-student" for Display Student RegistercourseDetails
	 * @return Method listsregistercourse call from StudentDaoService
	 */	
	
	@RequestMapping(produces = MediaType.APPLICATION_JSON, method = RequestMethod.GET, value = "/show-registercourse")
	@GetMapping("/show-registercourse")	
	public List<NewCourse> listsregistercourse() 
	{
		return studentdaoservice.listsregistercourse();
	}
	
	/**path="/delete-course" for Student Delete Course Details
	 * Method deletecourse call from StudentDaoService
	 * @param course_id
	 */
	
	@RequestMapping(produces = MediaType.APPLICATION_JSON, method = RequestMethod.GET, value = "/delete-course/{courseid}")
	@DeleteMapping(path="/delete-course/{courseid}")
	@Produces(MediaType.APPLICATION_JSON)
	public void deletecourse(@PathVariable("courseid") int course_id)			
	{
		studentdaoservice.deletecourse(course_id);
	}
	
	/**path="/add-payment" for Student Add Payment Details
	 * Method Payment call from StudentDaoService
	 * @param payment_mode
	 * @param card_no
	 * @param student_id
	 * @param course_id
	 * @param amount
	 */
	
	@GetMapping(path="/add-payment/{paymentmode}/{cardno}/{studentid}/{courseid}/{amount}")
	@Produces(MediaType.APPLICATION_JSON)
	public void addpayment(@PathVariable("paymentmode") String payment_mode, @PathVariable("cardno") long card_no, 
			@PathVariable("studentid") int student_id, @PathVariable("courseid") int course_id, 
			@PathVariable("amount") int amount)
	{
		studentdaoservice.Payment(payment_mode, card_no, student_id, course_id, amount, "0");
	}

}
