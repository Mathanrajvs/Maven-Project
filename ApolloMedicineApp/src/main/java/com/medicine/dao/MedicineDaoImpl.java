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
		PreparedStatement ps = null;
		try {

			ps = connection.prepareStatement(Queries.INSERTQUERY);
			ps.setString(1, medicine.getMedicineName());
			ps.setInt(2, medicine.getMedicineId());
			ps.setString(3, medicine.getCategory());
			ps.setString(4, medicine.getBrand());
			ps.setDouble(5, medicine.getCost());
			ps.setBoolean(6, medicine.isAvailability());
			boolean rs = ps.execute();
			if (!rs) {
				System.out.println("ADDED SUCCESSFULLY");
			}

		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {

			try {
				if (ps != null)
					ps.close();
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
		PreparedStatement ps = null;
		try {

			ps = connection.prepareStatement(Queries.UPDATEQUERY);
			ps.setDouble(1, fees);
			ps.setInt(2, medicineId);
			boolean rs = ps.execute();
			if (!rs) {
				System.out.println("UPDATED SUCCESSFULLY");
			} else {
				System.out.println("NOT UPDATED.....");
			}

		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {

			try {
				if (ps != null)
					ps.close();
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
		PreparedStatement ps = null;
		Medicine medicine=null;
		try {

			ps = connection.prepareStatement(Queries.FINDQUERY);
			ps.setInt(1, medicineId);
			boolean rs = ps.execute();
			if (rs) {
				ResultSet result = ps.executeQuery();
				while (result.next()) {
					medicine=new Medicine();
					String name = result.getString(1);
					int Id = result.getInt(2);
					String category = result.getString(3);
					String brand = result.getString(4);
					double cost = result.getDouble(5);
					boolean available = result.getBoolean(6);

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
				if (ps != null)
					ps.close();
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
		PreparedStatement ps = null;
		try {

			ps = connection.prepareStatement(Queries.DELETEQUERY);
			ps.setInt(1, medicineId);
			boolean rs = ps.execute();
			if (!rs) {
				System.out.println("DELETED SUCESSFULLY");

			}else {
				System.out.println("NOT DELETED.....");
			}

		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {

			try {
				if (ps != null)
					ps.close();
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
		PreparedStatement ps=null;
		List<Medicine> medicineCategory=null;
		try{
			
			ps=connection.prepareStatement(Queries.QUERYBYCATEGORY);
			ps.setString(1,category);

				ResultSet result=ps.executeQuery();
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
					if(ps!=null)
					ps.close();
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
		PreparedStatement ps=null;
		List<Medicine> medicineCategoryAndBrand=null;
		try{
			
			ps=connection.prepareStatement(Queries.QUERYBYCATEGORYANDBRAND);
			ps.setString(1,category);
			ps.setString(2, brand);

				ResultSet result=ps.executeQuery();
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
					if(ps!=null)
					ps.close();
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
		PreparedStatement ps=null;
		List<Medicine> medicineName=new ArrayList<>();
		try{
			
			ps=connection.prepareStatement(Queries.QUERYBYNAMECONTAINING);
			ps.setString(1,name.toUpperCase()+"%");

				ResultSet result=ps.executeQuery();
				
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
					if(ps!=null)
					ps.close();
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
		PreparedStatement ps=null;
		List<Medicine> medicineNameAndCategory=new ArrayList<>();
		try{
			
			ps=connection.prepareStatement(Queries.QUERYBYNAMEANDCATEGORY);
			ps.setString(1,name.toUpperCase()+"%");
			ps.setString(2, category);

				ResultSet result=ps.executeQuery();
				
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
					if(ps!=null)
					ps.close();
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
		PreparedStatement ps=null;
		List<Medicine> medicineCategoryAndCost=new ArrayList<>();
		try{
			
			ps=connection.prepareStatement(Queries.QUERYFORCATEORYANDCOST);
			ps.setString(1,category);
			ps.setDouble(2, cost);

				ResultSet result=ps.executeQuery();
				
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
					if(ps!=null)
					ps.close();
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
		PreparedStatement ps=null;
		List<Medicine> medicineAvailability=null;
		boolean flag=present;
		try{
			
			ps=connection.prepareStatement(Queries.QUERYBYNAMEANDAVAILABILITY);
			ps.setString(1,name+"%");
			ps.setBoolean(2, present);
			boolean rs=ps.execute();
			if(rs) {
				//flag=true;
			

				ResultSet result=ps.executeQuery();
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
				}}
				if(!medicineAvailability.isEmpty())
				System.out.println(medicineAvailability);
				
			
			
			
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		finally {
			
				try {
					if(ps!=null)
					ps.close();
					DbConnection.closeConnection();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			
		}
		return flag;
		
	}

}
