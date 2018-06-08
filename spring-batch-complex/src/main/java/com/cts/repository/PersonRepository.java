package com.cts.repository;

import org.springframework.data.repository.CrudRepository;

import com.cts.model.Person;

public interface PersonRepository extends CrudRepository<Person, Long> {

}
