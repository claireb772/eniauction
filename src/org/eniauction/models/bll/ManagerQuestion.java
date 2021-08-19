package org.eniauction.models.bll;

import java.util.List;

import org.eniauction.dal.jdbc.DALException;
import org.eniauction.dal.jdbc.QuestionImpl;
import org.eniauction.dal.jdbc.UsersImpl;
import org.eniauction.models.bo.Question;
import org.eniauction.models.bo.Users;

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
	public boolean VerifUser(int idquestion, String Answer, String Email) throws DALException {
		QuestionImpl ui = QuestionImpl.getInstance();
		Question question = ui.VerifAnswer(idquestion, Answer, Email);


		if(question == null){
			return false;
		}
		else {
			return true;
		}
	}

}


