package com.uabd.edu.mx.seguridad;

import com.uabd.edu.mx.seguridad.repository.UserRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackageClasses = UserRepository.class)

public class SeguridadApplication {

    public static void main(String[] args) {
        SpringApplication.run(SeguridadApplication.class, args);
    }

}
