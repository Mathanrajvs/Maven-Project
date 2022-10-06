package com.medicine.util;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.medicine.model.Cart;
import com.medicine.model.Medicine;

public interface IRowMapper {
	List<Cart> mapMedicine(ResultSet resultset) throws SQLException;

}
