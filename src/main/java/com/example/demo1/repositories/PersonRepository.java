package com.example.demo1.repositories;

import com.example.demo1.models.Person;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface PersonRepository extends CrudRepository<Person, Long> {
    List<Person> findByName(String name);
    Person findById(long id);
}
