package com.qa.java.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.qa.java.animal.domain.Bird;

@Repository
public interface BirdRepo extends JpaRepository<Bird, Long>{

}
