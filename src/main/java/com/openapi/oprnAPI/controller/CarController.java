package com.openapi.oprnAPI.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.openapi.oprnAPI.model.Car;
import com.openapi.oprnAPI.service.CarService;

@RestController
@RequestMapping("/api/v1/car")
public class CarController {

	@Autowired
	private CarService carService;
	

	@GetMapping("/{id}")
	public Car getCarById(@PathVariable Integer id) {
		return carService.getCarById(id);
	}
	
	@GetMapping("/all")
	public List<Car> getAllCar(){
		return carService.getAllCars();
	} 
	
	@PostMapping("/add")
	@ResponseStatus(value = HttpStatus.ACCEPTED)
	public void addCar(@RequestBody Car Car) {
		carService.add(Car);
	}
	
	@PutMapping("/update")
	public Car updateCar(@RequestBody Car Car) {
		Car = carService.updateCar(Car);
		return Car;
	}
	
	@GetMapping("/availablecar")
	public List<Car> availableCar(){
		return carService.availableCars();
	}
}