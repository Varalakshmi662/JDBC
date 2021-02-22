package com.xworkz.matrimony.dto;

public class BrideDTO {
	private int id;
	private String Name;
	private int Age;
	private double Height;
	private double Weight;
	private String Qualification;
	private String Phone_Number;
	private double salary;
	private String Occupation;
	private String Address;
	private String Expectations;

	public BrideDTO() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Bride [id=" + id + ", Name=" + Name + ", Age=" + Age + ", Height=" + Height + ", Weight=" + Weight
				+ ", Qualification=" + Qualification + ", Phone_Number=" + Phone_Number + ", salary=" + salary
				+ ", Occupation=" + Occupation + ", Address=" + Address + ", Expectations=" + Expectations + "]";
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public int getAge() {
		return Age;
	}

	public void setAge(int age) {
		Age = age;
	}

	public double getHeight() {
		return Height;
	}

	public void setHeight(double height) {
		Height = height;
	}

	public double getWeight() {
		return Weight;
	}

	public void setWeight(double weight) {
		Weight = weight;
	}

	public String getQualification() {
		return Qualification;
	}

	public void setQualification(String qualification) {
		Qualification = qualification;
	}

	public String getPhone_Number() {
		return Phone_Number;
	}

	public void setPhone_Number(String phone_Number) {
		Phone_Number = phone_Number;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	public String getOccupation() {
		return Occupation;
	}

	public void setOccupation(String occupation) {
		Occupation = occupation;
	}

	public String getAddress() {
		return Address;
	}

	public void setAddress(String address) {
		Address = address;
	}

	public String getExpectations() {
		return Expectations;
	}

	public void setExpectations(String expectations) {
		Expectations = expectations;
	}
	
}
