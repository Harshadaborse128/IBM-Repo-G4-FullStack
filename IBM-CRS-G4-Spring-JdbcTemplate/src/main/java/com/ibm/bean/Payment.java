/**
 * 
 */
package com.ibm.bean;

/**
 * @author 003OQX744
 *
 */
public class Payment {
	
	private String payment_mode;
	private long card_no;
	private int student_id;
	private int course_id;
	private int amount;
	private String admin_approval;
	
	public String getPayment_mode() {
		return payment_mode;
	}
	public void setPayment_mode(String payment_mode2) {
		this.payment_mode = payment_mode2;
	}
	public long getCard_no() {
		return card_no;
	}
	public void setCard_no(long card_no) {
		this.card_no = card_no;
	}
	public int getStudent_id() {
		return student_id;
	}
	public void setStudent_id(int student_id) {
		this.student_id = student_id;
	}
	public int getCourse_id() {
		return course_id;
	}
	public void setCourse_id(int course_id) {
		this.course_id = course_id;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	public String getAdmin_approval() {
		return admin_approval;
	}
	public void setAdmin_approval(String admin_approval) {
		this.admin_approval = admin_approval;
	}
	
	
	@Override
	public String toString() {
		return "Payment[payment_mode = "+ payment_mode +", card_no = "+ card_no +", student_id = "+ student_id +",course_id = " + course_id +",amount = "+ amount +",admin_approval = "+ admin_approval +"]";
	}


}
