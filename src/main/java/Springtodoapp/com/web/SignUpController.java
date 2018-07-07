package Springtodoapp.com.web;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import Springtodoapp.com.data.UserRepository;
import Springtodoapp.com.model.User;

@Controller
public class SignUpController {

	public static final String DUPLICATED_USERNAME_KEY = "duplicatedUsername";

	public static final String DUPLICATED_EMAIL_KEY = "duplicatedEmail";

	public static final String SIGNED_UP_MESSAGE_KEY = "signedUp";
	public static final String ERROR_MESSAGE_KEY = "message";
	@Autowired
	UserRepository userrepository;

	@RequestMapping(value = "/signup", method = RequestMethod.POST)
	public String signUpPost(ModelMap model, @ModelAttribute("user") User user) throws IOException {

		this.checkForDuplicates(user, model);
		System.out.println(DUPLICATED_USERNAME_KEY + "and" + DUPLICATED_EMAIL_KEY);

		if (model.containsKey(DUPLICATED_USERNAME_KEY) || model.containsKey(DUPLICATED_EMAIL_KEY)) {

			return "error";
		} else {
			userrepository.save(user);
			return "welcome";
		}

	}

	public SignUpController(UserRepository userrepository) {
		super();
		this.userrepository = userrepository;
	}

	private void checkForDuplicates(User user, ModelMap model) {
		// TODO Auto-generated method stub
		if (userrepository.findByUsername(user.getUsername()) != null) {
			model.addAttribute(DUPLICATED_USERNAME_KEY, true);
		}
		if (userrepository.findByEmail(user.getEmail()) != null) {
			model.addAttribute(DUPLICATED_EMAIL_KEY, true);
		}

	}
}
