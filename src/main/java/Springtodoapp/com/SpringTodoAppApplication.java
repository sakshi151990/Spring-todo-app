package Springtodoapp.com;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;

import Springtodoapp.com.data.UserRepository;

@SpringBootApplication
@ComponentScan(basePackages = "Springtodoapp.com.data,Springtodoapp.com.config,Springtodoapp.com.model,Springtodoapp.com.web")
public class SpringTodoAppApplication extends SpringBootServletInitializer {

	@Autowired
	static UserRepository userrepo;

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(SpringTodoAppApplication.class);
	}

	public static void main(String[] args) {

		SpringApplication.run(SpringTodoAppApplication.class, args);
		System.out.println(userrepo);
	}
}
