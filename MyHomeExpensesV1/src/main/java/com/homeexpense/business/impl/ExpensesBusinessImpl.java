package com.homeexpense.business.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.homeexpense.business.ExpensesBusiness;
import com.homeexpense.dao.MyHomeExpensesDAO;
import com.homeexpense.vo.Expenses;

@Service
public class ExpensesBusinessImpl implements ExpensesBusiness{

	@Autowired
	private MyHomeExpensesDAO expenseDao;
	
	@Override
	public boolean addExpenses(Expenses ex) {
expenseDao.addExpenses(ex);
		return false;
	}

	
}
