package com.xworkz.matrimony.service;

import java.util.List;
import com.xworkz.matrimony.dao.MatrimonyDAO;
import com.xworkz.matrimony.dto.BrideDTO;
import com.xworkz.matrimony.dto.GroomDTO;

public class MatrimonyServiceImpl implements MatrimonyService {
	MatrimonyDAO matrimonyDAO;

	public MatrimonyServiceImpl(MatrimonyDAO matrimonyDAO) {
		this.matrimonyDAO = matrimonyDAO;
	}

	public BrideDTO getBride(int id) {
		if (id == 0) {
			System.out.println("invalid id");
			return null;
		}
		return matrimonyDAO.getById(id);
	}

	@Override
	public List<BrideDTO> getAllBride() {

		return matrimonyDAO.getAllBride();
	}

	@Override
	public int validateAndCreateBride(BrideDTO bride) {
		if (null == bride) {
			System.out.println("bride cannot be null");
			return 0;
		} else if (bride.getId() == 0) {
			System.out.println("bride id cannot be 0");
			return 0;
		} else {
			return matrimonyDAO.create(bride);
		}
	}

	@Override
	public int validateAndUpdatePhonenumberById(String phonenumber, int id) {
		int res = 0;
		if (id != 0 && phonenumber != null && phonenumber.length() >= 10) {
			res = matrimonyDAO.updatePhone_NumberById(phonenumber, id);
			System.out.println("can update phone number");
		} else {
			System.out.println("cannot update phonenumber");
		}
		return res;
	}

	@Override
	public int validateAnddeleteById(int id) {
		if (id == 0) {
			System.out.println("failed to delete");
		} else {
			return matrimonyDAO.deleteById(id);
		}
		return id;
	}

	@Override
	public int[] validateAndInsertBride(List<BrideDTO> brides) {
		if (brides == null) {
			System.out.println("bride list cannot be null");
			// to store the result in the form of integer array first we want to create an
			// array
			int[] result = new int[brides.size()];
			for (int i = 0; i < result.length; i++) {
				result[i] = 0;
			}
			return result;
		} else {
			return matrimonyDAO.insertBrides(brides);
		}
	}

	@Override
	public int[] validateAndUpdateBrides(List<BrideDTO> brideDTOs) {
		if (brideDTOs == null) {
			System.out.println("Bride can not be null");
			int[] result = new int[brideDTOs.size()];
			for (int i = 0; i < result.length; i++) {
				result[i] = 0;
			}
			return result;
		} else {
			return matrimonyDAO.updateBrides(brideDTOs);
		}
	}

	@Override
	public int[] validateAndDeleteIds(List<Integer> ids) {
		if (ids == null) {
			System.out.println("id is not valid");
			int[] result = new int[ids.size()];
			for (int i = 0; i < result.length; i++) {
				result[i] = 0;
			}
			return result;
		} else {
			return this.matrimonyDAO.deleteIds(ids);
		}
	}

	@Override
	public int validateAndCreateGroom(GroomDTO groom) {
		if (null == groom) {
			System.out.println("bride cannot be null");
			return 0;
		} else if (groom.getGroom_id() == 0) {
			System.out.println("bride id cannot be 0");
			return 0;
		} else {
			return matrimonyDAO.create(groom);
		}
	}

	@Override
	public int[] validateAndInsertGroom(List<GroomDTO> groomDTOs) {
		if (groomDTOs == null) {
			System.out.println("bride list cannot be null");
			// to store the result in the form of integer array first we want to create an
			// array
			int[] result = new int[groomDTOs.size()];
			for (int i = 0; i < result.length; i++) {
				result[i] = 0;
			}
			return result;
		} else {
			return matrimonyDAO.insertGrooms(groomDTOs);
		}
	}

	@Override
	public int validateAndUpdatePhoneNumberById(String phonenumber, int id) {
		int res = 0;
		if (id != 0 && phonenumber != null && phonenumber.length() >= 10) {
			res = matrimonyDAO.updatePhone_NumberById(phonenumber, id);
			System.out.println("can update phone number");
		} else {
			System.out.println("cannot update phonenumber");
		}
		return res;
	}

	@Override
	public int validateAndDelete(int id) {
		if (id == 0) {
			System.out.println("failed to delete");
		} else {
			return matrimonyDAO.deleteById(id);
		}
		return id;
	}
}
