package form.project.work;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import form.project.work.domain.User;
import form.project.work.domain.UserRepository;
import net.minidev.json.JSONArray;
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
	public CommandLineRunner Results(QuestionRepository repository, UserRepository urepository, SurveyRepository srepository) {
		return (args) -> {
			
			User user1 = new User("user", "$2a$06$3jYRJrg0ghaaypjZ/.g4SethoeA51ph3UD4kZi9oPkeMTpjKU5uo6", "USER");
			User user2 = new User("admin", "$2a$10$0MMwY.IQqpsVc1jC8u7IJ.2rT8b0Cd3b3sfIBGV2zfgnPGtT4r0.C", "ADMIN");
			
			urepository.save(user1);
			urepository.save(user2);
			
			
			log.info("first questions");
			
			String[] choices1 = {"kyllä", "en tiedä", "ei"};
			String[] choices2 = {"Olen samaa mieltä", "En osaa sanoa", "Olen eri mieltä"};
			
			repository.save(new Question("Mitä kuuluu", "jotain", "text", choices1));
			repository.save(new Question("toinen ksymys", "sama", "checkbox", choices2));
			
			Survey survey1 = new Survey("kysely1");
			Survey survey2 = new Survey("kysely2");
			
			srepository.save(survey1);
			srepository.save(survey2);
			log.info("fetch all questions");
			for (Question question : repository.findAll()) {
				log.info(question.toString());
			}
		
			};
	}
}

	