package com.medicine.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.medicine.model.Cart;
import com.medicine.model.Medicine;
import com.medicine.util.DbConnection;
import com.medicine.util.IRowMapper;
import com.medicine.util.MedicineMapper;
import com.medicine.util.Queries;

/**
 *Perform operations in DAO layer
 * @implSpec IMedicineDao the interface
 * @author MathanRajS
 *@version 18.x
 */

public class MedicineDaoImpl implements IMedicineDao {
	
	
	/**
	 *To add medicine in the database
	 *@param medicine the medicine object class of Medicine
	 *@return void returns nothing
	 *@author MathanRajS
	 *
	 */
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

	/**
	 *To Update medicine in the database
	 *@param medicineId the medicine id
	 *@param fees the cost of a medicine
	 *@return void return nothing
	 *@author MathanRajS
	 *
	 */
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
	/**
	 *To Find the specific medicine in the database if it is present or not
	 *@param medicineId the medicine id
	 *@return Medicine return medicine object
	 *@author MathanRajS
	 *
	 */
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
	/**
	 *To Delete the specific medicine in the database
	 * @param medicineId the medicine id
	 * @return void returns nothing
	 * @author MathanRajS
	 */

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
	/**
	 *Show all medicines with specific category
	 *@param category the category of the medicine
	 *@return List<Medicine> to list the medicines
	 *@author MathanRajS
	 */
	@Override
	public List<Medicine> findByCategory(String category) {
		Connection connection=DbConnection.openConnection();
		PreparedStatement preparedstatement=null;
		List<Medicine> medicineList=null;
		ResultSet result=null;
		try{
			
			preparedstatement=connection.prepareStatement(Queries.QUERYBYCATEGORY);
			preparedstatement.setString(1,category);

				result=preparedstatement.executeQuery();
				
				medicineList=new ArrayList<>();
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
					medicineList.add(medicine);
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
		return medicineList;
	}
	/**
	 *Show medicines with specific category and specific brand
	 *@param brand the brand of the medicine
	 *@param category the category of the medicine
	 *@return List<Medicine> to list the medicines
	 *@author MathanRajS
	 */
	@Override
	public List<Medicine> findByCategoryAndBrand(String category, String brand) {
		Connection connection=DbConnection.openConnection();
		PreparedStatement preparedstatement=null;
		List<Medicine> medicineList=null;
		ResultSet result=null;
		try{
			
			preparedstatement=connection.prepareStatement(Queries.QUERYBYCATEGORYANDBRAND);
			preparedstatement.setString(1,category);
			preparedstatement.setString(2, brand);

				result=preparedstatement.executeQuery();
				medicineList=new ArrayList<>();
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
					medicineList.add(medicine);
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
		return medicineList;
	}
	/**
	 *Show all medicines that starts with name containing
	 *@param name the name of the medicine
	 *@return List<Medicine> to list the medicines
	 *@author MathanRajS
	 */
	@Override
	public List<Medicine> findByNameContaining(String name) {
		Connection connection=DbConnection.openConnection();
		PreparedStatement preparedstatement=null;
		List<Medicine> medicineList=new ArrayList<>();
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
					medicineList.add(medicine);
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
		return medicineList;
	}
	/**
	 *Show medicines with specific category and specific name
	 *@param name the name of the medicine
	 *@param category the category of the medicine
	 *@return List<Medicine> to list the medicines
	 *@author MathanRajS
	 */
	@Override
	public List<Medicine> findByNameAndCategory(String name, String category) {
		Connection connection=DbConnection.openConnection();
		PreparedStatement preparedstatement=null;
		List<Medicine> medicineList=new ArrayList<>();
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
					medicineList.add(medicine);
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
		return medicineList;
	}
	/**
	 *Show medicines with specific category and specific cost
	 *@param cost the cost of the medicine
	 *@param category the category of the medicine
	 *@return List<Medicine> to list the medicines
	 *@author MathanRajS
	 */
	@Override
	public List<Medicine> findByCategoryAndLessCost(String category, double cost) {
		Connection connection=DbConnection.openConnection();
		PreparedStatement preparedstatement=null;
		List<Medicine> medicineList=new ArrayList<>();
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
					medicineList.add(medicine);
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
		return medicineList;
	}
	/**
	 *Show medicines with specific name and check if it is present or not
	 *@param name the name of the medicine
	 *@param present to check the medicine is available
	 *@return List<Medicine> to list the medicines
	 *@author MathanRajS
	 */
	@Override
	public boolean findByNameAndAvailabilty(String name,boolean present) {
		Connection connection=DbConnection.openConnection();
		PreparedStatement preparedstatement=null;
		List<Medicine> medicineList=null;
		
		boolean flag=present;
		ResultSet result=null;
		try{
			
			preparedstatement=connection.prepareStatement(Queries.QUERYBYNAMEANDAVAILABILITY);
			preparedstatement.setString(1,name+"%");
			preparedstatement.setBoolean(2, present);
			
			

				result=preparedstatement.executeQuery();
				medicineList=new ArrayList<>();
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
					medicineList.add(medicine);
				}
				if(!medicineList.isEmpty())
				System.out.println(medicineList);
				
			
			
			
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
	/**
	 *Show medicines with specific name or medicine id and add it to cart
	 *@param id the id of the medicine
	 *@return List<Cart> to list the medicines
	 *@author MathanRajS
	 */
	@Override
	public List<Cart> findCart(int id) {
		Connection connection=DbConnection.openConnection();
		PreparedStatement preparedstatement=null;
		List<Cart> cartList=new ArrayList<>();
//		List<Medicine> cartList=new ArrayList<>();
//		Scanner sc=new Scanner(System.in);
//		int cartContinue;
		ResultSet result=null;
		IRowMapper rowMapper=new MedicineMapper();
		try{
			

				
				preparedstatement=connection.prepareStatement(Queries.QUERYBYCART);
				preparedstatement.setString(1,"%"+name+"%");
				int check=preparedstatement.executeUpdate();
				if(check==1) {
					System.out.println("ADDED TO CART");
				}else {
					System.out.println("ITEM NOT IN THE LIST");
					System.exit(0);
				}
				preparedstatement.close();
				preparedstatement=connection.prepareStatement(Queries.QUERYFORSELECTCART);
				result=preparedstatement.executeQuery();
//					cartList=rowMapper.mapMedicine(result);
					while(result.next()) {
						Cart cart=new Cart();
						String medicineName=result.getString(1);
						int Id=result.getInt(2);
						double cost=result.getDouble(3);
						cart.setMedicineName(medicineName);
						cart.setMedicineId(Id);
						cart.setCost(cost);
						cartList.add(cart);
					}
					
				
			
			
			
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		finally {
			
				try {
					//sc.close();
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
		return cartList;
	}
	/**
	 *Show medicines with specific name or medicine id from the cart
	 */
	public void findShowCart() {
		Connection connection=DbConnection.openConnection();
		PreparedStatement preparedstatement=null;
		List<Cart> cartList=new ArrayList<>();
		ResultSet result=null;
		try{
			
				preparedstatement=connection.prepareStatement(Queries.QUERYFORSELECTCART);
				result=preparedstatement.executeQuery();
//					cartList=rowMapper.mapMedicine(result);
					while(result.next()) {
						Cart cart=new Cart();
						String medicineName=result.getString(1);
						int Id=result.getInt(2);
						double cost=result.getDouble(3);
						cart.setMedicineName(medicineName);
						cart.setMedicineId(Id);
						cart.setCost(cost);
						cartList.add(cart);
					}
					
				System.out.println(cartList);
			
			
			
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		finally {
			
				try {
					//sc.close();
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
		
	}

}
