package com.xworkz.matrimony.groomTester;

import java.util.ArrayList;
import java.util.List;

import com.xworkz.matrimony.dao.MatrimonyDAO;
import com.xworkz.matrimony.dao.MatrimonyDAOImpl;
import com.xworkz.matrimony.dto.GroomDTO;
import com.xworkz.matrimony.service.MatrimonyService;
import com.xworkz.matrimony.service.MatrimonyServiceImpl;

public class UpdateGroomByIdApplication {

	public static void main(String[] args) {
		MatrimonyDAO dao = new MatrimonyDAOImpl();
		MatrimonyService service = new MatrimonyServiceImpl(dao);
		GroomDTO dto = new GroomDTO();
		dto.setGroom_id(13);;

		dto.setPhone_Number("9325551225");

		int result = service.validateAndUpdatePhonenumberById("7019347955", 6);
		if (result == 1) {
			System.out.println("phonenumber updated successfully");
		} else {
			System.out.println("failed to update");
		}
	}

}
