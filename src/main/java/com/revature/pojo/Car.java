package com.revature.pojo;

public class Car {
	
	private String make;
	private String model;
	private int year;
	private float price;
	
	
	public String getMake()
	{
		return this.make;
	}
	
	public void setMake(String make) 
	{
		this.make = make;
	}
	
	public String getModel()
	{
		return this.model;
	}
	
	public void setModel(String model) 
	{
		this.model = model;
	}
	
	public int getYear()
	{
		return this.year;
	}
	
	public void setYear(int year) 
	{
		this.year = year;
	}
	
	public float getPrice()
	{
		return this.price;
	}
	
	public void setPrice(float price) 
	{
		this.price = price;
	}

	@Override
	public String toString() {
		return "Car [make=" + make + ", model=" + model + ", year=" + year + ", price=" + price + "]";
	}
}
