package com.app.menu;

import java.util.Scanner;

import com.app.dao.UserDao;
import com.app.model.User;
import com.app.service.StudentService;

public class StudentMenu {

	public static int options(Scanner sc) {
		System.out.println("=== Student Menu === ");
		System.out.println("1. View quizzes");
		System.out.println("2. Take Quiz");
		System.out.println("3. View Score");
		System.out.println("4. Logout");
		System.out.print("Enter your choice: ");
		return sc.nextInt();
	}

	public static void getStudentMenu(Scanner sc) {
		int choice;
		if (StudentService.authenticateStudent(sc)) {
			System.out.println("Student login success!\n");
			while ((choice = options(sc)) != 0) {
				switch (choice) {
				case 1:
					StudentService.viewQuizzes();
					break;
				case 2:
					StudentService.takeQuiz();
					break;
				case 3:
					StudentService.viewScore();
					break;
				case 4:
					System.out.println("Logged Out!\n");
					break;
				default:
					throw new IllegalArgumentException("Invalid choice value: " + choice);
				}
				if (choice == 4)
					break;
			}
		} else
			System.out.println("Login Failed!");

	}
}
