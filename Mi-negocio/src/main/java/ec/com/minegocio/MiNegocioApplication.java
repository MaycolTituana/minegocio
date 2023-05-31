package ec.com.minegocio;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MiNegocioApplication {

	public static void main(String[] args) {
                System.setProperty("server.port", "8080");
		SpringApplication.run(MiNegocioApplication.class, args);
	}

}
