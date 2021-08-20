package org.eniauction.models.bo;

public class Question {


    private int question_id;
    private String question;
    private String email;
    private String answer;
	
	public Question(int question_id, String question) {
		super();
		this.question_id = question_id;
		this.question = question;
	}

	


	public Question(int question_id, String email, String answer) {
		super();
		this.question_id = question_id;
		this.email = email;
		this.answer = answer;
	}




	public int getQuestion_id() {
		return question_id;
	}
	public void setQuestion_id(int question_id) {
		this.question_id = question_id;
	}
	public String getQuestion() {
		return question;
	}
	public void setQuestion(String question) {
		this.question = question;
	}




	public String getEmail() {
		return email;
	}




	public void setEmail(String email) {
		this.email = email;
	}




	public String getAnswer() {
		return answer;
	}




	public void setAnswer(String answer) {
		this.answer = answer;
	}

   
	
}
