package com.openapi.oprnAPI.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.openapi.oprnAPI.model.Person;

public interface PersonRepository extends JpaRepository<Person, Integer>{

}
