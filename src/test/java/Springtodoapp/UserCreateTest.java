package Springtodoapp;

import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import Springtodoapp.com.SpringTodoAppApplication;
import Springtodoapp.com.data.UserRepository;
import Springtodoapp.com.model.User;

@ActiveProfiles("test")
@RunWith(SpringRunner.class)
@SpringBootTest(classes = SpringTodoAppApplication.class)
public class UserCreateTest {

	@Autowired
	private UserRepository userrepository;

	@Test
	public void Saverepotest() throws Exception {

		User user1 = new User("Sakshi", "password1", "sakshi@xyz.com", "Sakshi", "Agarwal");
		User user2 = new User("John", "password1", "john@xyz.com", "John", "Agarwal");

		userrepository.save(user1);
		userrepository.save(user2);

		userrepository.findAll().forEach(System.out::println);

	}

	@After
	public void removeuser() {

		userrepository.deleteAll();

	}
}
