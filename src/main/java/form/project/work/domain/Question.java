package form.project.work.domain;

import javax.persistence.Column;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;



@Entity
@Data
public class Question {


	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	@Column
    @NotNull(message="{NotNull.Question.question}")
	private String question;
	
	@Column(message="Question.question}")
	private String answer;
	
	@Column
	@NotNull(message="{NotNull.Question.question}")
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
