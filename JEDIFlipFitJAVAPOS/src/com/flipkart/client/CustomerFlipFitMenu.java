package com.flipkart.client;
import java.util.*;
import com.flipkart.bean.GymUser;

public class CustomerFlipFitMenu {
	GymUser customer = new GymUser();
	Scanner sc = new Scanner(System.in);
	public void customerMenu(String email) {
		int choice = 0;

		while (choice != 8) {
			System.out.println("Menu:-");
			System.out.println("1.Select Gym in Bangalore \n2.View Available Slots \n3.View Bookings \n4.Book Slot \n5.Cancel Slot \n6.View Profile \n7.Edit Profile \n8.Exit");
			System.out.print("Enter your choice: ");
			choice = sc.nextInt();

			switch (choice) {
				case 1:
//					viewGyms(email);
					break;
				case 2:
//					viewAvailableSlots();
					break;
				case 3:
//					customerBusiness.getBookings(email);
					break;
				case 4:
//					bookSlot();
					break;
				case 5:
//					cancelBooking(email);
					break;
				case 6:
//					viewProfile(email)
					break;
				case 7:
//					editProfile(email);
				case 8:
					break;
				default:
					System.out.println("Invalid choice!");
			}
		}

	}

	public void registerCustomer() {
		System.out.print("Enter email: ");
		customer.setName(sc.next());
		System.out.print("Enter password: ");
		customer.setPassword(sc.next());
		System.out.print("Enter Name: ");
		customer.setName(sc.next());
		System.out.print("Enter Phone Number: ");
		customer.setPhoneNumber(sc.next());
		System.out.print("Enter Age: ");
		customer.setAge(Integer.valueOf(sc.next()));
		System.out.print("Enter Address: ");
		customer.setAddress(sc.next());
//		UserBusiness userBusiness = new UserBusiness();
//		userBusiness.registerCustomer(customer);

		System.out.println("Customer registered successfully!");


	}



}
