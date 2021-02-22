package com.xworkz.matrimony.brideTester;

import java.util.ArrayList;
import java.util.List;

import com.xworkz.matrimony.dao.MatrimonyDAO;
import com.xworkz.matrimony.dao.MatrimonyDAOImpl;
import com.xworkz.matrimony.dto.BrideDTO;
import com.xworkz.matrimony.service.MatrimonyService;
import com.xworkz.matrimony.service.MatrimonyServiceImpl;

public class ManipulateBrideApplication {

	public static void main(String[] args) {
		BrideDTO bride=new BrideDTO();
		bride.setId(7);
		bride.setName("Mamtha");
		bride.setAge(24);
		bride.setHeight(5.2);
		bride.setWeight(53);
		bride.setQualification("BE");
		bride.setPhone_Number("9325551225");
		bride.setSalary(72000);
		bride.setOccupation("java developer");
		bride.setAddress("Ramdurg");
		bride.setExpectations("no current existing loans");
		
		BrideDTO bride1=new BrideDTO();
		bride1.setId(8);
		bride1.setName("Nagashree");
		bride1.setAge(22);
		bride1.setHeight(5.2);
		bride1.setWeight(53);
		bride1.setQualification("BE");
		bride1.setPhone_Number("9325551225");
		bride1.setSalary(80000);
		bride1.setOccupation("java developer");
		bride1.setAddress("jayanagar");
		bride1.setExpectations("6 feet height");
		
		
		MatrimonyDAO dao=new MatrimonyDAOImpl();
		MatrimonyService service=new MatrimonyServiceImpl(dao);
		List<BrideDTO> brideDTOs=new ArrayList<BrideDTO>();
		brideDTOs.add(bride);
		brideDTOs.add(bride1);
		
		int[] results=service.validateAndInsertBride(brideDTOs);
		for (int i = 0; i < results.length; i++) {
			if(results[i]==0) {
				System.out.println(brideDTOs.get(i).getName()+"the bride failed to create");
			}else {
				System.out.println(brideDTOs.get(i).getName()+"the bride succeded to create");
			}
		}
		
	}

}
