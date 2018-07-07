package Springtodoapp.com.data;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import Springtodoapp.com.model.User;

@Repository
public interface UserRepository extends CrudRepository<User, String> {

	User findByUsername(String username);

	User findByEmail(String email);

}
