package form.project.work.web;

import java.util.List;
import java.util.Random;

import org.springframework.stereotype.Component;

import form.project.work.domain.Question;
import form.project.work.domain.QuestionRepository;

@Component
public class QuestionService {

	
	private QuestionRepository questionRepository;

    public QuestionService(QuestionRepository questionRepository) {
        this.questionRepository = questionRepository;
    }

    public List<Question> getQuestion() {
        return (List<Question>) questionRepository.findAll();
    }
    
    public Question saveQuestion(Question question) {
    	question.setId(new Random().nextLong());
    	return questionRepository.save(question);
    }
}
