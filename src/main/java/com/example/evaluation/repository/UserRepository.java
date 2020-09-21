package com.example.evaluation.repository;

import org.springframework.data.repository.CrudRepository;

import com.example.evaluation.model.Person;

public interface UserRepository extends CrudRepository<Person, Integer> {

}
