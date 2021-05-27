package com.payrollservice;

import static org.junit.Assert.assertEquals;
import java.util.Arrays;
import org.junit.Before;
import org.junit.Test;
import com.google.gson.Gson;
import io.restassured.RestAssured;
import io.restassured.response.Response;

public class PayrollService_test {
	
	@Before
	public void setup() {
		RestAssured.baseURI ="http://localhost";
		RestAssured.port = 3000;
	}
	
	public PayrollData[] getEmployeeList() {
		Response response = RestAssured.get("/Payroll");
		System.out.println("Payroll Data in JsonServer: "+response.asString());
		PayrollData[] empArray = new Gson().fromJson(response.asString(),PayrollData[].class);
		return empArray;
	}
	
	@Test
	public void givenpayrollData_whenreterived_shouldMatchtheCount() {
		PayrollData[] empArray = getEmployeeList();
		PayrollService payrollservice = new PayrollService(Arrays.asList(empArray));
		int entries = payrollservice.countEntries();
		assertEquals(3, entries);
	}

}
