package org.eniauction.dal.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.eniauction.dal.QuestionDAO;
import org.eniauction.models.bo.Question;

public class QuestionImpl implements QuestionDAO {

	static Logger log = Logger.getLogger(QuestionImpl.class);

	private static QuestionImpl instance;

	public static QuestionImpl getInstance() {

		if (instance == null) {
			instance = new QuestionImpl();
		}

		return instance;
	}

	private static final String SELECT_ALL_QUESTION = "select * from QUESTION";



	public List<Question> selectAllQuestion() throws DALException {

		List<Question> ListQuestion = new ArrayList<Question>();
		try (Connection cnx = ConnectionProvider.getConnection()) {
			PreparedStatement pstmt = cnx.prepareStatement(SELECT_ALL_QUESTION);
			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {
				Question question = new Question(rs.getInt("question_id"), rs.getString("question"));
				ListQuestion.add(question);
			}

			cnx.close();
		} catch (Exception e) {
			e.printStackTrace();
			log.error("Erreur dans le select All ", e);
			throw new DALException("Erreur dans le select All ", e);
		}
		return ListQuestion;

	}



	@Override
	public List<Question> selectAll() throws DALException {
		// TODO Auto-generated method stub
		return null;
	}
}
