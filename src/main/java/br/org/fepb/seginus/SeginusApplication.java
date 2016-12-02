package br.org.fepb.seginus;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories("br.org.fepb.seginus.repository")
public class SeginusApplication {

	public static void main(String[] args) {
		SpringApplication.run(SeginusApplication.class, args);
	}
}
