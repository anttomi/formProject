package form.project.work;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import form.project.work.domain.User;
import form.project.work.domain.UserRepository;
import form.project.work.domain.Answer;
import form.project.work.domain.AnswerRepository;
import form.project.work.domain.Question;
import form.project.work.domain.QuestionRepository;
import form.project.work.domain.Survey;
import form.project.work.domain.SurveyRepository;


@SpringBootApplication
public class WorkApplication {
	private static final Logger log = LoggerFactory.getLogger(WorkApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(WorkApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner Results(QuestionRepository repository, UserRepository urepository, SurveyRepository srepository, AnswerRepository arepository ) {
		return (args) -> {
			
			User user1 = new User("user", "$2a$06$3jYRJrg0ghaaypjZ/.g4SethoeA51ph3UD4kZi9oPkeMTpjKU5uo6", "USER");
			User user2 = new User("admin", "$2a$10$0MMwY.IQqpsVc1jC8u7IJ.2rT8b0Cd3b3sfIBGV2zfgnPGtT4r0.C", "ADMIN");
			
			urepository.deleteAll();
			urepository.save(user1);
			urepository.save(user2);
			
			
			log.info("first questions");
			
			String[] choices1 = {"kyllä", "en tiedä", "ei"};
			String[] choices2 = {"Olen samaa mieltä", "En osaa sanoa", "Olen eri mieltä"};
			
			Answer answer1 = new Answer("vastaus");
			Answer answer2 = new Answer("vastaus2");
			
			List<Answer> answers = new ArrayList<>();
			
			
			answers.add(answer1);
			answers.add(answer2);
			
			arepository.deleteAll();
			arepository.save(answer1);
			arepository.save(answer2);
			
			Question q1 = new Question("Mitä kuuluu","text");
			Question q2 = new Question("toinen ksymys", "checkbox", choices1);
			
			repository.deleteAll();
			repository.save(q1);
			repository.save(q2);
			
			
			List<Question> qt = new ArrayList<>();
			
			qt.add(q1);
			qt.add(q2);
			
			Survey survey1 = new Survey("kysely1");
			Survey survey2 = new Survey("kysely2");
			
			srepository.deleteAll();
			srepository.save(survey1);
			srepository.save(survey2);
			log.info("fetch all questions");
		
			};
	}
}

	