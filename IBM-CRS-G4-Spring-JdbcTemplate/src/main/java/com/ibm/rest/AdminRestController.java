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
import com.ibm.dao.StudentDaoService;

/**
 * @author 003OQX744
 *
 */
@RestController
@CrossOrigin
public class AdminRestController {
	
	@Autowired
	AdminDaoService admindaoservice;
	
	/**path="/add-professor" for Admin Add Professor Details
	 * Method profesosr call from AdminDaoService
	 * @param professor_id
	 * @param professor_name
	 * @param address
	 * @param course_name
	 * @param email
	 */
	
	@GetMapping(path="/add-professor/{professorid}/{professorname}/{address}/{coursename}/{email}")
	@Produces(MediaType.APPLICATION_JSON)
	public void addprofessor(@PathVariable("professorid")int professor_id, @PathVariable("professorname") String professor_name,
			@PathVariable("address") String address, @PathVariable("coursename") String course_name, @PathVariable("email") String email)
	{
		admindaoservice.profesosr(professor_id, professor_name, address, course_name, email);
	}
	
	/**path="/admin-delete-professor" for Delete Professor Details
	 * @return Method deleteprofessor call from AdminDaoService
	 * @param professor_id
	 */
	
	@RequestMapping(produces = MediaType.APPLICATION_JSON, method = RequestMethod.GET, value = "/admin-delete-professor/{professorid}")
	@DeleteMapping(path="/admin-delete-professor/{professorid}")
	@Produces(MediaType.APPLICATION_JSON)
	public void deleteprofessore(@PathVariable("professorid") int professor_id)			
	{
		admindaoservice.deleteprofessor(professor_id);
	}
	
	/**path="/show-professor" for Display Professor Details
	 * @return Method listprofessor call from AdminDaoService
	 */
	
	@RequestMapping(produces = MediaType.APPLICATION_JSON, method = RequestMethod.GET, value = "/show-professor")
	@GetMapping("/show-professor")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Professor> ListProfessor() 
	{
		return admindaoservice.listprofessor();
	}
	

	/**path="/delete-course" for Delete Course Details
	 * @return Method course call from AdminDaoService
	 * @param professor_id
	 */
	
	@GetMapping(path = "/add-course/{courseid}/{coursename}/{coursegrade}/{coursetype}/{coursestatuse}/{coursefees}")	
	@Produces(MediaType.APPLICATION_JSON)
	public void addCourse(@PathVariable("courseid")int course_id, @PathVariable("coursename") String course_name,
			@PathVariable("coursegrade") String course_grade, @PathVariable("coursetype") String course_type, 
			@PathVariable("coursestatuse") String course_status,@PathVariable("coursefees") int course_fees)
	{
		admindaoservice.course(course_id, course_name, course_grade, course_type, course_status, course_fees);
	}
	
	/**path="/admin-delete-course" for Admin Delete course Details
	 * @return Method deletecourse call from AdminDaoService
	 * @param course_id
	 */
	
	@RequestMapping(produces = MediaType.APPLICATION_JSON, method = RequestMethod.GET, value = "/admin-delete-course/{courseid}")
	@DeleteMapping(path="/admin-delete-course/{courseid}")
	@Produces(MediaType.APPLICATION_JSON)
	public void deletecourse(@PathVariable("courseid") int course_id)			
	{
		admindaoservice.deletecourse(course_id);
	}
	
	/**path="/show-professor" for Display course Details
	 * @return Method listcourse call from AdminDaoService
	 */
	
	@RequestMapping(produces = MediaType.APPLICATION_JSON, method = RequestMethod.GET, value = "/show-course")
	@GetMapping("/show-course")	
	public List ListCourse()
	{
		return admindaoservice.listcourse();
	}
	
	/**path="/updatestudpayment" for Admin Give Student Payment Approval
	 * @return Method UpdateStudPayment call from AdminDaoService
	 * @param student_id
	 * @param admin_approval
	 */
	
	@GetMapping(path="/updatestudpayment/{studentid}/{adminapproval}")
	@Produces(MediaType.APPLICATION_JSON)
	public void updateresult(@PathVariable("studentid")int student_id, @PathVariable("adminapproval") String admin_approval)
	{
		admindaoservice.UpdateStudPayment(student_id, admin_approval);
	}
	
	/**path="/show-payment" for Display Payment Details
	 * @return Method listpayment call from AdminDaoService
	 */
	
	@RequestMapping(produces = MediaType.APPLICATION_JSON, method = RequestMethod.GET, value = "/show-payment")
	@GetMapping("/show-payment")	
	public List Listpyment()
	{
		return admindaoservice.listpayment();
	}
	

	/**path="/adminapprovaluser" for Admin Give Login Approval to User
	 * @return Method AdminApprovalUser call from AdminDaoService
	 * @param user_id
	 * @param admin_approval
	 */
	
	@GetMapping(path="/adminapprovaluser/{userid}/{adminapproval}")
	@Produces(MediaType.APPLICATION_JSON)
	public void updateuser(@PathVariable("userid")String user_id, @PathVariable("adminapproval") int admin_approval)
	{
		admindaoservice.AdminApprovalUser(user_id, admin_approval);
	}
	
	/**path="/show-user" for Display User Details
	 * @return Method listuser call from AdminDaoService
	 */
	
	@RequestMapping(produces = MediaType.APPLICATION_JSON, method = RequestMethod.GET, value = "/show-user")
	@GetMapping("/show-user")	
	public List ListUser()
	{
		return admindaoservice.listuser();
	}

}
