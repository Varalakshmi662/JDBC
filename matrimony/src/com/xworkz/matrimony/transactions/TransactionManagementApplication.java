package com.xworkz.matrimony.transactions;

import static com.xworkz.matrimony.constants.ConstantsURL.DB_URL;
import static com.xworkz.matrimony.constants.ConstantsURL.PASSWORD;
import static com.xworkz.matrimony.constants.ConstantsURL.USER_NAME;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Savepoint;
import java.sql.Statement;

public class TransactionManagementApplication {

	public static void main(String[] args) {
		Connection con=null;
		Savepoint savepoint=null;
		try {
			con=DriverManager.getConnection(DB_URL,USER_NAME,PASSWORD);
			con.setAutoCommit(false);
			Statement stmt=con.createStatement();
			String Query1="insert into matrimony.bride values(2,'Naheeda',21,5.1,40,'BE','7259929818',5000,'Business','Jamkandi','He must be business man')";
			String Query2="insert into matrimony.bride values(3,'prathyusha',22,5.1,38,'BE','9995632774',80000,'Software Engineer','Jamkandi','He should be smart')";
			String Query3="update matrimony.bride set Expectations='full stack developer' where id=2";
			String Query4="delete from matrimony.bride where id =5";
			stmt.executeUpdate(Query1);
			savepoint=con.setSavepoint();
			stmt.executeUpdate(Query2);
			stmt.executeUpdate(Query3);
			stmt.executeUpdate(Query4);
			System.out.println("Success");
			con.commit();
		} catch (Exception e) {
			e.printStackTrace();
			try {
				System.out.println("Rolling back all the queries....");
//				con.rollback();
				con.rollback(savepoint);
				con.commit();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		// closing the connection bcz, we are not using try with resource so externally we have to close the connection using finally block
		finally {
			try {
				
			} catch (Exception e2) {
				// TODO: handle exception
			}
		}
	}

}
