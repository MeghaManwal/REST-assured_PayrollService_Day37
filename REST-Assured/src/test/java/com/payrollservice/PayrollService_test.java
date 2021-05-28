package com.payrollservice;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;
import java.util.Arrays;
import org.junit.Before;
import org.junit.Test;
import com.google.gson.Gson;
import static io.restassured.RestAssured.*;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class PayrollService_test {
	
	@Before
	public void setup() {
		baseURI ="http://localhost";
		port = 3000;
	}
	
	public PayrollData[] getEmployeeList() {
		Response response = get("/Payroll");
		System.out.println("Payroll Data in JsonServer: "+response.asString());
		PayrollData[] empArray = new Gson().fromJson(response.asString(),PayrollData[].class);
		return empArray;
	}
	
	@Test
	public void givenpayrollData_whenreterived_shouldMatchtheCount() {
		PayrollData[] empArray = getEmployeeList();
		PayrollService payrollservice = new PayrollService(Arrays.asList(empArray));
		int entries = payrollservice.countEntries();
		assertEquals(4, entries);
	}
	
	public Response addPayrollRecord(PayrollData payrolldata) {
		String empJson = new Gson().toJson(payrolldata);
		RequestSpecification request = given();
		request.header("Content-Type", "application/json");
		System.out.println(empJson);
		request.body(empJson);
		return request.post("/Payroll");
	}
	
	@Test
	public void givennewPayrollRecord_whenAdded_shouldreturn201statusCode() {
		PayrollData[] empArray = getEmployeeList();
		PayrollService payrollservice = new PayrollService(Arrays.asList(empArray));
				
		PayrollData payrolldata = new PayrollData("Rachel", "Brown", "F", 56000);
		
		Response response = addPayrollRecord(payrolldata);
		System.out.println(response.asString());
		int statusCode = response.getStatusCode();
		assertEquals(201, statusCode);
		
		payrolldata = new Gson().fromJson(response.asString(), PayrollData.class);
		payrollservice.addRecordToPayroll(payrolldata);
		int entries = payrollservice.countEntries();
		assertEquals(4, entries);
		
	}
}
