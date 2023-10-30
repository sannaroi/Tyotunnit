package com.example.Tyotunnit.domain;


import java.util.List;
import org.springframework.data.repository.CrudRepository;

public interface ProjectRepository extends CrudRepository<Project, Long> {
	
	List <Project> findByName(String name);

}