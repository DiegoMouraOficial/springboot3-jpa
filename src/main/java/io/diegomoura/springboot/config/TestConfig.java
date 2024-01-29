package io.diegomoura.springboot.config;

import io.diegomoura.springboot.entities.User;
import io.diegomoura.springboot.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.util.Arrays;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {
    @Autowired
    private UserRepository userRepository;

    @Override
    public void run(String... args) throws Exception {

        User user1 = new User(null, "Lupi", "lupi@bol.com.br", "11945875287", "xxx");
        User user2 = new User(null, "Rebeca", "rebeca@outlook.com", "11978562541", "xxx");
        User user3 = new User(null, "Meg", "meg@gmail.com", "11987562341", "xxx");

        userRepository.saveAll(Arrays.asList(user1, user2, user3));
    }
}
