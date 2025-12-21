package com.app.dao;

import java.util.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.io.*;
import java.util.*;
import com.app.model.*;
import com.app.util.Dbutil;

public class QuizDao implements AutoCloseable{
	private static Connection connection = null;

	public QuizDao() throws SQLException {
		connection = Dbutil.getConnection();
	}
	

	public void addQuizTitle(String quizName,int creator_id) throws SQLException {
		String sql = "insert into quizzes(title, creator_id) values(?,?)";
		PreparedStatement inserQuizTitle = connection.prepareStatement(sql);
		inserQuizTitle.setString(1, quizName);
		inserQuizTitle.setInt(2, 1);
		inserQuizTitle.executeUpdate();
	}
	
	public List<Quiz> getQuizList() throws SQLException{
		List<Quiz> ls = new ArrayList<>();
		String sql = "SELECT * FROM quizzes";
		PreparedStatement selectQuiz = connection.prepareStatement(sql);
		ResultSet rs = selectQuiz.executeQuery();
		while(rs.next()) {
			Quiz quiz = new Quiz();
			quiz.setTitle(rs.getString(2));
			ls.add(quiz);
		}
		return ls;
	}
	
	public void deleteQuiz(int quiz_id) throws SQLException {
		String sql = "DELETE FROM quizzes where quiz_id = ?";
		PreparedStatement deleteStatement = connection.prepareStatement(sql);
		deleteStatement.setInt(1, quiz_id);
		deleteStatement.executeUpdate();
	}
	
	@Override
	public void close() throws SQLException {
		if (connection != null) {
			connection.close();
			connection = null;
		}
	}

}
