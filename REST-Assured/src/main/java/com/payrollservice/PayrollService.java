package com.payrollservice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PayrollService {
	
	@Override
	public String toString() {
		return "PayrollService [payroll=" + payroll + "]";
	}

	private List<PayrollData> payroll;
	
	public PayrollService() {
		
	}
	
     public PayrollService(List<PayrollData> list) {
		this.payroll = new ArrayList<>(list);
	 }

	public int countEntries() {
		return  payroll.size();
	}

	public void addRecordToPayroll(PayrollData payrolldata) {
		payroll.add(payrolldata);
		
	}
	
	public void addRecordToPayroll(PayrollData[] payrolldata) {
		payroll = Arrays.asList(payrolldata);
	}
   
}
