package form.project.work.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import form.project.work.domain.QuestionRepository;


@Controller
public class FormController {
	
	@Autowired
	private QuestionRepository repository;
	
	@RequestMapping(value = "/questions", method = RequestMethod.GET)
	public String Questions(Model model) {
		model.addAttribute("questions", repository.findAll());
		return "questions";
	}

}
