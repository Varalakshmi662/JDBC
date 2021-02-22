package com.xworkz.matrimony.constants;

public class ConstantsURL {
	public static final String DB_URL="jdbc:mysql://localhost:3306";
	public static final String USER_NAME="root";
	public static final String PASSWORD="root";
	
	// string format constants
	public static final String INSERT_QUERY="insert into matrimony.bride values(%s,'%s',%s,%s,%s,'%s','%s',%s,'%s','%s','%s')";
	public static final String UPDATE_QUERY="update matrimony.bride set Qualification=?,Salary=? where id=?";
	public static final String DELETE_QUERY="delete from matrimony.bride where id=?";
	
	
}
