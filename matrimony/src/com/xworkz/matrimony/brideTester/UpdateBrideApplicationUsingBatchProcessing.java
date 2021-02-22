package com.xworkz.matrimony.brideTester;

import java.util.ArrayList;
import java.util.List;

import com.xworkz.matrimony.dao.MatrimonyDAO;
import com.xworkz.matrimony.dao.MatrimonyDAOImpl;
import com.xworkz.matrimony.dto.BrideDTO;
import com.xworkz.matrimony.service.MatrimonyService;
import com.xworkz.matrimony.service.MatrimonyServiceImpl;

public class UpdateBrideApplicationUsingBatchProcessing {

	public static void main(String[] args) {
		BrideDTO brideDTO = new BrideDTO();
		brideDTO.setId(7);
		brideDTO.setName("Vidhya");
		brideDTO.setAge(22);
		brideDTO.setHeight(5.2);
		brideDTO.setWeight(53);
		brideDTO.setQualification("BE");
		brideDTO.setPhone_Number("9325551225");
		brideDTO.setSalary(100000);
		brideDTO.setOccupation("java developer");
		brideDTO.setAddress("Yelankha");
		brideDTO.setExpectations("Good behaviour");

		BrideDTO brideDTO1 = new BrideDTO();
		brideDTO1.setId(8);
		brideDTO1.setName("Pranthanthi");
		brideDTO1.setAge(22);
		brideDTO1.setHeight(5.2);
		brideDTO1.setWeight(53);
		brideDTO1.setQualification("BE");
		brideDTO1.setPhone_Number("9325551225");
		brideDTO1.setSalary(90000);
		brideDTO1.setOccupation("java developer");
		brideDTO1.setAddress("Chintamani");
		brideDTO1.setExpectations("Good behaviour");

		MatrimonyDAO matrimonyDAO = new MatrimonyDAOImpl();
		MatrimonyService service = new MatrimonyServiceImpl(matrimonyDAO);
		List<BrideDTO> brideDTOs = new ArrayList<BrideDTO>();
		brideDTOs.add(brideDTO);
		brideDTOs.add(brideDTO1);

		int[] results = service.validateAndUpdateBrides(brideDTOs);
		for (int i = 0; i <results.length; i++) {
			if (results[i] == 0) {
				System.out.println("Failed to update");
			} else {
				System.out.println("updated successfully");
			}
		}
	}
}