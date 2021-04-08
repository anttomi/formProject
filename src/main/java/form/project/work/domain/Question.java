package form.project.work.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Question {


	@Id
    	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	private String question;
	private String answer;
	private String type;
	
	public Question () {
	    
	}
	public Question(String question, String answer, String type) {
		super();
		this.question = question;
		this.answer = answer;
		this.type = type;
	}
	public String getType() {
	    return type;
	}
	public void setType(String type) {
	    this.type = type;
	}
	public String getQuestion() {
		return question;
	}
	public void setQuestion(String question) {
		this.question = question;
	}
	
	public Long getId() {
		return id;	
	}
	public void setId(Long id) {
		this.id = id;
	}

	public String getAnswer() {
		return answer;
	}
	public void setAnswer(String answer) {
		this.answer = answer;
	}
	
    	@Override
    	public String toString() {
    	    return "Question [id=" + id + ", question=" + question + ", answer=" + answer + ", type=" + type + "]";
    }
	
	
}
