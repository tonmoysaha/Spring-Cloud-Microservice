package com.cloud.controller;

import java.util.Collections;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cloud.model.Person;
import com.cloud.repository.PersonRepository;



@RestController
@RequestMapping("/people")
public class PersonController {

    private final PersonRepository repository;
    private static final Logger LOGGER = LoggerFactory.getLogger(PersonController.class);

    @Autowired
    public PersonController(PersonRepository repository){
        super();
        this.repository = repository;
    }

    @GetMapping
    public Iterable<Person> getAll(@RequestParam(name = "email" , required = false) String email){
        LOGGER.info("Call hit");
        if (StringUtils.isNotEmpty(email)) {
			return Collections.singletonList(this.repository.findByEmailAddress(email));
		}
        return this.repository.findAll();
    }
    
}