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
	private String[] choices;
	
	
	@ManyToOne
	@JoinColumn(name="question")
	private Question question;
	


	public Answer(String[] choices) {
		super();
		this.choices = choices;

	}


	public Answer() {

	}


	public long getId() {
		return id;
	}


	public void setId(long id) {
		this.id = id;
	}


	public String[] getChoices() {
		return choices;
	}


	public void setChoices(String[] choices) {
		this.choices = choices;
	}
	

}


