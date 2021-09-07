package com.ironhack.controller;

import com.ironhack.repository.SalesRepRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class SalesRepController {

    @Autowired
    SalesRepRepository salesRepRepository;
}
