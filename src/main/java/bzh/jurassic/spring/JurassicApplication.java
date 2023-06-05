package bzh.jurassic.spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class JurassicApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(JurassicApplication.class, args);

		System.out.println("You should add a breakpoint on this line :)");
	}

}
