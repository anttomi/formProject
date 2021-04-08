package form.project.work;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import form.project.work.domain.Question;
import form.project.work.domain.QuestionRepository;


@SpringBootApplication
public class WorkApplication {
	private static final Logger log = LoggerFactory.getLogger(WorkApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(WorkApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner Results(QuestionRepository repository) {
		return (args) -> {
			
			log.info("first questions");
			
			repository.save(new Question("Mitä kuuluu", "jotain", "checkbox"));
			repository.save(new Question("toinen ksymys", "sama", "checkbox"));	
			
			log.info("fetch all books");
			for (Question question : repository.findAll()) {
				log.info(question.toString());
			}

		

			};
	}
}

	