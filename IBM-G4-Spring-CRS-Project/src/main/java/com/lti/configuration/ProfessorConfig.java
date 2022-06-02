/**
 * 
 */
package com.lti.configuration;

import org.springframework.context.annotation.Bean;

import com.lti.services.ProfessorInterface;
import com.lti.services.ProfessorService;

/**
 * @author 003OQX744
 *
 */
public class ProfessorConfig {
	@Bean(name="ProfessorBean")
	public ProfessorInterface professorInteface() 
	{
		return new ProfessorService();
	}

}
