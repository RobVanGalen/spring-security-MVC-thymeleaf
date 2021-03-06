package com.demente.ideas.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
@EnableJpaAuditing
public class SpringSecurityApplication implements CommandLineRunner {

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    public static void main(String[] args) {
        SpringApplication.run(SpringSecurityApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

        // Solamente a modo de ejemplo, se encriptan dos password que seran posteriormente utilizadas
        // en el import.sql
        String password_admin = "admin";
        String password_num = "123456";

        String bCryptPassword = passwordEncoder.encode(password_admin);
        System.out.println("BCryptPasswordEncoder - Clave encriptada para admin: " + bCryptPassword);

        bCryptPassword = passwordEncoder.encode(password_num);
        System.out.println("BCryptPasswordEncoder - Clave encriptada para otros usuarios: :" + bCryptPassword);
    }
}
