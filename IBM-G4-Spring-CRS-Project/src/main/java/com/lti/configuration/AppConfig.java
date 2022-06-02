/**
 * 
 */
package com.lti.configuration;

import org.springframework.context.annotation.Import;

/**
 * @author 003OQX744
 *
 */
@Import({AdminConfig.class,ProfessorConfig.class,StudentConfig.class,UserConfig.class})
public class AppConfig {

}
