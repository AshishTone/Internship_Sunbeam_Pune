package com.app.menu;

import java.util.Scanner;

import com.app.dao.UserDao;
import com.app.service.*;

public class AdminMenu {
	public static int options(Scanner sc) {
		System.out.println("=== Admin Menu === ");
		System.out.println("1. Create quiz");
		System.out.println("2. Display Quizzes");
		System.out.println("3. View Result");
		System.out.println("4. Delete Quiz");
		System.out.println("5. Logout");
		System.out.print("Enter your choice: ");
		return sc.nextInt();
	}

	public static boolean authenticateAdmin(Scanner sc) {
		System.out.print("Enter Admin username: ");
		String username = sc.next();
		System.out.print("Enter Admin password: ");
		String password = sc.next();
		if (UserDao.adminLogin(username, password))
			return true;
		return false;
	}
	

	public static void getadminMenu(Scanner sc) {
		int choice;

		if (authenticateAdmin(sc)) {
			System.out.println("Admin login success ");
			while ((choice = options(sc)) != 0) {
				switch (choice) {
				case 1:
					AdminService.createQuiz(sc);
					break;
				case 2:
					AdminService.displayQuizzes();
					break;
				case 3:
					AdminService.viewResult();
					break;
				case 4:
					AdminService.deleteQuiz(sc);
					break;
				case 5:
					System.out.println("Logged Out!\n");
					break;
				default:
					throw new IllegalArgumentException("Invalid choice value: " + choice);
				}
				if(choice == 5) {
					break;
				}
			}
		} else
			System.out.println("Admin Login Failed!");

	}
}
