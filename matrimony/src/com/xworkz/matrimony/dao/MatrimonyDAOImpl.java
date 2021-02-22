package com.xworkz.matrimony.dao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import com.xworkz.matrimony.dto.BrideDTO;
import com.xworkz.matrimony.dto.GroomDTO;

import static com.xworkz.matrimony.constants.ConstantsURL.*;
public class MatrimonyDAOImpl implements MatrimonyDAO {

	@Override
	public BrideDTO getById(int id) {
		BrideDTO brideDTO = new BrideDTO();
		try (Connection con= DriverManager.getConnection(DB_URL,USER_NAME,PASSWORD)){
			System.out.println("connected with database");
			Statement stmt = con.createStatement(); // 3rd step create statement drivermanager will establish a
															// connection with db.
			// resultSet contains result of the query of the sql
			ResultSet resultSet = stmt.executeQuery("select * from matrimony.bride where id=1");
			// to map the record into javaobject we need dto
			resultSet.next();
				brideDTO.setId(resultSet.getInt(1));
				brideDTO.setName(resultSet.getString(2));
				brideDTO.setAge(resultSet.getInt(3));
				brideDTO.setHeight(resultSet.getDouble(4));
				brideDTO.setWeight(resultSet.getDouble(5));
				brideDTO.setQualification(resultSet.getString(6));
				brideDTO.setPhone_Number(resultSet.getString(7));
				brideDTO.setSalary(resultSet.getDouble(8));
				brideDTO.setOccupation(resultSet.getString(9));
				brideDTO.setAddress(resultSet.getString(10));
				brideDTO.setExpectations(resultSet.getString(11));
			
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Failed to connect with database");
		}		
		return brideDTO;
	}
	// finally block is used to close the connection
//			finally {
//				try {
//					connection.close();
//					System.out.println("Connection is closed");
//				} catch (SQLException e) {
//					System.out.println("connection not closed");
//					e.printStackTrace();
//				}
//			}


	@Override
	public List<BrideDTO> getAllBride() {
		List<BrideDTO> dto = new ArrayList<BrideDTO>();
		try (Connection con= DriverManager.getConnection(DB_URL,USER_NAME,PASSWORD)){
			Statement stmt = con.createStatement();
			ResultSet resultSet = stmt.executeQuery("select * from matrimony.bride");
			while (resultSet.next()) {
				BrideDTO brideDTO = new BrideDTO();
				brideDTO.setId(resultSet.getInt(1));
				brideDTO.setName(resultSet.getString(2));
				brideDTO.setAge(resultSet.getInt(3));
				brideDTO.setHeight(resultSet.getDouble(4));
				brideDTO.setWeight(resultSet.getDouble(5));
				brideDTO.setQualification(resultSet.getString(6));
				brideDTO.setPhone_Number(resultSet.getString(7));
				brideDTO.setSalary(resultSet.getDouble(8));
				brideDTO.setOccupation(resultSet.getString(9));
				brideDTO.setAddress(resultSet.getString(10));
				brideDTO.setExpectations(resultSet.getString(11));
				dto.add(brideDTO);
			}
//			for (BrideDTO brideDTO2 : dto) {
//				System.out.println(brideDTO2);
//			}
		}

		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		return dto;
	}


