/**
 * 
 */
package com.ibm.dao;

/**
 * @author 003OQX744
 *
 */
public interface UserDaoInterface {
	
	public Boolean IsLoginSuccessful(int iUser_type, String iUser_id,String iPassword);
	public void registrationlogin(int user_type, String user_id, String user_pass);
	public Boolean ChangePassword(int iUser_Type, String iUser_id,String iPassword, String new_pass);

}
