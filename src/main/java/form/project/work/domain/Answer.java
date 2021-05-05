package form.project.work.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Answer {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
	private String input;
	
	
//	@ManyToOne
//	@JoinColumn(name="questionid")
//	private Question question;
	
	
	public Answer(String input) {
		super();
		this.input = input;
	}


	public Answer() {

	}


	public long getId() {
		return id;
	}


	public void setId(long id) {
		this.id = id;
	}
	

//	public Question getQuestion() {
//		return question;
//	}
//
//
//	public void setQuestion(Question question) {
//		this.question = question;
//	}


	public String getInput() {
		return input;
	}


	public void setInput(String input) {
		this.input = input;
	}


	@Override
	public String toString() {
	    return "Answer [id=" + id + ", input=" + input + ", question=" + "]";
	}

}


