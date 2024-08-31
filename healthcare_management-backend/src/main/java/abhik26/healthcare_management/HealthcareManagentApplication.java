package abhik26.healthcare_management;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication
public class HealthcareManagentApplication {

	public static void main(String[] args) {
		SpringApplication.run(HealthcareManagentApplication.class, args);
	}

    @Bean
    PasswordEncoder passwordEncoder() {
		PasswordEncoder passwordEncoder =
    		PasswordEncoderFactories.createDelegatingPasswordEncoder();
		return passwordEncoder;
	}
}
