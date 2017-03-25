package payrollmanagerservice;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;

public class Activator implements BundleActivator {

	ServiceRegistration serviceRegistration;
	/*
	 * (non-Javadoc)
	 * @see org.osgi.framework.BundleActivator#start(org.osgi.framework.BundleContext)
	 */
	public void start(BundleContext bundleContext) throws Exception {
		System.out.println("Payroll Service Started Successfully!!!");
		  
		  SalaryCalculation salaryCalculation = new SalaryCalculationImplementation();

		  serviceRegistration = bundleContext.registerService(
		    SalaryCalculation.class.getName(), 
		    salaryCalculation, 
		    null
		    );
		  
		  salaryCalculation.employeeDetails(
		    1, 
		    "Sameera", 
		    "930390348V", 
		    "5000000"
		    );
		  salaryCalculation.employeeFinancialDetails(1, (float)100000, (float)0.12, 2017, 03);
		  
		  salaryCalculation.employeeDetails(
		    2, 
		    "Madumal", 
		    "930390348V", 
		    "345000"
		    );
		  salaryCalculation.employeeFinancialDetails(2, (float)10000, (float)0.14, 2017, 03);
		  System.out.println("Employee financial details added by payroll!");
	}

	/*
	 * (non-Javadoc)
	 * @see org.osgi.framework.BundleActivator#stop(org.osgi.framework.BundleContext)
	 */
	public void stop(BundleContext bundleContext) throws Exception {
		System.out.println("Payroll Service Stopped!");
		serviceRegistration.unregister();
	}

}