package form.project.work.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;



@Entity
public class Question {


	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long questionid;
	private String title, type;
	private String[] choices;
	
	@ManyToOne
	@JoinColumn(name="survey")
	private Survey survey;
	
	@JsonIgnore
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "question")
	private List<Answer> answers;
	
	public Question () {
	    
	}
	
	
	public Question(Long id, String title, String type, String[] choices, Survey survey, List<Answer> answers) {
		super();
		this.questionid = id;
		this.title = title;
		this.type = type;
		this.choices = choices;
		this.survey = survey;
		this.answers = answers;
	}


	public Question(String title, String type, List<Answer> answers) {
	    super();
	    this.title = title;
	    this.type = type;
	    this.answers = answers;
	}


	public Question(String title, String type, String[] choices) {
		super();
		this.title = title;
		this.type = type;
		this.choices = choices;
		this.answers = new ArrayList<>();
		
	}
	
	public Question(String title, String type) {
		super();
		this.title = title;
		this.type = type;
	}



	public void setQuestionid(Long questionid) {
		this.questionid = questionid;
	}
	
	public Long getQuestionid() {
		return questionid;
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

	public List<Answer> getAnswers() {
		return answers;
	}
	
	public String[] getChoices() {
		return choices;
	}

	public void setChoices(String[] choices) {
		this.choices = choices;
	}

	public void setAnswers(List<Answer> answers) {
	this.answers = answers;
	}


	@Override
	public String toString() {
		return "Question [questionid=" + questionid + ", title=" + title + ", type=" + type + ", choices="
				+ Arrays.toString(choices) + ", survey=" + survey + "]";
	}
	
}
