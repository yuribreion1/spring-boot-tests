package com.training.api.config;

import com.training.api.user.User;
import com.training.api.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.util.List;

@Configuration
@Profile("local")
public class LocalConfig {

    @Autowired
    UserRepository userRepository;

    @Bean
    public void startDb() {
        User user1 = new User(null, "Yuri", "yuri@mail.com", "123");
        User user2 = new User(null, "Anton", "anton@mail.com", "123");

        userRepository.saveAll(List.of(user1, user2));
    }
}
