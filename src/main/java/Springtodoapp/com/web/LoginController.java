package Springtodoapp.com.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import Springtodoapp.com.data.UserRepository;
import Springtodoapp.com.model.User;

@Controller
public class LoginController {

	public LoginController(UserRepository userrepository) {
		super();
		this.userrepository = userrepository;
	}

	@Autowired
	UserRepository userrepository;

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public ModelAndView login(@RequestParam("username") String username, @RequestParam("password") String password) {
		ModelAndView model = new ModelAndView();
		User userep = userrepository.findByUsername(username);

		if (userep != null) {
			if (userep.getPassword().equals(password)) {
				model.setViewName("welcome");
			} else {
				model.setViewName("error");
			}

		} else {
			model.setViewName("error");
		}

		return model;
	}

}
