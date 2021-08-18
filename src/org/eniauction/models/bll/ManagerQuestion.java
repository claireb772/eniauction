package org.eniauction.models.bll;

import java.util.List;

import org.eniauction.dal.jdbc.DALException;
import org.eniauction.dal.jdbc.QuestionImpl;
import org.eniauction.models.bo.Question;

public class ManagerQuestion {

	private static ManagerQuestion instance;

	public static ManagerQuestion getInstance() {

		if (instance == null) {
			instance = new ManagerQuestion();
		}
		return instance;
	}


	public List<Question> getAllQuestion() throws DALException {
		QuestionImpl ui = QuestionImpl.getInstance();
		return ui.selectAllQuestion();
		
	}


}
