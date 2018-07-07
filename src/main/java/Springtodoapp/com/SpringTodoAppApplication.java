package Springtodoapp.com;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import Springtodoapp.com.data.UserRepository;

@SpringBootApplication
@ComponentScan(basePackages = "Springtodoapp.com.data,Springtodoapp.com.config,Springtodoapp.com.model,Springtodoapp.com.web")
public class SpringTodoAppApplication {

	@Autowired
	static UserRepository userrepo;

	public static void main(String[] args) {

		SpringApplication.run(SpringTodoAppApplication.class, args);
		System.out.println(userrepo);
	}
}
