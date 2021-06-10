package com.qa.java.animal.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.qa.java.animal.domain.Animal;
import com.qa.java.repo.AnimalRepo;

@Service
public class AnimalService {

	public AnimalRepo repo;
	
	public AnimalService(AnimalRepo repo) {
		this.repo = repo;
	}
	
	// CRUD
	//READ ALL
	public List<Animal> getAllAnimals(){
		return this.repo.findAll();
	}
	
	//READ ONE
	public Animal getAnimal(Long id) {
		Optional<Animal> a = this.repo.findById(id);
		return a.get();
	}
	
	//CREATE
	public Animal createAnimal(Animal a) {
		return this.repo.save(a);
	}
	
	//Update
	public Animal updateAnimal(Long id, Animal newAnimal) {
		if(this.getAnimal(id) != null) {
			Animal temp = this.getAnimal(id);
			temp.setId(id);
			temp.setAge(newAnimal.getAge());
			temp.setName(newAnimal.getName());
			temp.setSpecies(newAnimal.getSpecies());
			Animal updated = this.repo.save(temp); // save it back to overwrite original
			return updated;
		}
		else return null;
	}
	
	//PATCH
	
	//DELETE
	public boolean deleteAnimal(Long id) {
		this.repo.deleteById(id);
		return this.repo.existsById(id);
	}
}
