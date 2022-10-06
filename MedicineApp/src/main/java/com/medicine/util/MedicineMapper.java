package com.medicine.util;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.medicine.model.Cart;
import com.medicine.model.Medicine;

public class MedicineMapper implements IRowMapper {

	@Override
	public List<Cart> mapMedicine(ResultSet resultset) throws SQLException {
		List<Cart> cartList = new ArrayList<>();
		Cart cart = null;
		resultset.beforeFirst();
		while (resultset.next()) {
			cart = new Cart();
			cart.setMedicineName(resultset.getString(1));
			cart.setMedicineId(resultset.getInt(2));
			cart.setCost(resultset.getDouble(3));
			cartList.add(cart);
		}
		return cartList;
	}

}
