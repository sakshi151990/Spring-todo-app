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
import Springtodoapp.com.web.HomeController;
import Springtodoapp.com.web.LoginController;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = SpringTodoAppApplication.class)
public class UserLoginTest {

	@Autowired
	private UserRepository userRepository;

	@Test
	public void Indexpage() throws Exception {

		HomeController controller = new HomeController();
		new MockMvcBuilders();
		MockMvc mockmvc = MockMvcBuilders.standaloneSetup(controller).build();
		mockmvc.perform(post("/")).andExpect(view().name("Index"));

	}

	@Test
	public void LoginRightpassUser() throws Exception {

		LoginController controller = new LoginController(userRepository);
		new MockMvcBuilders();
		MockMvc mockmvc = MockMvcBuilders.standaloneSetup(controller).build();
		mockmvc.perform(post("/login").param("username", "Sakshi").param("password", "password1"))
				.andExpect(view().name("welcome"));

	}

	@Test
	public void LoginWrongpassUser() throws Exception {
		LoginController controller = new LoginController(userRepository);
		new MockMvcBuilders();
		MockMvc mockmvc = MockMvcBuilders.standaloneSetup(controller).build();
		mockmvc.perform(post("/login").param("username", "Sakshi").param("password", "abc123"))
				.andExpect(view().name("error"));
	}

}
