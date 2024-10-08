package com.example.moviebooking.viewviewmodel.login;

import com.example.moviebooking.dto.Admin;
import com.example.moviebooking.dto.User;
import com.example.moviebooking.viewviewmodel.BaseScreen;
import com.example.moviebooking.viewviewmodel.admin.AdminView;
import com.example.moviebooking.viewviewmodel.users.UserView;

import java.util.Scanner;



public class LoginView extends BaseScreen {
	private Scanner scanner;
	private LoginController loginController;
	public LoginView() {
		this.loginController = new LoginController(this);
		this.scanner = new Scanner(System.in);
	}
	public void onCreate(){
		if(hasCheckNetworkConnection()){
			display();
		}else{
			System.out.println("Check your Internet Connection...........");
		}
	}
	public void display() {
		System.out.println("_____________________________Welcome to Cinema Thalainagaram_____________________________");

		String choice = "";
		while (!choice.equals("0")) {
			System.out.println("\n----------Main Menu----------");
			System.out.println("1. Login as Admin");
			System.out.println("2. Customer Menu");
			System.out.println("0. Exit");
			System.out.print("Enter your choice : ");
			choice = scanner.nextLine();
			switch (choice) {
				case "1":
					displayAdminLogin();
					break;
				case "2":
					displayUserrMenu();
					break;
				case "0":
					break;
				default:
					System.out.println("Invalid choice!\n");
			}
		}

		System.out.println("\n_________________________Thank you for using Cinema Thalainagaram_________________________\n");
	}

	private void displayAdminLogin() {
		System.out.println("\n----------Admin Login----------");
		Admin admin = null;
		while (admin == null) {
			System.out.print("Enter name : ");
			String name = scanner.nextLine();
			while (!loginController.validateName(name)) {
				System.out.println("Invalid name! (name should be at least 3 characters long and alphabets only)");
				System.out.print("Enter name : ");
				name = scanner.nextLine();
			}
			System.out.print("Enter Admin password : ");
			String password = scanner.nextLine();
			admin = loginController.authenticateAndGetAdmin(name, password);
			if (admin == null) {
				System.out.println("Invalid password");
				System.out.println("Do you want to try again? (y/n)");
				if (!scanner.nextLine().equals("y")) {
					return;
				}
			}
		}
		AdminView adminView= new AdminView();
		adminView.displayAdminMenu();

	}

	private void displayUserrMenu() {
		System.out.println("\n----------Customer Menu----------");
		String choice = "";
		while (!choice.equals("0")) {
			System.out.println("1. Login");
			System.out.println("2. Register");
			System.out.println("0. Exit");
			choice = scanner.nextLine();
			switch (choice) {
				case "1":
					if (!userLogin())
						break;
					break;
				case "2":
					userRegister();
					break;
				case "0":
					break;
				default:
					System.out.println("Invalid choice!\n");
			}
		}
	}

	private boolean userLogin() {
		User user = null;
		System.out.println("Please enter your phone number : ");
		String phoneNumber = scanner.nextLine();
		while (!loginController.validatePhoneNumber(phoneNumber)) {
			System.out.println("Invalid phone number! (phone number should be 10 digits)");
			System.out.print("Please enter a valid phone number : ");
			phoneNumber = scanner.nextLine();
		}
		System.out.println("Enter password : ");
		String password = scanner.nextLine();
		user = loginController.authenticateAndGetUser(phoneNumber, password);
		if (user == null) {
			System.out.println("Invalid Phone Number or password!");
			return false;
		}
		UserView userView =new UserView();
		userView.displayUserMenu();
		return true;
	}

	private void userRegister() {
		System.out.println("Please enter your name : ");
		String name = scanner.nextLine();
		while (!loginController.validateName(name)) {
			System.out.println("Invalid name! (name should be at least 3 characters long and alphabets only)");
			System.out.print("Please enter a valid name : ");
			name = scanner.nextLine();
		}
		System.out.println("Please enter your phone number : ");
		String phoneNumber = scanner.nextLine();
		while (!loginController.validatePhoneNumber(phoneNumber)) {
			System.out.println("Invalid phone number! (phone number should be 10 digits)");
			System.out.print("Please enter a valid phone number : ");
			phoneNumber = scanner.nextLine();
		}
		System.out.println("Enter password :");
		String password = scanner.nextLine();
		loginController.registerUser(name, phoneNumber, password);
	}


}
