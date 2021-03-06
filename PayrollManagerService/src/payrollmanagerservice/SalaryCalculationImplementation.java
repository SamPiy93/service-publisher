package payrollmanagerservice;

import java.util.HashMap;
import java.util.Map;

public class SalaryCalculationImplementation implements SalaryCalculation{
	 
	 
	 @Override
	 public Map<Integer, String[]> getEmployeeDetails() {
	  return Activator.employeeMap;
	 }
	 @Override
	 public Map<Integer, String[]> getEmployeeFinancialDetails() {
	  return Activator.financialDetails;
	 }
	 @Override
	 public double calculateEpf12(float basicSalary) {
	  return basicSalary*(0.12);
	 }

	 @Override
	 public double calculateEpf8(float basicSalary) {
	  return basicSalary*(0.08);
	 }

	 @Override
	 public double calculateEtf3(float basicSalary) {
	  return basicSalary*(0.03);
	 }

	 @Override
	 public double calculateLoanDeduction(float loanAmount, float interestRate) {
	  return loanAmount*interestRate;
	 }

	 @Override
	 public double calculateNetSalary(float basicSalary, float epf8, float etf3, float loanDeductions) {
	  return (basicSalary-epf8-etf3-loanDeductions);
	 }

	 @Override
	 public void employeeDetails(int id, String name, String nic, String basicSalary) {
		 Activator.employeeMap.put(
	    id, 
	    new String[] {
	    name, 
	    nic, 
	    basicSalary
	    });
	  System.out.println("Employee personal details recorded successfully!");
	 }

	 @Override
	 public void employeeFinancialDetails(int id, float loanAmount, float interestRate, int year, int month) {
	  float basic = Float.parseFloat(Activator.employeeMap.get(id)[2]);
	  double epf12 = this.calculateEpf12(basic);
	  double epf8 = this.calculateEpf8(basic);
	  double etf3 = this.calculateEtf3(basic);
	  double loanDeductions = this.calculateLoanDeduction(loanAmount, interestRate);
	  double netSalary = this.calculateNetSalary(basic, (float)epf8, (float)etf3, (float)loanDeductions);
	  
	  Activator.financialDetails.put(
	    id, 
	    new String[] {
	    String.valueOf(basic),
	    String.valueOf(epf12),
	    String.valueOf(epf8),
	    String.valueOf(etf3),
	    String.valueOf(loanDeductions),
	    String.valueOf(netSalary)
	    });
	  System.out.println("Employee financial details recorded successfully!");
	 }
}
