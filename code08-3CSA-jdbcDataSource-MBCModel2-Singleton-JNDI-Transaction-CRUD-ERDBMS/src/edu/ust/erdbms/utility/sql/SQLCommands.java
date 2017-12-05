package edu.ust.erdbms.utility.sql;

public interface SQLCommands {

	String INSERT_STUDENT = "insert into Student(ID, LASTNAME, FIRSTNAME, YEARLEVEL, COURSE) values(?,?,?,?,?)";
	String GET_ALL_STUDENTS = "select * from student";
	
	String SEARCH_STUDENT = "select * from student where ID=?";
	String UPDATE_STUDENT = "update Student set LASTNAME = ?, FIRSTNAME = ?, YEARLEVEL=?, COURSE=? where ID = ?";
	
	String DELETE_STUDENT = "delete from Student where ID=?";
}
