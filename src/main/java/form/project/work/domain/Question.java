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
	private String title, answer, type;
	
	public Question () {
	    
	}

	public Question(String title, String answer, String type) {
		super();
		this.title = title;
		this.answer = answer;
		this.type = type;
	}



	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAnswer() {
		return answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	@Override
	public String toString() {
		return "Question [id=" + id + ", title=" + title + ", answer=" + answer + ", type=" + type + "]";
	}
	
	
	
}
