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
import form.project.work.domain.Survey;
<<<<<<< HEAD
=======
import form.project.work.domain.SurveyRepository;
>>>>>>> 9f839084cb0800ba975784742bb062ca1c5d4fef


@Controller
public class FormController {
	
	@Autowired
	private QuestionRepository qRepository;
	
	@Autowired
	private SurveyRepository sRepository;
	
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
	
<<<<<<< HEAD
	@RequestMapping(value = "/addsurvey")
	public String addQuestion(Model model){
	 model.addAttribute("survey", new Survey());
	 return "addsurvey";
	}
	
	/*@RequestMapping(value = "/addquestion")
=======
	@CrossOrigin(origins = "http://localhost:3000")
	@GetMapping(value = "/surveys")
	public @ResponseBody List<Survey> surveyRest() {
	    return (List<Survey>) sRepository.findAll();
	}
	
	@RequestMapping(value = "/add")
>>>>>>> 9f839084cb0800ba975784742bb062ca1c5d4fef
	public String addQuestion(Model model){
	 model.addAttribute("question", new Question());
	 return "addquestion";
	}*/
	
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String save(Question question){
	 qRepository.save(question);
	 return "redirect:questionlist";
	}
	
	

}
