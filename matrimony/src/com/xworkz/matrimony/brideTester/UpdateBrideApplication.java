package com.xworkz.matrimony.brideTester;

import com.xworkz.matrimony.dao.MatrimonyDAO;
import com.xworkz.matrimony.dao.MatrimonyDAOImpl;
import com.xworkz.matrimony.dto.BrideDTO;
import com.xworkz.matrimony.service.MatrimonyService;
import com.xworkz.matrimony.service.MatrimonyServiceImpl;

public class UpdateBrideApplication {
	public static void main(String[] args) {
		MatrimonyDAO dao=new MatrimonyDAOImpl();
		MatrimonyService service=new MatrimonyServiceImpl(dao);
		BrideDTO brideDTO=new BrideDTO();
		brideDTO.setId(6);
		
		brideDTO.setPhone_Number("9325551225");
		
		
		int result=service.validateAndUpdatePhonenumberById("7019347955", 6);
		if(result==1) {
			System.out.println("phonenumber updated successfully");
		}else {
			System.out.println("failed to update");
		}

	}
	
}
