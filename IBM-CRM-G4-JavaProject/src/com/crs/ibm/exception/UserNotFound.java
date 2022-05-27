/**
 * 
 */
package com.crs.ibm.exception;

/**
 * @author 003OQX744
 *
 */
public class UserNotFound  extends Exception{
	public UserNotFound() {
		super("User not found.....");
	}
	public UserNotFound(String message) {
		super(message);
	}
	/*public static String UserNotFound() {
		return"User not found";
	}*/
}
