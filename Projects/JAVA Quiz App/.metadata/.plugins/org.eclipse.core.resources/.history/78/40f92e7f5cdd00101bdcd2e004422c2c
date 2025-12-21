package com.app.service;

import java.util.List;
import java.util.Scanner;

import com.app.dao.QuestionsDao;
import com.app.dao.QuizDao;
import com.app.model.Quiz;
import com.app.dao.*;

public class AdminService {
	public static void createQuiz(Scanner sc) {
		System.out.println("Enter the quiz name: ");
		String quizName = sc.next();
		System.out.println("Enter the creatir id: ");
		int creator_id = sc.nextInt();
		try {
			QuizDao qd = new QuizDao();
			qd.addQuizTitle(quizName, creator_id);
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		System.out.println("Enter the path of .txt file(questions): ");
		String path = sc.next();
		try {
			QuestionsDao qs = new QuestionsDao();
			qs.loadQuestions(quizName,path);
			
		}catch(Exception e) {
			e.printStackTrace();
		}

	}

	public static void displayQuizzes() {
		System.out.println("==All Available Quizzes==");
		try {
			QuizDao quiz = new QuizDao();
			List<Quiz> quizList = quiz.getQuizList();
			for(Quiz ls : quizList) {
				System.out.println(ls);
			}
			
		}catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void viewResult() {

	}

	public static void deleteQuiz(Scanner sc) {
		System.out.println("Enter quiz_id to delete: ");
		int quiz_id = sc.nextInt();
		try {
			QuizDao quiz = new QuizDao();
			quiz.deleteQuiz(quiz_id);
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		System.out.println("Deleted quiz with id: "+ quiz_id);
	}
}
