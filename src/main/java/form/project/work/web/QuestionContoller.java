package form.project.work.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

import form.project.work.domain.Question;
import form.project.work.domain.QuestionLinks;

import lombok.extern.slf4j.Slf4j;

@Slf4j

@RestController
@RequestMapping("/api/")
public class QuestionContoller {
	

	@Autowired
	QuestionService questionService;
	
	
	@GetMapping(path = QuestionLinks.LIST_QUESTIONS)
    public ResponseEntity<?> listQuestions() {
        List<Question> resource = questionService.getQuestion();
        return ResponseEntity.ok(resource);
	}
	
	@PostMapping(path = QuestionLinks.ADD_QUESTION)
	public ResponseEntity<?> saveUser(@RequestBody Question question) {
        Question resource = questionService.saveQuestion(question);
        return ResponseEntity.ok(resource);
    }

}
