package com.example.Tyotunnit.domain;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Project {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long projectId;
	private String name;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "project")
	private List<Worker> workers;
	
	public Project() {}

	public Project(String name) {
		super();
		this.name = name;
		
	}
	
	public Long getProjectId() {
		return projectId;
	}

	public void setProjectId(Long projectId) {
		this.projectId = projectId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Worker> getWorkers() {
		return workers;
	}

	public void setWorkers(List<Worker> workers) {
		this.workers = workers;
	}

	@Override
	public String toString() {
		return "Project [projectId=" + projectId + ", name=" + name +  "]";
	}
	
	

}
