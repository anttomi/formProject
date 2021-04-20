package form.project.work.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;


import form.project.work.domain.Question;
import form.project.work.domain.QuestionRepository;


@Controller
public class FormController {
	
	@Autowired
	private QuestionRepository qRepository;
	
	@RequestMapping(value="/login")
	public String login() {	
	    return "login";
	}
	
	@RequestMapping(value = "/questionlist", method = RequestMethod.GET)
	public String Questions(Model model) {
		model.addAttribute("questions", qRepository.findAll());
		return "questions";
	}
	
	@CrossOrigin(origins = "http://localhost:3000")
	@GetMapping(value = "/questions")
	public @ResponseBody List<Question> questionRest() {
	    return (List<Question>) qRepository.findAll();
	}
	
	@RequestMapping(value = "/add")
	public String addQuestion(Model model){
	 model.addAttribute("question", new Question());
	 return "addquestion";
	}
	
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String save(Question question){
	 qRepository.save(question);
	 return "redirect:questionlist";
	}
	
	

}
