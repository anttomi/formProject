package form.project.work.domain;

import org.springframework.data.repository.CrudRepository;

import form.project.work.domain.User;

public interface UserRepository extends CrudRepository<User, Long>{
	
	User findByUsername(String username);

}
