package Springtodoapp;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import Springtodoapp.com.SpringTodoAppApplication;
import Springtodoapp.com.data.UserRepository;
import Springtodoapp.com.web.SignUpController;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = SpringTodoAppApplication.class)
public class UserSignUpTest {

	@Autowired
	private UserRepository userrepository;

	@Test
	public void signuptest() throws Exception {

		SignUpController controller = new SignUpController(userrepository);
		new MockMvcBuilders();
		MockMvc mockmvc = MockMvcBuilders.standaloneSetup(controller).build();
		mockmvc.perform(post("/signup").param("username", "Sakshi").param("email", "sakshi@xyz.com")
				.param("password", "password1").param("firstName", "Sakshi").param("lastName", "lastName"))
				.andExpect(view().name("error"));

	}

}
