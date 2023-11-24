package com.openapi.oprnAPI.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.openapi.oprnAPI.model.Car;
import com.openapi.oprnAPI.repository.CarRepository;

@Service
public class CarService {
	
	@Autowired
	private CarRepository carRepository;

	public Car getCarById(Integer id) {
		Optional<Car> car = carRepository.findById(id);
		if(car.isPresent()) {
			return car.get();
		}
		return null;
	}

	public List<Car> getAllCars() {
		return carRepository.findAll();
	}

	public void add(Car car) {
		carRepository.save(car);
		
	}

	public Car updateCar(Car car) {
		return carRepository.save(car);
	}

}
