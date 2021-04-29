package form.project.work.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import form.project.work.domain.Answer;
import form.project.work.domain.AnswerRepository;

@CrossOrigin
@RestController
public class AnswerController {
	
	@Autowired
	private AnswerRepository arepository;
	
	@GetMapping(value = "/answers")
	List<Answer> all() {
		return (List<Answer>) arepository.findAll();	
	}

	@PostMapping("/answers")
	Answer newAnswer(@RequestBody Answer newAnswer) {
		return arepository.save(newAnswer);
	}
}