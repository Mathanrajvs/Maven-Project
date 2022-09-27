package com.medicine.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.medicine.model.Medicine;
import com.medicine.util.DbConnection;
import com.medicine.util.Queries;

public class MedicineDaoImpl implements IMedicineDao {

	@Override
	public void addMedicine(Medicine medicine) {
		Connection connection = DbConnection.openConnection();
		PreparedStatement preparedstatement = null;
		int result;
		try {

			preparedstatement = connection.prepareStatement(Queries.INSERTQUERY);
			preparedstatement.setString(1, medicine.getMedicineName());
			preparedstatement.setInt(2, medicine.getMedicineId());
			preparedstatement.setString(3, medicine.getCategory());
			preparedstatement.setString(4, medicine.getBrand());
			preparedstatement.setDouble(5, medicine.getCost());
			preparedstatement.setBoolean(6, medicine.isAvailability());
			result = preparedstatement.executeUpdate();
			if(result==1) {
			System.out.println("ADDED SUCCESSFULLY");}
			
			

		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {

			try {
				if (preparedstatement != null)
					preparedstatement.close();
				DbConnection.closeConnection();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

	}

	@Override
	public void updateMedicine(int medicineId, double fees) {
		Connection connection = DbConnection.openConnection();
		PreparedStatement preparedstatement = null;
		try {

			preparedstatement = connection.prepareStatement(Queries.UPDATEQUERY);
			preparedstatement.setDouble(1, fees);
			preparedstatement.setInt(2, medicineId);
			int result = preparedstatement.executeUpdate();
			if (result==1) {
				System.out.println("UPDATED SUCCESSFULLY");
			} else {
				System.out.println("NOT UPDATED.....");
			}

		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {

			try {
				if (preparedstatement != null)
					preparedstatement.close();
				DbConnection.closeConnection();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

	}

	@Override
	public Medicine findById(int medicineId) {
		Connection connection = DbConnection.openConnection();
		PreparedStatement preparedstatement = null;
		Medicine medicine=null;
		try {

			preparedstatement = connection.prepareStatement(Queries.FINDQUERY);
			preparedstatement.setInt(1, medicineId);
			int result = preparedstatement.executeUpdate();
			if (result==1) {
				ResultSet resultset = preparedstatement.executeQuery();
				while (resultset.next()) {
					medicine=new Medicine();
					String name = resultset.getString(1);
					int Id = resultset.getInt(2);
					String category = resultset.getString(3);
					String brand = resultset.getString(4);
					double cost = resultset.getDouble(5);
					boolean available = resultset.getBoolean(6);

					medicine.setMedicineName(name);
					medicine.setMedicineId(Id);
					medicine.setCategory(category);
					medicine.setBrand(brand);
					medicine.setCost(cost);
					medicine.setAvailability(available);
					return medicine;
				}

			} 

		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {

			try {
				if (preparedstatement != null)
					preparedstatement.close();
				DbConnection.closeConnection();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
		return medicine;
	}

	@Override
	public void deleteMedicine(int medicineId) {
		Connection connection = DbConnection.openConnection();
		PreparedStatement preparedstatement = null;
		try {

			preparedstatement = connection.prepareStatement(Queries.DELETEQUERY);
			preparedstatement.setInt(1, medicineId);
			int result = preparedstatement.executeUpdate();
			if (result==1) {
				System.out.println("DELETED SUCESSFULLY");

			}else {
				System.out.println("NOT DELETED.....");
			}

		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {

			try {
				if (preparedstatement != null)
					preparedstatement.close();
				DbConnection.closeConnection();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

	}

	@Override
	public List<Medicine> findByCategory(String category) {
		Connection connection=DbConnection.openConnection();
		PreparedStatement preparedstatement=null;
		List<Medicine> medicineCategory=null;
		ResultSet result=null;
		try{
			
			preparedstatement=connection.prepareStatement(Queries.QUERYBYCATEGORY);
			preparedstatement.setString(1,category);

				result=preparedstatement.executeQuery();
				medicineCategory=new ArrayList<>();
				while(result.next()) {
					Medicine medicine=new Medicine();
					String name=result.getString(1);
					int Id=result.getInt(2);
					String categoryType=result.getString(3);
					String brand=result.getString(4);
					double cost=result.getDouble(5);
					boolean available=result.getBoolean(6);
					
					medicine.setMedicineName(name);
					medicine.setMedicineId(Id);
					medicine.setCategory(categoryType);
					medicine.setBrand(brand);
					medicine.setCost(cost);
					medicine.setAvailability(available);
					medicineCategory.add(medicine);
				}
					
				
				
			
			
			
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		finally {
			
				try {
					if(result!=null)
						result.close();
					if(preparedstatement!=null)
					preparedstatement.close();
					DbConnection.closeConnection();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			
		}
		return medicineCategory;
	}

	@Override
	public List<Medicine> findByCategoryAndBrand(String category, String brand) {
		Connection connection=DbConnection.openConnection();
		PreparedStatement preparedstatement=null;
		List<Medicine> medicineCategoryAndBrand=null;
		ResultSet result=null;
		try{
			
			preparedstatement=connection.prepareStatement(Queries.QUERYBYCATEGORYANDBRAND);
			preparedstatement.setString(1,category);
			preparedstatement.setString(2, brand);

				result=preparedstatement.executeQuery();
				medicineCategoryAndBrand=new ArrayList<>();
				while(result.next()) {
					Medicine medicine=new Medicine();
					String name=result.getString(1);
					int Id=result.getInt(2);
					String categoryType=result.getString(3);
					String brandOfCompany=result.getString(4);
					double cost=result.getDouble(5);
					boolean available=result.getBoolean(6);
					
					medicine.setMedicineName(name);
					medicine.setMedicineId(Id);
					medicine.setCategory(categoryType);
					medicine.setBrand(brandOfCompany);
					medicine.setCost(cost);
					medicine.setAvailability(available);
					medicineCategoryAndBrand.add(medicine);
				}
					
				
				
			
			
			
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		finally {
			
				try {
					if(result!=null)
						result.close();
					if(preparedstatement!=null)
					preparedstatement.close();
					DbConnection.closeConnection();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			
		}
		return medicineCategoryAndBrand;
	}

	@Override
	public List<Medicine> findByNameContaining(String name) {
		Connection connection=DbConnection.openConnection();
		PreparedStatement preparedstatement=null;
		List<Medicine> medicineName=new ArrayList<>();
		ResultSet result=null;
		try{
			
			preparedstatement=connection.prepareStatement(Queries.QUERYBYNAMECONTAINING);
			preparedstatement.setString(1,name.toUpperCase()+"%");

				result=preparedstatement.executeQuery();
				
				while(result.next()) {
					Medicine medicine=new Medicine();
					String nameOfTheMedicine=result.getString(1);
					int Id=result.getInt(2);
					String categoryType=result.getString(3);
					String brand=result.getString(4);
					double cost=result.getDouble(5);
					boolean available=result.getBoolean(6);
					
					medicine.setMedicineName(nameOfTheMedicine);
					medicine.setMedicineId(Id);
					medicine.setCategory(categoryType);
					medicine.setBrand(brand);
					medicine.setCost(cost);
					medicine.setAvailability(available);
					medicineName.add(medicine);
				}
					
				
				
			
			
			
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		finally {
			
				try {
					if(result!=null)
						result.close();
					if(preparedstatement!=null)
					preparedstatement.close();
					DbConnection.closeConnection();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			
		}
		return medicineName;
	}

	@Override
	public List<Medicine> findByNameAndCategory(String name, String category) {
		Connection connection=DbConnection.openConnection();
		PreparedStatement preparedstatement=null;
		List<Medicine> medicineNameAndCategory=new ArrayList<>();
		ResultSet result=null;
		try{
			
			preparedstatement=connection.prepareStatement(Queries.QUERYBYNAMEANDCATEGORY);
			preparedstatement.setString(1,name.toUpperCase()+"%");
			preparedstatement.setString(2, category);

				result=preparedstatement.executeQuery();
				
				while(result.next()) {
					Medicine medicine=new Medicine();
					String medicineName=result.getString(1);
					int Id=result.getInt(2);
					String categoryType=result.getString(3);
					String brand=result.getString(4);
					double cost=result.getDouble(5);
					boolean available=result.getBoolean(6);
					
					medicine.setMedicineName(medicineName);
					medicine.setMedicineId(Id);
					medicine.setCategory(categoryType);
					medicine.setBrand(brand);
					medicine.setCost(cost);
					medicine.setAvailability(available);
					medicineNameAndCategory.add(medicine);
				}
					
				
				
			
			
			
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		finally {
			
				try {
					if(result!=null)
						result.close();
					if(preparedstatement!=null)
					preparedstatement.close();
					DbConnection.closeConnection();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			
		}
		return medicineNameAndCategory;
	}

	@Override
	public List<Medicine> findByCategoryAndLessCost(String category, double cost) {
		Connection connection=DbConnection.openConnection();
		PreparedStatement preparedstatement=null;
		List<Medicine> medicineCategoryAndCost=new ArrayList<>();
		ResultSet result=null;
		try{
			
			preparedstatement=connection.prepareStatement(Queries.QUERYFORCATEORYANDCOST);
			preparedstatement.setString(1,category);
			preparedstatement.setDouble(2, cost);

				result=preparedstatement.executeQuery();
				
				while(result.next()) {
					Medicine medicine=new Medicine();
					String name=result.getString(1);
					int Id=result.getInt(2);
					String categoryType=result.getString(3);
					String brand=result.getString(4);
					double costOfTheMedicine=result.getDouble(5);
					boolean available=result.getBoolean(6);
					
					medicine.setMedicineName(name);
					medicine.setMedicineId(Id);
					medicine.setCategory(categoryType);
					medicine.setBrand(brand);
					medicine.setCost(costOfTheMedicine);
					medicine.setAvailability(available);
					medicineCategoryAndCost.add(medicine);
				}
					
				
				
			
			
			
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		finally {
			
				try {
					if(result!=null)
						result.close();
					if(preparedstatement!=null)
					preparedstatement.close();
					DbConnection.closeConnection();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			
		}
		return medicineCategoryAndCost;
	}

	@Override
	public boolean findByNameAndAvailabilty(String name,boolean present) {
		Connection connection=DbConnection.openConnection();
		PreparedStatement preparedstatement=null;
		List<Medicine> medicineAvailability=null;
		boolean flag=present;
		ResultSet result=null;
		try{
			
			preparedstatement=connection.prepareStatement(Queries.QUERYBYNAMEANDAVAILABILITY);
			preparedstatement.setString(1,name+"%");
			preparedstatement.setBoolean(2, present);
			
			

				result=preparedstatement.executeQuery();
				medicineAvailability=new ArrayList<>();
				while(result.next()) {
					Medicine medicine=new Medicine();
					String medicineName=result.getString(1);
					int Id=result.getInt(2);
					String categoryType=result.getString(3);
					String brand=result.getString(4);
					double costOfTheMedicine=result.getDouble(5);
					boolean availableMedicine=result.getBoolean(6);
					
					medicine.setMedicineName(medicineName);
					medicine.setMedicineId(Id);
					medicine.setCategory(categoryType);
					medicine.setBrand(brand);
					medicine.setCost(costOfTheMedicine);
					medicine.setAvailability(availableMedicine);
					medicineAvailability.add(medicine);
				}
				if(!medicineAvailability.isEmpty())
				System.out.println(medicineAvailability);
				
			
			
			
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		finally {
			
				try {
					if(result!=null)
						result.close();
					if(preparedstatement!=null)
					preparedstatement.close();
					DbConnection.closeConnection();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			
		}
		return flag;
		
	}

}
