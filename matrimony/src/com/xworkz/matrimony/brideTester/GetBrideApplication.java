package com.xworkz.matrimony.brideTester;

import com.xworkz.matrimony.dao.MatrimonyDAO;
import com.xworkz.matrimony.dao.MatrimonyDAOImpl;
import com.xworkz.matrimony.dto.BrideDTO;
import com.xworkz.matrimony.service.MatrimonyService;
import com.xworkz.matrimony.service.MatrimonyServiceImpl;

public class GetBrideApplication {

	public static void main(String[] args) {
		MatrimonyDAO matrimonyDAO = new MatrimonyDAOImpl();
		MatrimonyService matrimonyService=new MatrimonyServiceImpl(matrimonyDAO);
		BrideDTO bride=matrimonyService.getBride(2);
		
//		if(bride!=null) {
//			System.out.println(bride);
//		}
		
		System.out.println("***********************");
//		List<BrideDTO> brides=matrimonyService.getAllBride();
//		for (BrideDTO brideDTO : brides) {
//			System.out.println(brideDTO);
//		}
		
		// using lambda expression
//		List<BrideDTO> brides=matrimonyService.getAllBride();
//		brides.forEach(e->System.out.println(e));
	}
}
