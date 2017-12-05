package edu.ust.helper;

import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.*;

import edu.ust.model.DBConfigurationBean;

public class DBUtility {
	
	public void createXMLDatabaseConfiguration() {
		DBConfigurationBean connectionBean = new DBConfigurationBean();
		connectionBean.setDatabase("CJ_DATABASE");
		connectionBean.setDriver("net.sourceforge.jtds.jdbc.Driver");
		connectionBean.setJdbcPartURL("jdbc:jtds:sqlserver://");
		connectionBean.setPassword("1234");
		connectionBean.setPort("1433");
		connectionBean.setServer("127.0.0.1");
		connectionBean.setUserName("admin");
		
		//now create the XML file
		try {
			XMLEncoder encoder = new XMLEncoder(
	                 new BufferedOutputStream(
	                     new FileOutputStream("C:\\XML\\STUDENT.xml")));
			encoder.writeObject(connectionBean);
			encoder.close();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	public DBConfigurationBean getConnectionBean() {
		//now reading the content of the XML file 
		DBConfigurationBean connectionBean = null;
		
		try {
		   XMLDecoder decoder = new XMLDecoder(
			   new BufferedInputStream(
			   new FileInputStream("C:\\XML\\STUDENT.xml")));
		   connectionBean = (DBConfigurationBean)decoder.readObject();
		   decoder.close();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return connectionBean;
	}
}
