/**
 * 
 */
package com.ibm.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.ibm.bean.Payment;


/**
 * @author 003OQX744
 *
 */
public class PaymentMapper implements RowMapper<Payment>{
	
	@Override
	public Payment mapRow(ResultSet rs, int rowNum) throws SQLException 
	{
		Payment payment = new Payment();
		payment.setPayment_mode(rs.getString("payment_mode"));;
		payment.setCard_no(rs.getLong("card_no"));;
		payment.setStudent_id(rs.getInt("student_id"));
		payment.setCourse_id(rs.getInt("course_id"));
		payment.setAmount(rs.getInt("amount"));
		payment.setAdmin_approval(rs.getString("admin_approval"));
		return payment;
	}

}
