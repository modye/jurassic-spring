package bzh.jurassic.spring;

import bzh.jurassic.spring.application.DinosLister;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class JurassicApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(JurassicApplication.class, args);

		System.out.println("You should add a breakpoint on this line :)");

		DinosLister dinosLister = context.getBean(DinosLister.class);

		if(dinosLister != null) {
			System.out.println("That seems to be correctly initialized :)");
		}
	}

}
