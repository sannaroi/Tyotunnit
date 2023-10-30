package com.example.Tyotunnit.domain;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Worker {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String firstname;
	private String lastname;
	private LocalDate date;
	private String start;
	private String total_hours;

	@ManyToOne
	@JsonIgnore
	@JoinColumn(name = "projectId")
	private Project project;

	public Worker() {
	}

	
	public Worker(String firstname, String lastname, LocalDate date, String start, String total_hours,
			Project project) {
		super();
		this.firstname = firstname;
		this.lastname = lastname;
		this.date = date;
		this.start = start;
		this.total_hours = total_hours;
		this.project = project;
	}


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFirstname() {
		return firstname;
	}


	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}


	public String getLastname() {
		return lastname;
	}


	public void setLastname(String lastname) {
		this.lastname = lastname;
	}


	public LocalDate getDate() {
		return date;
	}


	public void setDate(LocalDate date) {
		this.date = date;
	}


	public String getStart() {
		return start;
	}


	public void setStart(String start) {
		this.start = start;
	}


	public String getTotal_hours() {
		return total_hours;
	}


	public void setTotal_hours(String total_hours) {
		this.total_hours = total_hours;
	}


	public Project getProject() {
		return project;
	}


	public void setProject(Project project) {
		this.project = project;
	}


	@Override
	public String toString() {
		if (this.project != null)
			return "Worker [id=" + id + ", firstname=" + firstname + ", lastname=" + lastname + ", date=" + date +" start=" + start
					+ ", total_hours=" + total_hours + " project =" + this.getProject() + "]";
		
		else 
			return "Worker [id=" + id + ", firstname=" + firstname + ", lastname=" + lastname + ",  date=" + date + ", start=" + start
			+  ", total_hours=" + total_hours + "]";
	}

}
