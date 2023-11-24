package com.openapi.oprnAPI.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.openapi.oprnAPI.model.Car;

public interface CarRepository extends JpaRepository<Car, Integer>{

}
