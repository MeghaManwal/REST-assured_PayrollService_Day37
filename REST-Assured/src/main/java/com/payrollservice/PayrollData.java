package com.payrollservice;

public class PayrollData {
	
	private int Id;
	private String firstName;
	private String lastName;
	private String Gender;
	private int BasicPay;
	
	public int getId() {
		return Id;
	}
	public void setId(int id) {
		this.Id = id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getGender() {
		return Gender;
	}
	
	public void setGender(String gender) {
		Gender = gender;
	}
	public int getBasicPay() {
		return BasicPay;
	}
	public void setBasicPay(int basicPay) {
		BasicPay = basicPay;
	}
	@Override
	public String toString() {
		return "PayrollData [Id=" + Id + ", firstName=" + firstName + ", lastName=" + lastName + ", Gender=" + Gender
				+ ", BasicPay=" + BasicPay + "]";
	}
	
	
	
}
