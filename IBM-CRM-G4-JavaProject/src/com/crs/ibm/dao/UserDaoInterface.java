/**
 * 
 */
package com.crs.ibm.dao;

/**
 * @author 003OQX744
 *
 */
public interface UserDaoInterface {
	/**
	 * @param args
	 */
	public Boolean IsLoginSuccessful(int iUser_type, String iUser_id,String iPassword);
	public void login();
	public void registrationlogin();
	public Boolean ChangePassword(int iUser_Type, String iUser_id,String iPassword);
}
