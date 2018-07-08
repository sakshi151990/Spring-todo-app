package Springtodoapp;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import Springtodoapp.com.SpringTodoAppApplication;
import Springtodoapp.com.data.UserRepository;
import Springtodoapp.com.model.User;
import Springtodoapp.com.web.SignUpController;

@ActiveProfiles("test")
@RunWith(SpringRunner.class)
@SpringBootTest(classes = SpringTodoAppApplication.class)
public class UserSignUpTest {

	@Autowired
	private UserRepository userrepository;

	@Before
	public void createuser() {
		User user1 = new User("Sakshi", "password1", "sakshi@xyz.com", "Sakshi", "Agarwal");
		User user2 = new User("John", "password1", "john@xyz.com", "John", "Agarwal");

		userrepository.save(user1);
		userrepository.save(user2);

		userrepository.findAll().forEach(System.out::println);

	}

	@Test
	public void signuptest() throws Exception {

		SignUpController controller = new SignUpController(userrepository);
		new MockMvcBuilders();
		MockMvc mockmvc = MockMvcBuilders.standaloneSetup(controller).build();
		mockmvc.perform(post("/signup").param("username", "Sakshi").param("email", "sakshi@xyz.com")
				.param("password", "password1").param("firstName", "Sakshi").param("lastName", "lastName"))
				.andExpect(view().name("error"));

	}

	@After
	public void removeuser() {

		userrepository.deleteAll();

	}

}
