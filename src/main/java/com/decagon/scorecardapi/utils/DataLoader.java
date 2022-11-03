package com.decagon.scorecardapi.utils;

import com.decagon.scorecardapi.domain.entities.SuperAdmin;
import com.decagon.scorecardapi.domain.entities.User;
import com.decagon.scorecardapi.domain.entities.enums.Gender;
import com.decagon.scorecardapi.domain.entities.enums.Role;
import com.decagon.scorecardapi.infrastructure.persistence.repository.UsersRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.github.javafaker.Faker;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.IntStream;


@Component
public class DataLoader implements CommandLineRunner {


    private Logger logger = LoggerFactory.getLogger(DataLoader.class);
    private final UsersRepository usersRepository;

    private final Faker faker;
    public DataLoader(UsersRepository usersRepository){
    this.usersRepository = usersRepository;
//    this.faker = faker;
        this.faker = new Faker();
    };
   // @Bean
//    public PasswordEncoder passwordEncoder() {
//        return new  BCryptPasswordEncoder();
//    }
//    Faker faker = Faker.getInstance();
    @Override
    public void run(String... args) throws Exception {
        logger.info("Loading Sample Data");
        // create 10 SuperAdmins users
        AtomicInteger gen = new AtomicInteger(1);
       List<SuperAdmin> superAdmins = IntStream.rangeClosed(1, 5)
                        .mapToObj(i -> {

                            String firstName = faker.name().firstName();
                            String lastName = faker.name().lastName();
                            String email = faker.internet().emailAddress();
                            Gender gender = gen.getAndIncrement() % 2 == 0 ? Gender.FEMALE : Gender.MALE;
                            Role role = Role.SUPERADMIN;
                            String password = "12345678";
                            LocalDateTime createdAt = LocalDateTime.now();
                            LocalDateTime updatedAt = LocalDateTime.now();
                            SuperAdmin superAmin = new SuperAdmin();
                            superAmin.setFirstName(firstName);
                            superAmin.setLastName(lastName);
                            superAmin.setEmail(email);
                            superAmin.setGender(gender);
                            superAmin.setRole(role);
                            superAmin.setPassword(password);
                            superAmin.setCreateDate(createdAt);
                            superAmin.setUpdateDate(updatedAt);
                            return superAmin;
                        }).toList();
               usersRepository.saveAll(superAdmins);
    }
}
