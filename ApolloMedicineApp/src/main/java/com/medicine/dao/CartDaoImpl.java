package com.medicine.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.medicine.model.Cart;
import com.medicine.util.CartQueries;
import com.medicine.util.DbConnection;
import com.medicine.util.IRowMapper;
import com.medicine.util.MedicineMapper;
import com.medicine.util.Queries;

public class CartDaoImpl implements ICartDao{
	/**
	 *Show medicines with specific name or medicine id and add it to cart
	 *@param id the id of the medicine
	 *@return List<Cart> to list the medicines
	 *@author MathanRajS
	 */
	@Override
	public List<Cart> findCart(String name) {
		Connection connection=DbConnection.openConnection();
		PreparedStatement preparedstatement=null;
		List<Cart> cartList=new ArrayList<>();
//		List<Medicine> cartList=new ArrayList<>();
//		Scanner sc=new Scanner(System.in);
//		int cartContinue;
		ResultSet result=null;
		IRowMapper rowMapper=new MedicineMapper();
		try{
			

				
				preparedstatement=connection.prepareStatement(CartQueries.QUERYBYCART);
				preparedstatement.setString(1,name+"%");
				int check=preparedstatement.executeUpdate();
				if(check==1) {
					System.out.println("ADDED TO CART");
				}else {
					System.out.println("ITEM NOT IN THE LIST");
					System.exit(0);
				}
				preparedstatement.close();
//				preparedstatement=connection.prepareStatement(Queries.QUERYFORSELECTCART);
//				result=preparedstatement.executeQuery();
////					cartList=rowMapper.mapMedicine(result);
//					while(result.next()) {
//						Cart cart=new Cart();
//						String medicineName=result.getString(1);
//						int Id=result.getInt(2);
//						double cost=result.getDouble(3);
//						cart.setMedicineName(medicineName);
//						cart.setMedicineId(Id);
//						cart.setCost(cost);
//						cartList.add(cart);
//					}
					
				
			
			
			
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
			
				preparedstatement=connection.prepareStatement(CartQueries.QUERYFORSELECTCART);
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
