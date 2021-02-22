package com.xworkz.matrimony.brideTester;

import java.util.ArrayList;
import java.util.List;
import com.xworkz.matrimony.dao.MatrimonyDAO;
import com.xworkz.matrimony.dao.MatrimonyDAOImpl;
import com.xworkz.matrimony.dto.BrideDTO;
import com.xworkz.matrimony.service.MatrimonyService;
import com.xworkz.matrimony.service.MatrimonyServiceImpl;

public class DeleteBrideByIdApplicationUsingBatch {

	public static void main(String[] args) {
		MatrimonyDAO matrimonyDAO = new MatrimonyDAOImpl();
		MatrimonyService service = new MatrimonyServiceImpl(matrimonyDAO);
		List<Integer> id=new ArrayList<Integer>();
		id.add(7);
		id.add(2);
		int[] result = service.validateAndDeleteIds(id);
		for (int i = 0; i <result.length; i++) {
			if (result[i] == 0) {
				System.out.println(result[i]+ "Failed to delete");
			} else {
				System.out.println(result[i]+ "deleted successfully");
			}
		}

	}

}
