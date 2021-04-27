package form.project.work.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;



@Entity
public class Question {


	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	private String title, type;
	
	@ManyToOne
	@JoinColumn(name="survey")
	private Survey survey;
	
	@OneToMany
	@JoinColumn(name="answer")
	private Answer answer;
	
	public Question () {
	    
	}

	public Question(String title,String type, String[] choices) {
		super();
		this.title = title;
		this.type = type;
		
	}

	public Survey getSurvey() {
	    return survey;
	}

	public void setSurvey(Survey survey) {
	    this.survey = survey;
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
