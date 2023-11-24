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

import com.openapi.oprnAPI.model.Person;
import com.openapi.oprnAPI.service.PersonService;

@RestController
@RequestMapping("/api/v1/person")
public class PersonController {

	@Autowired
	private PersonService personService;
	
	
	@GetMapping("/{id}")
	public Person getPersonById(@PathVariable Integer id) {
		return personService.getPersonById(id);
	}
	
	@GetMapping("/all")
	public List<Person> getAllPerson(){
		return personService.getAllPersons();
	} 
	
	@PostMapping("/add")
	@ResponseStatus(value = HttpStatus.ACCEPTED)
	public void addPerson(@RequestBody Person person) {
		personService.add(person);
	}
	
	@PutMapping("/update")
	public Person updatePerson(@RequestBody Person person) {
		person = personService.updatePerson(person);
		return person;
	}  
	
	@GetMapping("/addcar/{personId}/{carId}")
	@ResponseStatus(code = HttpStatus.ACCEPTED)
	public void purchaseCar(@PathVariable("personId") Integer personId,@PathVariable("carId") Integer carId) throws Exception {
		personService.addCar(personId, carId);
	}
}
