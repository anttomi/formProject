package form.project.work.web;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


import form.project.work.domain.Answer;
import form.project.work.domain.AnswerRepository;


@CrossOrigin
@RestController
public class AnswerController {
	
    	private static final Logger log = LoggerFactory.getLogger(AnswerController.class);
    
	@Autowired
	private AnswerRepository arepository;
	
	
	//Api get all the answers
	@GetMapping(value = "/answers")
	List<Answer> all() {
		return (List<Answer>) arepository.findAll();	
	}
	
	//Api, save answer with the question info
	@CrossOrigin(origins = "http://localhost:3000")
	@PostMapping("/answers")
	public Answer newAnswer(@RequestBody Answer newAnswer) {
	    	log.info("TESTI" + newAnswer.toString());
		return arepository.save(newAnswer);
	}
	
	//Api, return answer by its id
	@GetMapping(value = "/answer/{id}")
	Optional<Answer> single(@PathVariable("id") Long id) {
	    return arepository.findById(id);
	}
}