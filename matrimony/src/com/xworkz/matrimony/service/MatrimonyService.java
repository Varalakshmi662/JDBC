package com.xworkz.matrimony.service;

import java.util.List;

import com.xworkz.matrimony.dto.BrideDTO;
import com.xworkz.matrimony.dto.GroomDTO;

public interface MatrimonyService {
	public BrideDTO getBride(int id);

	public List<BrideDTO> getAllBride();
	public int validateAndCreateBride(BrideDTO bride);
	public int validateAndUpdatePhonenumberById(String phonenumber,int id);
	public int validateAnddeleteById(int id);
	public int[] validateAndInsertBride(List<BrideDTO> brides);
	public int[] validateAndUpdateBrides(List<BrideDTO> brideDTOs);
	public int[] validateAndDeleteIds(List<Integer> ids);
	
	public int validateAndCreateGroom(GroomDTO groom);
	public int[] validateAndInsertGroom(List<GroomDTO> groomDTOs);
	public int validateAndUpdatePhoneNumberById(String phonenumber,int id);
	public int validateAndDelete(int id);
}