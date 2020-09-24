package com.cloud.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.cloud.model.Person;

@Repository
public interface PersonRepository extends CrudRepository<Person, Long> {

	Person findByFirstName(String name);
}
