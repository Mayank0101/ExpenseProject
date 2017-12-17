package com.homeexpense.dao.impl;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.homeexpense.dao.MyHomeExpensesDAO;
import com.homeexpense.vo.Expenses;

@Repository
public class ExpensesRepositoryImpl implements MyHomeExpensesDAO {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	@Override
	public boolean addExpenses(Expenses expense) {
		//String date_s = " 2011-01-18 00:00:00.0"; 
		SimpleDateFormat dt = new SimpleDateFormat("dd/MM/yyyy"); 
		java.util.Date date = new Date(0);
		try {
			date =  dt.parse(expense.getStartDate());
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		SimpleDateFormat dt1 = new SimpleDateFormat("yyyy-MM-dd");
		System.out.println(dt1.format(date));
		String sql = "INSERT INTO FirstDB.Expenses\n" + 
				"(RETAILER_NAME, PRODUCT_NAME, QUANTITY_SIZE, PRICE, `DATE`)" + 
				"VALUES('"+expense.getRetailer().replaceAll("'", "''")+"', '"+expense.getProductName()+"', '"+expense.getSize()
				+"', "+expense.getPrice()+",'"+dt1.format(date)+"')";
		jdbcTemplate.execute(sql);
		
		return true;
	}

	
}
