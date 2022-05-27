/**
 * 
 */
package com.crs.ibm.exception;

import java.sql.SQLException;

/**
 * @author 003OQX744
 *
 */
public class NotRemoved  extends SQLException{
	public NotRemoved() {
		super("Course was not removed, please enter correct course_id");
	}
	public NotRemoved(String message)
	{
		super(message);
	}

}
