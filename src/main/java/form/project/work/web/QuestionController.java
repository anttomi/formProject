package form.project.work.web;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import form.project.work.domain.Question;
import form.project.work.domain.QuestionRepository;
import form.project.work.domain.Survey;
import form.project.work.domain.SurveyRepository;

@CrossOrigin
@Controller
public class QuestionController {
	
	@Autowired
	private QuestionRepository qRepository;
	
	@Autowired
	private SurveyRepository sRepository;
	
	
	//direct to login page
	@RequestMapping(value="/login")
	public String login() {	
	    return "login";
	}
	
	//Show home page
	@RequestMapping(value = "/home", method = RequestMethod.GET)
	public String Questions(Model model) {
		model.addAttribute("questions", qRepository.findAll());
		return "home";
	}
	
	//Api, get all questions rest
	@GetMapping(value = "/questions")
	public @ResponseBody List<Question> questionRest() {
	    return (List<Question>) qRepository.findAll();
	}
	
	//Api, save a new question rest
	@CrossOrigin(origins = "http://localhost:3000")
	@PostMapping(value = "/questions")
	public Question newQuestion(@RequestBody Question newQuestion) {
	    return qRepository.save(newQuestion);
	}
	
//	@PutMapping(value = "/updatequestion")
//	Question newQuestion (@RequestBody Question newQuestion) {
//	    return qRepository.save(qRepository.findById(newQuestion.getId()));
//	}
	
	//Find a question by id rest
	@GetMapping("/question/{id}")
	public @ResponseBody Optional<Question> single(@PathVariable("id") Long id) {
	    return qRepository.findById(id);
	}
	
	//Get all surveys rest
	@GetMapping(value = "/surveylist")
	public @ResponseBody List<Survey> surveyRest() {
	    return (List<Survey>) sRepository.findAll();
	}
	
	//Add survey page backend
	@RequestMapping(value = "/addsurvey")
	public String addSurvey(Model model){
	 model.addAttribute("survey", new Survey());
	 return "addsurvey";
	}
	
	//surveys list template
	@RequestMapping(value = "/surveys", method = RequestMethod.GET)
	public String Surveys(Model model) {
		model.addAttribute("surveys", sRepository.findAll());
		return "surveys";
	}
	
	//request for adding a question back
	@RequestMapping(value = "/addquestion")
	public String addQuestion(Model model){
	 model.addAttribute("question", new Question());
	 return "addquestion";
	}
	
	//Save a question back
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String save(Question question){
	 qRepository.save(question);
	 return "redirect:home";
	}
	
	@RequestMapping(value = "/questionlist", method = RequestMethod.GET)
	public String Questionlist(Model model) {
		model.addAttribute("questions", qRepository.findAll());
		return "questionlist";
	}
	
	
	@RequestMapping(value="/delete/{id}", method = RequestMethod.GET)
    public String deleteQuestion(@PathVariable("id") Long questionId, Model model) {
    	qRepository.deleteById(questionId);
    	return "redirect:../home";
    }
	
	@RequestMapping(value="/edit/{id}", method = RequestMethod.GET)
    public String editQuestion(@PathVariable("id") Long questionId, Model model) {
    	model.addAttribute("question", qRepository.findById(questionId));
    	return "editquestion";
    }
	

}
