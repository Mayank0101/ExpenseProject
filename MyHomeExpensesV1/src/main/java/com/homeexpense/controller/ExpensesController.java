package com.homeexpense.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.homeexpense.business.ExpensesBusiness;
import com.homeexpense.vo.Expenses;

@RestController
@RequestMapping("/Expenses")
public class ExpensesController {
	
	@Autowired
	private ExpensesBusiness expenseBiz;
	
	
	@RequestMapping("/getExpenses")
	public String getExpenses() {
		return "HelloWorld";
	}
	
	@RequestMapping(value="/addExpenses",method=RequestMethod.POST)
	public boolean addExpenses(@RequestBody Expenses expenses) {
		System.out.println(expenses.getEndDate());
		expenseBiz.addExpenses(expenses);
		return true;
	}
	@GetMapping("/removeExpenses")
	public boolean removeExpenses(@PathVariable String studentId) {
		return false;
	}
	@GetMapping("/updateExpenses/{startDate}/and/{endDate}")
	public boolean updateExpenses(@PathVariable String studentId) {
		return false;
	}
	
}