	@Override
	public int create(BrideDTO bride) {
		int result=0;
		try (Connection con= DriverManager.getConnection(DB_URL,USER_NAME,PASSWORD)){
		  PreparedStatement stmt=con.prepareStatement("insert into matrimony.bride values(?,?,?,?,?,?,?,?,?,?,?)");
		  stmt.setInt(1,bride.getId());
		  stmt.setString(2,bride.getName());
		  stmt.setInt(3,bride.getAge());
		  stmt.setDouble(4,bride.getHeight());
		  stmt.setDouble(5,bride.getWeight());
		  stmt.setString(6,bride.getQualification());
		  stmt.setString(7,bride.getPhone_Number());
		  stmt.setDouble(8,bride.getSalary());
		  stmt.setString(9,bride.getOccupation());
		  stmt.setString(10,bride.getAddress());
		  stmt.setString(11,bride.getExpectations());
		  result=stmt.executeUpdate();
		  
		}catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	
	@Override
	public int updatePhone_NumberById(String phone_number, int id) {
		int result=0;
		try(Connection con= DriverManager.getConnection(DB_URL,USER_NAME,PASSWORD)) {
			
		  PreparedStatement stmt=con.prepareStatement("update matrimony.bride set Phone_Number =? where id=?");
		  stmt.setInt(2,id);
		  stmt.setString(1,phone_number);
		  result=stmt.executeUpdate();
		}catch (Exception e) {
			e.printStackTrace();
		}
		  return result;
	}


	@Override
	public int deleteById(int id) {
		int result=0;
		try (Connection con= DriverManager.getConnection(DB_URL,USER_NAME,PASSWORD)){
			PreparedStatement stmt=con.prepareStatement("delete from matrimony.bride where id=?");
			stmt.setInt(1, id);
			result=stmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}


	@Override
	public int[] insertBrides(List<BrideDTO> brideDTOs) {
		int[] results=new int[brideDTOs.size()];
		try (Connection con= DriverManager.getConnection(DB_URL,USER_NAME,PASSWORD)){
			// a batch contain multiple upadte query,it cannot contain different dml statements.
			PreparedStatement stmt=con.prepareStatement("insert into matrimony.bride values(?,?,?,?,?,?,?,?,?,?,?)");
			for (BrideDTO c : brideDTOs) {
				stmt.addBatch();
			}
			results=stmt.executeBatch();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return results;
	}


	@Override
	public int[] updateBrides(List<BrideDTO> bride) {
		int[] result =new int[bride.size()];
		try(Connection con= DriverManager.getConnection(DB_URL,USER_NAME,PASSWORD)){
			PreparedStatement stmt=con.prepareStatement(UPDATE_QUERY);
			for (BrideDTO c : bride) {
				stmt.setString(1,c.getQualification());
				stmt.setDouble(2,c.getSalary());
				stmt.setInt(3,c.getId());
				stmt.addBatch();
			}
			result=stmt.executeBatch();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}


	@Override
	public int[] deleteIds(List<Integer> ids) {
		int[] results =new int[ids.size()];
		try(Connection con= DriverManager.getConnection(DB_URL,USER_NAME,PASSWORD)){
			PreparedStatement stmt=con.prepareStatement(DELETE_QUERY);
			for (Integer id : ids) {
				stmt.setInt(1, id);
				stmt.addBatch();
			}
			results=stmt.executeBatch();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		return results;
	}
	
	@Override
	public int create(GroomDTO groom) {
		int result=0;
		try (Connection con= DriverManager.getConnection(DB_URL,USER_NAME,PASSWORD)){
		  PreparedStatement stmt=con.prepareStatement("insert into matrimony.groom values(?,?,?,?,?,?,?,?,?,?,?)");
		  stmt.setInt(1,groom.getGroom_id());
		  stmt.setString(2,groom.getName());
		  stmt.setInt(3,groom.getAge());
		  stmt.setDouble(4,groom.getHeight());
		  stmt.setDouble(5,groom.getWeight());
		  stmt.setString(6,groom.getQualification());
		  stmt.setString(7,groom.getPhone_Number());
		  stmt.setDouble(8,groom.getSalary());
		  stmt.setString(9,groom.getOccupation());
		  stmt.setString(10,groom.getAddress());
		  stmt.setString(11,groom.getExpectations());
		  result=stmt.executeUpdate();
		  
		}catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}


	@Override
	public int[] insertGrooms(List<GroomDTO> groomDTOs) {
		int[] results=new int[groomDTOs.size()];
		try (Connection con= DriverManager.getConnection(DB_URL,USER_NAME,PASSWORD)){
			// a batch contain multiple upadte query,it cannot contain different dml statements.
			PreparedStatement stmt=con.prepareStatement("insert into matrimony.groom values(?,?,?,?,?,?,?,?,?,?,?)");
			for (GroomDTO c : groomDTOs) {
				stmt.addBatch();
			}
			results=stmt.executeBatch();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return results;
		}


	@Override
	public int updatePhoneNumberById(String phone_number, int id) {
		int result=0;
		try(Connection con= DriverManager.getConnection(DB_URL,USER_NAME,PASSWORD)) {
			
		  PreparedStatement stmt=con.prepareStatement("update matrimony.groom set Phone_Number =? where Groom_id=?");
		  stmt.setInt(2,id);
		  stmt.setString(1,phone_number);
		  result=stmt.executeUpdate();
		}catch (Exception e) {
			e.printStackTrace();
		}
		  return result;
}


	@Override
	public int deleteByGroomId(int id) {
		int result=0;
		try (Connection con= DriverManager.getConnection(DB_URL,USER_NAME,PASSWORD)){
			PreparedStatement stmt=con.prepareStatement("delete from matrimony.groom where Groom_id=?");
			stmt.setInt(1, id);
			result=stmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
}
}
//	@Override
//	public int[] insertBrides(List<BrideDTO> brideDTOs) {
//		int[] results=new int[brideDTOs.size()]; if bride size is 2 it will add 2 queries.
//		try (Connection con= DriverManager.getConnection()){
//			Statement stmt=con.createStatement();
//			for (BrideDTO brideDTO : brideDTOs) {				
//				// String Manipulation
//				String Query=String.format(INSERT_QUERY, 
//				brideDTO.getId(),
//				brideDTO.getName(),
//				brideDTO.getAge(),
//				brideDTO.getHeight(),
//				brideDTO.getWeight(),
//				brideDTO.getQualification(),
//				brideDTO.getPhone_Number(),
//				brideDTO.getSalary(),
//				brideDTO.getOccupation(),
//				brideDTO.getAddress(),
//				brideDTO.getExpectations());
//				stmt.addBatch(Query);
//			}
//			results=stmt.executeBatch();
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//		return results;
//	}
//}

