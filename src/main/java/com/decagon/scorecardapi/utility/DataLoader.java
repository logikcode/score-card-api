package com.decagon.scorecardapi.utility;

import com.decagon.scorecardapi.enums.Gender;
import com.decagon.scorecardapi.enums.Role;
import com.decagon.scorecardapi.model.SuperAdmin;
import com.decagon.scorecardapi.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.List;

@Configuration
@RequiredArgsConstructor
public class DataLoader {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    @Value("{SUPER_PASSWORD}")
    private String adminPassword;
    @Value("{SUPER_EMAIL}")
    private String adminEmail;

    @Bean
    public CommandLineRunner preloadAdmin() {
        if (userRepository.findAll().size() == 0) {
            return args -> {
                SuperAdmin user1 = new SuperAdmin("Chika", "Nwobi", Gender.MALE, adminEmail, Role.SUPER_ADMIN, passwordEncoder.encode(adminPassword));

                userRepository.save(user1);
            };
        }
        return null;
    }
}