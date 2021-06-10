package com.qa.java.animal.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.qa.java.animal.domain.Animal;

@Service 
public class AnimalServiceList {

	private List<Animal> animalList;
	
	public AnimalServiceList(List<Animal> animalList) {
	this.animalList = animalList;
}

	public List<Animal> getAllAnimals(){
		return this.animalList;
	}
	
	public Animal getAnimal(int index){
		return this.animalList.get(index);
	}
	
	public String createAnimal(Animal a) {
		this.animalList.add(a);
		return "CREATED";
	}
	
	public Animal updateAnimal(int index, Animal a){
			this.animalList.set(index, a);
		return a;
	}

	public Animal changeAnimal(int index,String name,int age, String species){
			Animal a = this.animalList.get(index);
			if(name != null) {a.setName(name);}
			if(age != 0) {a.setAge(age);}
			if(species != null) {a.setSpecies(species);}
		return a;
	}

	public Animal deleteAnimal(int index){
		return this.animalList.remove(index);
	}
	
	public String deleteAllAnimals(){
		this.animalList.clear();
		return "All animals removed";
	}
	

}
