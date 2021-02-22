package com.xworkz.matrimony.dao;

import java.util.List;
import com.xworkz.matrimony.dto.BrideDTO;
import com.xworkz.matrimony.dto.GroomDTO;

public interface MatrimonyDAO {
	public BrideDTO getById(int id);
	
	public List<BrideDTO> getAllBride();
	public int create(BrideDTO bride);
	public int updatePhone_NumberById(String phone_number, int id);
	public int deleteById(int id);
	public int[] insertBrides(List<BrideDTO> brideDTOs);
	public int[] updateBrides(List<BrideDTO> bride);
	public int[] deleteIds(List<Integer> ids);
	
	
	public int create(GroomDTO groom);
	public int[] insertGrooms(List<GroomDTO> groomDTOs);
	public int updatePhoneNumberById(String phone_number, int id);
	public int deleteByGroomId(int id);
}
