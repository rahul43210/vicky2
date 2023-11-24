package com.openapi.oprnAPI.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.openapi.oprnAPI.model.Car;
import com.openapi.oprnAPI.model.Person;
import com.openapi.oprnAPI.repository.CarRepository;

@Service
public class CarService {
	
	@Autowired
	private CarRepository carRepository;

	public Car getCarById(Integer id) {
		Optional<Car> car = carRepository.findById(id);
		if(car.isPresent()) {
			Car carData = car.get();
			Person owner = carData.getOwner();
			owner.setPersonCars(null);
			carData.setOwner(owner);
			return carData;
		}
		return null;
	}

	public List<Car> getAllCars() {
		List<Car> listCar = carRepository.findAll();
		for(Car carData:listCar) {
			Person owner = carData.getOwner();
			owner.setPersonCars(null);
			carData.setOwner(owner);
		}
		return listCar;
	}

	public void add(Car car) {
		carRepository.save(car);
	}

	public Car updateCar(Car car) {
		return carRepository.save(car);
	}

}
