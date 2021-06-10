package com.qa.java.animal.controller;

import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.qa.java.animal.domain.Animal;
import com.qa.java.animal.service.AnimalService;


@RestController
public class AnimalController {
	
	private AnimalService service;
	
	public AnimalController(AnimalService service) {
		this.service = service;
	}
	
	@GetMapping("/get/animals")
	public ResponseEntity<List<Animal>> getAllAnimals(){
		return new ResponseEntity<List<Animal>>( this.service.getAllAnimals(), HttpStatus.OK);
	}
	
	@GetMapping("/get/animal/{index}")
	public ResponseEntity<Animal> getAnimal(@PathVariable Long index){
		return new ResponseEntity<Animal>(this.service.getAnimal(index), HttpStatus.OK);
	}
	
	@PostMapping("/post/animal")
	public ResponseEntity<String> createAnimal(@RequestBody Animal a) {
		return new ResponseEntity<String>(this.service.createAnimal(a) + " was added successfully", HttpStatus.CREATED);
	}
	
//	@PutMapping("/put/animal/{index}")
//	public ResponseEntity<Animal> updateAnimal(@PathVariable Long index, @RequestBody Animal a){
//		return new ResponseEntity<Animal>(this.service.updateAnimal(index, a), HttpStatus.ACCEPTED);
//	}
//	
//	@PatchMapping("/patch/animal/{index}")
//	public ResponseEntity<Animal> changeAnimal(@PathVariable Long index, @PathParam("name") String name, @PathParam("age") int age, @PathParam("species") String species ){
//		return new ResponseEntity<Animal>(this.service.changeAnimal(index, name, age, species), HttpStatus.ACCEPTED);
//	}

	@DeleteMapping("/delete/animal/{index}")
	public ResponseEntity<Animal> deleteAnimal(@PathVariable Long index){
		return this.service.deleteAnimal(index) ? new ResponseEntity<>(HttpStatus.NO_CONTENT):new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
//	@DeleteMapping("/delete/animals")
//	public ResponseEntity<String> deleteAllAnimals(){
//		return new ResponseEntity<String>(this.service.deleteAllAnimals(), HttpStatus.NO_CONTENT);
//	}
	
}
