package com.xworkz.matrimony.brideTester;

import com.xworkz.matrimony.dao.MatrimonyDAO;
import com.xworkz.matrimony.dao.MatrimonyDAOImpl;
import com.xworkz.matrimony.dto.BrideDTO;
import com.xworkz.matrimony.service.MatrimonyService;
import com.xworkz.matrimony.service.MatrimonyServiceImpl;

public class CreateBrideApplication {

	public static void main(String[] args) {
		
		MatrimonyDAO dao=new MatrimonyDAOImpl();
		MatrimonyService service=new MatrimonyServiceImpl(dao);
		BrideDTO brideDTO=new BrideDTO();
		brideDTO.setId(7);
		brideDTO.setName("Mamtha");
		brideDTO.setAge(24);
		brideDTO.setHeight(5.2);
		brideDTO.setWeight(53);
		brideDTO.setQualification("BE");
		brideDTO.setPhone_Number("9325551225");
		brideDTO.setSalary(72000);
		brideDTO.setOccupation("java developer");
		
		int result=service.validateAndCreateBride(brideDTO);
		if(result==1) {
			System.out.println("Bride created successfully");
		}else {
			System.out.println("failed to create");
		}
	}

}
