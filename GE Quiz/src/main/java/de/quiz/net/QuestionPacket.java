package de.quiz.net;

public class QuestionPacket extends Packet {
	
	private String question;
	private String[] answers;
	
	public QuestionPacket(String question, String answer1, String answer2, String answer3, String answer4) {
		this.answers = new String[4];
		
		this.question = question;
		this.answers[0] = answer1;
		this.answers[1] = answer2;
		this.answers[2] = answer3;
		this.answers[3] = answer4;
	}
	
	@Override
	public void get() {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void send() {
		// TODO Auto-generated method stub
		
	}
	
	public String getQuestion() {
		return question;
	}
	
	public String[] getAnswers() {
		return answers;
	}
	
}
