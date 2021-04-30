package form.project.work.domain;

import java.util.ArrayList;
import java.util.List;

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
	private String[] choices;
	
	@OneToMany
	@JoinColumn(name="answer")
	private List<Answer> answers;
	
	public Question () {
	    
	}

	
	public Question(String title, String type, List<Answer> answers) {
	    super();
	    this.title = title;
	    this.type = type;
	    this.answers = answers;
	}


	public Question(String title, String type, String[] choices, List<Answer> answers) {
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
	
}
