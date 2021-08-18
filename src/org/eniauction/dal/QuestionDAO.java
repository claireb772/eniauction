package org.eniauction.dal;

import java.util.List;

import org.eniauction.dal.jdbc.DALException;
import org.eniauction.models.bo.Question;

public interface QuestionDAO {

	List<Question> selectAll() throws DALException;

}
