package com.app.dao;

import java.io.File;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.app.model.Question;
import com.app.util.Dbutil;
import com.app.util.QuestionFileParser;

public class QuestionsDao implements AutoCloseable {

	private Connection connection = null;

	public QuestionsDao() throws SQLException {
		connection = Dbutil.getConnection();
	}

	public void loadQuestions(String quizName, String path) throws SQLException {

		try {
			List<Question> questionsList = QuestionFileParser.parse(new File(path));
			String sqlQuizName = "SELECT quiz_id FROM quizzes WHERE title = ?";
			PreparedStatement selectQuizTitle = connection.prepareStatement(sqlQuizName);
			selectQuizTitle.setString(1, quizName);
			ResultSet rs1 = selectQuizTitle.executeQuery();

			String quesSql = "INSERT INTO questions (quiz_id, question_text, option_a, option_b, option_c, option_d, correct_option) VALUES (?,?,?,?,?,?,?)";
			PreparedStatement insertQuestion = connection.prepareStatement(quesSql);

			rs1.next();
			int qid = rs1.getInt("quiz_id");
			for (Question q : questionsList) {
				insertQuestion.setInt(1, qid);
				insertQuestion.setString(2, q.text);
				insertQuestion.setString(3, q.a);
				insertQuestion.setString(4, q.b);
				insertQuestion.setString(5, q.c);
				insertQuestion.setString(6, q.d);
				insertQuestion.setString(7, String.valueOf(q.correct));
				insertQuestion.executeUpdate();
			}
			System.out.println("Quiz title and Questions from .txt added!");
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Override
	public void close() throws SQLException {
		if (connection != null) {
			connection.close();
			connection = null;
		}
	}

}
