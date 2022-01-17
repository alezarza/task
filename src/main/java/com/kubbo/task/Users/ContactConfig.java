package com.kubbo.task.Users;



import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


@Configuration
public class ContactConfig {

    @Bean
    CommandLineRunner commandLineRunner(ContactRepository contactRepository){
        return args -> {
            Contact agustin = new Contact(
                   "Agustin",
                    "agustin@gmail.com",
                    "https//:Agustin_face.com",
                    689202123);

            Contact abelardo = new Contact(
                    "Abelardo",
                    "abelardo@gmail.com",
                    "https//:Abelardo_face.com",
                    684920438);

            Contact clara = new Contact(
                   "Clara",
                   "clara@gmail.com",
                    "https//:Clara_face.com",
                    654938024);

            List<Contact> listOfContacts = Arrays.asList(agustin, abelardo, clara);

            contactRepository.saveAll(listOfContacts);

        };


    }
}
