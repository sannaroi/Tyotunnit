package com.example.Tyotunnit.domain;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface WorkerRepository  extends CrudRepository<Worker, Long>{
	
	List<Worker> findByLastname(String lastname);

} 

