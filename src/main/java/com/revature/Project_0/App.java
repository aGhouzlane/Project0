package com.revature.Project_0;

import java.util.Scanner;

import com.revature.pojo.Car;
import com.revature.pojo.Employee;
import com.revature.pojo.User;
import com.revature.service.AddingCarService;
import com.revature.service.EmployeeLoginService;
import com.revature.service.UserLoginService;

/**
 * Hello world!
 *
 */

public class App {
	private static UserLoginService uls = new UserLoginService();
	private static EmployeeLoginService els = new EmployeeLoginService();
	private static AddingCarService acs = new AddingCarService();
	private static Car car = new Car();
	private static User user = new User();
	private static Scanner scan = new Scanner(System.in);

	public static void main(String[] args) {

		mainMenu();
	}


	private static void mainMenu() {
		
		System.out.println("Welcome to Our Dealership!");
		System.out.println("Please make a selection:");
		System.out.println("[1] Register");
		System.out.println("[2] Login");
		System.out.println("[3] Exit");
		
		Scanner input = new Scanner(System.in);

		switch (input.nextInt()) {
		case 1:
			registerMenu();
			break;
		case 2:
			loginMenu();
			break;
		case 3:
			return;
		default:
			System.out.println("Did not understand input, Please try again!");
			mainMenu();
			break;
		}
	}

	private static void registerMenu() {

		System.out.println("[1] register as User");
		System.out.println("[2] register as Employee");
		System.out.println("[3] main menu");

		Scanner registerInput = new Scanner(System.in);

		switch (registerInput.nextInt()) {
		case 1:
			User user = getUserInfo();
			uls.registerUser(user.getUsername(), user.getPassword());
			System.out.println("User is successfully registered.");
			mainMenu();
			break;
		case 2:
			Employee employee = getEmployeeInfo();
			els.registerEmployee(employee.getEmployeeName(), employee.getPassword());
			System.out.println("Employee is successfully registered.");
			mainMenu();
			break;
		case 3:
			mainMenu();
			break;
		}
	}

	private static void loginMenu() {
		System.out.println("[1] Login as User");
		System.out.println("[2] Login as Employee");
		System.out.println("[3] main menu");

		Scanner loginInput = new Scanner(System.in);

		switch (loginInput.nextInt()) {
		case 1:
			if (((UserLoginService) uls).authenticateUser(getUserInfo())) {
				System.out.println("success");
				userMenu();
			} else {
				System.out.println("failure");
			}
			break;
		case 2:
			if (((EmployeeLoginService) els).authenticateEmployee(getEmployeeInfo())) {
				System.out.println("success");
				employeeMenu();
			} else {
				System.out.println("failure");
			}
			break;
		case 3:
			mainMenu();
			break;
		}
	}

	private static User getUserInfo() {
		
		System.out.println("Enter username:");
		user.setUsername(scan.nextLine());
		System.out.println("Enter password:");
		user.setPassword(scan.nextLine());
		return user;
	}

	private static Employee getEmployeeInfo() {
		Employee employee = new Employee();
		System.out.println("Enter Employee Name:");
		employee.setEmployeeName(scan.nextLine());
		System.out.println("Enter Employee password");
		employee.setPassword(scan.nextLine());
		return employee;
	}

	private static void employeeMenu() {
		
		System.out.println("Welcome to the Employee Menu!");
		System.out.println("Please Make a Selection:");
		System.out.println("[1] To Add a Car");
		System.out.println("[2] To Remove a Car");
		System.out.println("[3] To Accept/Reject an Offer");
		System.out.println("[4] Main menu");

        
		switch (scan.nextInt()) {
		case 1:
			addCar();
			System.out.println("Car was added successfully!");
			employeeMenu();
			break;
		case 2:
			acs.removeCar(car);
			break;
		case 3:
			//TODO: Accept/Reject offer
			break;
		case 4:
			mainMenu();
			break;
		}	
	}

	private static void userMenu() {
		System.out.println("Welcome to the user menu!");
		System.out.println("Please make a selection:");
		System.out.println("[1] view a car");
		System.out.println("[2] Make an offer");
		System.out.println("[3] View owned cars");
		System.out.println("[4] Main menu");

		Scanner userInput = new Scanner(System.in);

		switch (userInput.nextInt()) {
		case 1:
			viewCar();
			break;
		case 2:
            //TODO: make an offer
			break;
		case 3:
            //TODO: view owned cars
			break;
		case 4:
			mainMenu();
			break;
		}
	}

	private static Car addCar() {
		System.out.println("Enter Car Make:");
		car.setMake(scan.nextLine());
		System.out.println("Enter Car Model:");
		car.setModel(scan.nextLine());
		System.out.println("Enter Car Year:");
		car.setYear(scan.nextInt());
		System.out.println("Enter Car Price:");
		car.setPrice(scan.nextFloat());
		return car;
	}
	
	private static void viewCar() 
	{
		System.out.println(car.toString());
	}

}
