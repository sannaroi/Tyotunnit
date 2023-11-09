package com.example.Tyotunnit;

import java.time.LocalDate;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.Tyotunnit.domain.AppUser;
import com.example.Tyotunnit.domain.AppUserRepository;
import com.example.Tyotunnit.domain.Project;
import com.example.Tyotunnit.domain.ProjectRepository;
import com.example.Tyotunnit.domain.Worker;
import com.example.Tyotunnit.domain.WorkerRepository;



@SpringBootApplication
public class TyotunnitApplication {
	private static final Logger log = LoggerFactory.getLogger(TyotunnitApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(TyotunnitApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner workerDemo(WorkerRepository repository, ProjectRepository crepository, AppUserRepository urepository) {
        return (args) -> {
        	log.info("save a couple of workers");
        	//crepository.save(new Project("Tuotekehitysprojekti"));
			//crepository.save(new Project("Tutkimusprojekti"));
			//crepository.save(new Project("Tietojärjestelmäprojekti"));
			//crepository.save(new Project("Investointiprojekti"));
			
			LocalDate date = LocalDate.of(2023, 10, 29);
        	
        	
        	//repository.save(new Worker("Matti", "Meikäläinen", date, "07:00", "8", crepository.findByName("Tuotekehitysprojekti").get(0)));
        	//repository.save(new Worker("Maija", "Mehiläinen", date, "07:00", "8", crepository.findByName("Investointiprojekti").get(0)));	
        	//tee uusi commit
        	
        	AppUser user1 = new AppUser("user", "$2a$06$3jYRJrg0ghaaypjZ/.g4SethoeA51ph3UD4kZi9oPkeMTpjKU5uo6", "USER");
			AppUser user2 = new AppUser("admin", "$2a$10$0MMwY.IQqpsVc1jC8u7IJ.2rT8b0Cd3b3sfIBGV2zfgnPGtT4r0.C", "ADMIN");
			//urepository.save(user1);
			//urepository.save(user2);
	
            log.info("fetch all workers");
			for (Worker worker : repository.findAll()) {
				log.info(worker.toString());
            }

		};
	}
}
