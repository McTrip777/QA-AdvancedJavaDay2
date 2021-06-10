package com.qa.java.animal.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.qa.java.animal.domain.Bird;
import com.qa.java.animal.service.BirdService;

@RestController
public class BirdController {

	private BirdService service;
	
	public BirdController(BirdService service) {
		this.service = service;
	}
	
	@GetMapping("/get/birds")
	public ResponseEntity<List<Bird>> getAllBirds(){
		return new ResponseEntity<List<Bird>>( this.service.getAllBirds(), HttpStatus.OK);
	}
	
	@GetMapping("/get/bird/{index}")
	public ResponseEntity<Bird> getBird(@PathVariable Long index){
			return ResponseEntity.ok(this.service.getBird(index));
	}
	
	@PostMapping("/post/bird")
	public ResponseEntity<String> createBird(@RequestBody Bird a) {
		return new ResponseEntity<String>(this.service.createBird(a) + " was added successfully", HttpStatus.CREATED);
	}
	
	@PutMapping("/put/bird/{index}")
	public ResponseEntity<Bird> updateBird(@PathVariable Long index, @RequestBody Bird a){
		this.service.updateBird(index, a);
		return new ResponseEntity<Bird>(a, HttpStatus.ACCEPTED);
	}

	@DeleteMapping("/delete/bird/{index}")
	public ResponseEntity<Bird> deleteBird(@PathVariable Long index){
		return this.service.deleteBird(index) ? new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR) : new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
	
}
