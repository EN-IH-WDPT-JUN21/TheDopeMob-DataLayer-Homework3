package com.ironhack;

import com.ironhack.controller.LeadController;
//import com.ironhack.data.InputHandler;
import com.ironhack.dao.LeadContact;
import com.ironhack.data.InputHandler;
import com.ironhack.repository.LeadContactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.List;
import java.util.Optional;

@SpringBootApplication
public class CRMApplication implements CommandLineRunner {

    @Autowired
    LeadContactRepository leadContactRepository;

    @Autowired
    LeadController leadController;

    @Autowired
    InputHandler inputHandler;

    public static void main(String[] args) {
        SpringApplication.run(CRMApplication.class, args);}

        @Override
        public void run(String... args) {

            inputHandler.start();

    }

}
