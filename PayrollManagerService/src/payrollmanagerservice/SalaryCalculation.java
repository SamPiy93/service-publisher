package payrollmanagerservice;

import java.util.Map;

public interface SalaryCalculation {
	 /**
	  * Method to get employee personal details
	  * @return employee personal details hash map
	  */
	 public Map<Integer, String[]> getEmployeeDetails();
	 /**
	  * Method to get employee financial details
	  * @return financial details map
	  */
	 public Map<Integer, String[]> getEmployeeFinancialDetails();
	 /**
	  * Method to enter employee details
	  * @param id employee id
	  * @param name employee name
	  * @param nic employee nic
	  * @param basicSalary basic salary of employee
	  */
	 public void employeeDetails(int id, String name, String nic, String basicSalary);
	 /**
	  * Method to enter employees financial details
	  * @param id employee id 
	  * @param loanAmount employee existing loan amount
	  * @param interestRate interest rate for loans
	  * @param year current year
	  * @param month current month
	  */
	 public void employeeFinancialDetails(int id, float loanAmount, float interestRate, int year, int month);
	 /**
	  * Method to calculate epf 12%
	  * @param basicSalary
	  * @return epf 12% amount from basic salary
	  */
	 public double calculateEpf12(float basicSalary);
	 /**
	  * Method to calculate epf 8%
	  * @param basicSalary
	  * @return epf 8% amount from basic
	  */
	 public double calculateEpf8(float basicSalary);
	 /**
	  * Method to calculate etf 3%
	  * @param basicSalary
	  * @return etf 3% amount from basic salary
	  */
	 public double calculateEtf3(float basicSalary);
	 /**
	  * Method to calculate loan deductions per month
	  * @param loanAmount
	  * @param interestRate should be monthly interest rate
	  * @return amount that should be deducted from the employee's monthly earnings
	  */
	 public double calculateLoanDeduction(float loanAmount, float interestRate);
	 /**
	  * Method to calculate gross salary
	  * @param basicSalary
	  * @param epf8
	  * @param etf3
	  * @param loanDeductions
	  * @return amount to be paid for the employee
	  */
	 public double calculateNetSalary(float basicSalary, float epf8, float etf3, float loanDeductions);
}
