package com.revature.service;

import com.revature.pojo.Car;

public class AddingCarService {
	
	private static Car[] carDB;

	private static int carIndex;
	
	public Car AddCar(String make, String model, int year, float price) {

	    Car newCar = new Car();
	    
		newCar.setMake(make);
		newCar.setModel(model);
		newCar.setYear(year);
		newCar.setPrice(price);

		carDB[carIndex] = newCar;
		carIndex++;

		return newCar;

	}
	
	private int findCarIndex(Car car) {
		for (int i = 0; i < carIndex; i++) {
			if (carDB[i] != null) {		
					return i;
			}
		}
		return -1; // denotes the user was not found
	}
	
	public void removeCar(Car car) {
		int index = findCarIndex(car);
		if (index > -1) {
			carDB[index] = carDB[carIndex - 1];
			carDB[carIndex - 1] = null;
			carIndex--;
		}
	}
	
	public AddingCarService() 
	{
		carDB = new Car[10];
		carIndex = 0;
	}

}
