package com.xworkz.matrimony.brideTester;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.xworkz.matrimony.dto.BrideDTO;

public class GetAllBrideApplication {

	public static void main(String[] args) {

		Connection connection = null;
		try {
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306", "root", "root");
			Statement stmt = connection.createStatement();
			ResultSet resultSet = stmt.executeQuery("select * from matrimony.bride");
			List<BrideDTO> dto = new ArrayList<BrideDTO>();
			while (resultSet.next()) {
				BrideDTO brideDTO = new BrideDTO();
				brideDTO.setId(resultSet.getInt(1));
				brideDTO.setName(resultSet.getString(2));
				brideDTO.setAge(resultSet.getInt(3));
				brideDTO.setHeight(resultSet.getDouble(4));
				brideDTO.setWeight(resultSet.getDouble(5));
				brideDTO.setQualification(resultSet.getString(6));
				brideDTO.setPhone_Number(resultSet.getString(7));
				brideDTO.setSalary(resultSet.getDouble(8));
				brideDTO.setOccupation(resultSet.getString(9));
				brideDTO.setAddress(resultSet.getString(10));
				brideDTO.setExpectations(resultSet.getString(11));
				dto.add(brideDTO);
			}
			for (BrideDTO brideDTO2 : dto) {
				System.out.println(brideDTO2);
			}
		}

		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
//	1st step load and the register to db

	// the load and the register to db
	// it will getting exception classNotfoundException
//	try {

	// we not need this class bcz SPI will automatically load the class

//		Class.forName("com.mysql.jdbc.Driver");
//		System.out.println("Driver loaded successfully.......");
//	} catch (ClassNotFoundException e) {
//		e.printStackTrace();

//	2nd step establish the connection and we connect with mysql db.
	// it throws an exceptions

}
