package com.homeexpense.business;

import org.springframework.stereotype.Service;

import com.homeexpense.vo.Expenses;

@Service
public interface ExpensesBusiness {
	boolean addExpenses(Expenses ex);

}
