package edu.ust.model;

public class DBConfigurationBean {

	private String driver;
	private String userName;
	private String password;
	private String port;
	private String jdbcPartURL;
	private String server;
	private String database;
	
	public String getDriver() {
		return driver;
	}
	public void setDriver(String driver) {
		this.driver = driver;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getPort() {
		return port;
	}
	public void setPort(String port) {
		this.port = port;
	}
	public String getJdbcPartURL() {
		return jdbcPartURL;
	}
	public void setJdbcPartURL(String jdbcPartURL) {
		this.jdbcPartURL = jdbcPartURL;
	}
	public String getServer() {
		return server;
	}
	public void setServer(String server) {
		this.server = server;
	}
	public String getDatabase() {
		return database;
	}
	public void setDatabase(String database) {
		this.database = database;
	}
}
