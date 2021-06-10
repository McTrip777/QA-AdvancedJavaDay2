package com.qa.java.animal.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.qa.java.animal.domain.Animal;
import com.qa.java.repo.AnimalRepo;

@Service
public class AnimalService {

	private AnimalRepo repo;
	
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
//		if(a != null) {
//			return a;			
//		}else {
//			return null;
//		}
	}
	
	//CREATE
	public Animal createAnimal(Animal a) {
		return this.repo.save(a);
	}
	
	//PUT
//	public Animal updateAnimal(Long id, Animal newAnimal) {
//		
//	}
	
	//PATCH
	
	//DELETE
	public boolean deleteAnimal(Long id) {
		this.repo.deleteById(id);
		return this.repo.existsById(id);
	}
	
	
}
