package com.qa.java.animal.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.qa.java.animal.domain.Bird;
import com.qa.java.repo.BirdRepo;

@Service
public class BirdService {

	public BirdRepo repo;
	
	public BirdService(BirdRepo repo) {
		this.repo = repo;
	}
	
	// CRUD
	//READ ALL
	public List<Bird> getAllBirds(){
		return this.repo.findAll();
	}
	
	//READ ONE
	public Bird getBird(Long id) {
		Optional<Bird> a = this.repo.findById(id);
		return a.orElseThrow();
	}
	
	//CREATE
	public Bird createBird(Bird b) {
		return this.repo.save(b);
	}
	
	//Update
	public Bird updateBird(Long id, Bird newBird) {
		if(this.getBird(id) != null) {
			Bird temp = this.getBird(id);
			temp.setId(id);
			temp.setAge(newBird.getAge());
			temp.setName(newBird.getName());
			temp.setSpecies(newBird.getSpecies());
			temp.setWings(newBird.getWings());
			temp.setType(newBird.getType());
			temp.setCanFly(newBird.isCanFly());
			Bird updated = this.repo.save(temp); // save it back to overwrite original
			return updated;
		}
		else return null;
	}
	
	//PATCH
	
	//DELETE
	public boolean deleteBird(Long id) {
		this.repo.deleteById(id);
		return this.repo.existsById(id);
	}

}
