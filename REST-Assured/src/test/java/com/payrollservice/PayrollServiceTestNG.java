package com.payrollservice;

import static io.restassured.RestAssured.*;
import org.json.simple.JSONObject;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import io.restassured.http.ContentType;

public class PayrollServiceTestNG {
	
	@DataProvider(name = "dataforpost")
	public Object[][] dataforPost() {
		return new Object[][] {
			{"Rizvaan", "Khan", "M", 66000},
			{"Nia", "James","F",75000},
			{"Robert", "Hook","M",85000}
		};	
	}
	
	@Test(dataProvider = "dataforpost")
	public void givenMultipleRecords_shouldReturn_201statusCode(String firstName, String lastName, String Gender, int BasicPay) {
		JSONObject request = new JSONObject();
		
		request.put("firstName", firstName);
		request.put("lastName",  lastName);
		request.put("Gender", Gender);
		request.put("BasicPay", BasicPay);
		
		baseURI ="http://localhost";
		port = 3000;
		
		given().
		       contentType(ContentType.JSON).
		       accept(ContentType.JSON).
		       header("Content-Type", "application/json").
		       body(request.toJSONString()).
		when().
		      post("/Payroll").
		then().
		      statusCode(201).
		      log().all();
	}
	
	@Test
	public void updateExistingRecord_shouldReturn_200statusCode() {
		JSONObject request = new JSONObject();
		request.put("lastName",  "Stuart");

		baseURI ="http://localhost";
		port = 3000;

		given().
		       contentType(ContentType.JSON).
		       accept(ContentType.JSON).
		       header("Content-Type", "application/json").
		       body(request.toJSONString()).
		when().
		      patch("/Payroll/4").
		then().
		      statusCode(200).
		      log().all();

		
	}
}
