package bzh.jurassic.spring;

import bzh.jurassic.spring.interfaces.DinosFeederService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class JurassicApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(JurassicApplication.class, args);

		final DinosFeederService service = context.getBean(DinosFeederService.class);

		System.out.println(service);
	}

}
