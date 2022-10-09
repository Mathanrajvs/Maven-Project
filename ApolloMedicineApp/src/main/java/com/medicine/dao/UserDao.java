package com.medicine.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.medicine.model.Medicine;
import com.medicine.model.User;
import com.medicine.util.DbConnection;
import com.medicine.util.Queries;
import com.medicine.util.UserQueries;

public class UserDao implements IUserDao {

	@Override
	public String addUser(User user) {
		Connection connection = DbConnection.openConnection();
		PreparedStatement preparedstatement = null;
		try {

			preparedstatement = connection.prepareStatement(UserQueries.INSERTQUERY);
			preparedstatement.setString(1,user.getUsername());
			preparedstatement.setString(2,user.getName());
			preparedstatement.setInt(3,user.getMobile());
			preparedstatement.setString(4,user.getEmail());
			preparedstatement.setString(5,user.getCity());
			preparedstatement.setString(6,user.getUserId());
			preparedstatement.setString(7,user.getPassword());
			boolean inserted=preparedstatement.execute();
			if(!inserted)
				return "INSERTED SUCCESSFULLY";
			
			

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
		return "NOT INSERTED SUCCESSFULLY...";
	}

	@Override
	public String changePassword(String userId,String password) {
		Connection connection = DbConnection.openConnection();
		PreparedStatement preparedstatement = null;
		try {

			preparedstatement = connection.prepareStatement(UserQueries.UPDATEQUERY);
			preparedstatement.setString(1,password);
			preparedstatement.setString(2,userId);
			int changed=preparedstatement.executeUpdate();
			if(changed==1)
				return "CHANGED SUCCESSFULLY";
			
			

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
		return "NOT CHANGED SUCCESSFULLY...";
	}

	@Override
	public User login(String userId, String password) {
		Connection connection = DbConnection.openConnection();
		PreparedStatement preparedstatement = null;
		User user=null;
		try {
			
			preparedstatement = connection.prepareStatement(UserQueries.QUERYFORLOGIN);
			preparedstatement.setString(1,userId);
			preparedstatement.setString(2,password);
			ResultSet result=preparedstatement.executeQuery();
			//System.out.println(result);
			while(result.next()) {
				user=new User();
				user.setUsername(result.getString(1));
				user.setName(result.getString(2));
				user.setMobile(result.getInt(3));
				user.setEmail(result.getString(4));
				user.setCity(result.getString(5));
				user.setUserId(result.getString(6));
				user.setPassword(result.getString(7));
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
		return user;
	}

}
