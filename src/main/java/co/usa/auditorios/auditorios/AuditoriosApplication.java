package co.usa.auditorios.auditorios;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@EntityScan(basePackages = {"co.usa.auditorios.auditorios.model"})
@SpringBootApplication
public class AuditoriosApplication {

	public static void main(String[] args) {
		SpringApplication.run(AuditoriosApplication.class, args);
	}

}
