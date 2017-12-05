package edu.ust.erdbms.utility;

import edu.ust.erdbms.model.StudentBean;

public class BeanFactory {
	
	public static StudentBean getFactoryBean(String id, String lastName, 
		String firstName, String yearLevel, 
		String course) {
		
		StudentBean employee = new StudentBean();
		employee.setID(id);
		employee.setLastName(lastName);
		employee.setFirstName(firstName);
		employee.setYearLevel(yearLevel);
		employee.setCourse(course);
		return employee;
	}
}
