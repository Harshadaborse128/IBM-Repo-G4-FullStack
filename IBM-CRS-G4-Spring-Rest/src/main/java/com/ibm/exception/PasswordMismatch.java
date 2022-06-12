/**
 * 
 */
package com.ibm.exception;

import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

/**
 * @author 003OQX744
 *
 */
public class PasswordMismatch extends Exception {
	public PasswordMismatch() {
		super("Password Mismatch..");
	}
	public PasswordMismatch(String message) {
		super(message);
	}
	

}
