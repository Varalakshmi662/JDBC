package com.xworkz.matrimony.groomTester;

import com.xworkz.matrimony.dao.MatrimonyDAO;
import com.xworkz.matrimony.dao.MatrimonyDAOImpl;
import com.xworkz.matrimony.dto.GroomDTO;
import com.xworkz.matrimony.service.MatrimonyService;
import com.xworkz.matrimony.service.MatrimonyServiceImpl;

public class CreateGroomApplication {

	public static void main(String[] args) {
		MatrimonyDAO dao=new MatrimonyDAOImpl();
		MatrimonyService service=new MatrimonyServiceImpl(dao);
		GroomDTO dto=new GroomDTO();
		dto.setGroom_id(14);;
		dto.setName("shiva prakash");
		dto.setAge(24);
		dto.setHeight(6);
		dto.setWeight(53);
		dto.setQualification("ITI");
		dto.setPhone_Number("9325551225");
		dto.setSalary(72000);
		dto.setOccupation("java developer");
		
		int result=service.validateAndCreateGroom(dto);
		if(result==1) {
			System.out.println("Groom created successfully");
		}else {
			System.out.println("failed to create");
		}
	}

}
