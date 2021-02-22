package com.xworkz.matrimony.groomTester;

import java.util.ArrayList;
import java.util.List;

import com.xworkz.matrimony.dao.MatrimonyDAO;
import com.xworkz.matrimony.dao.MatrimonyDAOImpl;
import com.xworkz.matrimony.dto.GroomDTO;
import com.xworkz.matrimony.service.MatrimonyService;
import com.xworkz.matrimony.service.MatrimonyServiceImpl;

public class InsertGroomApplication {

	public static void main(String[] args) {
		MatrimonyDAO matrimonyDAO=new MatrimonyDAOImpl();
		MatrimonyService service=new MatrimonyServiceImpl(matrimonyDAO);
		GroomDTO dto=new GroomDTO();
		dto.setGroom_id(15);;
		dto.setName("shiva prakash");
		dto.setAge(24);
		dto.setHeight(6);
		dto.setWeight(53);
		dto.setQualification("ITI");
		dto.setPhone_Number("9325551225");
		dto.setSalary(72000);
		dto.setOccupation("java developer");
		dto.setAddress("Oolvadi");
		dto.setExpectations("Good Nature");
		
		
		GroomDTO dto1=new GroomDTO();
		dto1.setGroom_id(16);;
		dto1.setName("shiva prakash");
		dto1.setAge(24);
		dto1.setHeight(6);
		dto1.setWeight(53);
		dto1.setQualification("ITI");
		dto1.setPhone_Number("9325551225");
		dto1.setSalary(72000);
		dto1.setOccupation("java developer");
		dto1.setAddress("Kaivara");
		dto1.setExpectations("Helping Nature");

		List<GroomDTO> groomDTOs=new ArrayList<GroomDTO>();
		int[] result=service.validateAndInsertGroom(groomDTOs);
		for (int i = 0; i <result.length; i++) {
		if(result[i]==1) {
			System.out.println("Groom inserted successfully");
		}else {
			System.out.println("failed to insert");
		}

	}
}
}
