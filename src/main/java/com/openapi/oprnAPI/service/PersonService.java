package com.openapi.oprnAPI.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.openapi.oprnAPI.model.Car;
import com.openapi.oprnAPI.model.Person;
import com.openapi.oprnAPI.repository.CarRepository;
import com.openapi.oprnAPI.repository.PersonRepository;

@Service
public class PersonService {
	
	@Autowired
	private PersonRepository personRepository;
	
	@Autowired
	private CarRepository carRepository;

	public Person getPersonById(Integer id) {
		Optional<Person> person = personRepository.findById(id);
		if(person.isPresent()) {
			return person.get();
		}
		return null;
	}

	public List<Person> getAllPersons() {
		return personRepository.findAll();
	}

	public void add(Person person) {
		personRepository.save(person);
		
	}

	public Person updatePerson(Person person) {
		return personRepository.save(person);
	}

	public void addCar(Integer personId, Integer carId) throws Exception {
		Optional<Person> personOptional = personRepository.findById(personId);
		if(!personOptional.isPresent()) {
			throw new Exception("Person id is not valid.");
		}
		Optional<Car> carOptional = carRepository.findById(carId);
		
		if(!carOptional.isPresent()) {
			throw new Exception("Car id is not valid.");
		}
		
		Person person = personOptional.get();
		Car car = carOptional.get();
		
		car.setOwner(person);
		carRepository.save(car);
	}

}
