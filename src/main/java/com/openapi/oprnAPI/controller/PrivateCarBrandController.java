package com.openapi.oprnAPI.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.openapi.oprnAPI.service.CarService;

@RestController
@RequestMapping("/api/v1/privatecar")
public class PrivateCarBrandController extends CarController{

	@Autowired
	private CarService carService;
	
	@GetMapping("loadPrivateCars")
	@ResponseStatus(code = HttpStatus.OK)
	private void loadPrivateCar() {
		carService.loadPrivateCarBrand();
	}
}
