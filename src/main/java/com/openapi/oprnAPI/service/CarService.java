package com.openapi.oprnAPI.service;

import java.util.ArrayList;
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
			if(owner != null) {
				owner.setPersonCars(null);
				carData.setOwner(owner);
			}
			return carData;
		}
		return null;
	}

	public List<Car> getAllCars() {
		List<Car> listCar = carRepository.findAll();
		for(Car carData:listCar) {
			Person owner = carData.getOwner();
			if(owner != null) {
				owner.setPersonCars(null);
				carData.setOwner(owner);
			}
		}
		return listCar;
	}

	public void add(Car car) {
		carRepository.save(car);
	}

	public Car updateCar(Car car) {
		return carRepository.save(car);
	}

	public void loadPrivateCarBrand() {
		String carBrand[] = {"Maruti","Suzuki","Hyndui","Toyata"};
		String color[] = {"Green", "Blue", "Red","Yellow"};
		for(int i = 0; i<carBrand.length;i++) {
			Car car = new Car();
			car.setBrand(carBrand[i]);
			car.setColor(color[i]);
			carRepository.save(car);
		}
	}

	public List<Car> availableCars() {
		List<Car> listCar = carRepository.findAll();
		List<Car> availableCar = new ArrayList<>(listCar.size());
		for(Car car:listCar) {
			if(car.getOwner() == null) {
				availableCar.add(car);
			}
		}
		return availableCar;
	}

}
