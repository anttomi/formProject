package form.project.work.domain;

public class Question {

	private long id;
	private String question;
	private String answer;
	
	
	public Question(String question, String answer) {
		super();
		this.question = question;
		this.answer = answer;
	}
	public String getQuestion() {
		return question;
	}
	public void setQuestion(String question) {
		this.question = question;
	}
	
	public long getId() {
		return id;	
	}
	public void setId(long id) {
		this.id = id;
	}

	public String getAnswer() {
		return answer;
	}
	public void setAnswer(String answer) {
		this.answer = answer;
	}
	
	
}
