package form.project.work.web;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class AnswerController {
	
	@RequestMapping(value = "/")
	public ResponseEntity<Answer> get() {

	}
	
	@RequestMapping(value = "/", method = RequestMethod.POST)
	public ResponseEntity<RequestWrapper> updateWithMultipleObjects(
	        @RequestBody RequestWrapper requestWrapper) {

	    return new ResponseEntity<RequestWrapper>(requestWrapper, HttpStatus.OK);
	}

}
