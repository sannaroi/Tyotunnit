package com.example.Tyotunnit.web;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.Tyotunnit.domain.ProjectRepository;
import com.example.Tyotunnit.domain.Worker;
import com.example.Tyotunnit.domain.WorkerRepository;

@Controller
public class WorkerController {
	@Autowired
	private WorkerRepository repository;
	
	@Autowired
	private ProjectRepository crepository;
	
	  @RequestMapping(value="/login")
	    public String login() {	
	        return "login";
	    }

   @RequestMapping(value= {"/", "/workerlist"})
    public String workerList(Model model) {
	   model.addAttribute("workers", repository.findAll());
        return "workerlist";
    }
   
   @RequestMapping(value="/workers", method = RequestMethod.GET)
   public @ResponseBody List<Worker> workerListRest() {
	   return (List<Worker>) repository.findAll();
   }

   @RequestMapping(value="worker/{id}", method = RequestMethod.GET)
   public @ResponseBody Optional<Worker> findWorkerRest(@PathVariable("id") Long workerId) {
	   return repository.findById(workerId);
   }
   
   @RequestMapping(value= "/add")
   public String addWorker(Model model) {
	   model.addAttribute("worker", new Worker());
	   model.addAttribute("projects", crepository.findAll());
	   return "addworker";
   }
   
   @RequestMapping(value="/save", method = RequestMethod.POST)
   public String save(Worker worker) {
	   repository.save(worker);
       return "redirect:workerlist";
   }
   
   @PreAuthorize("hasAuthority('ADMIN')")
   @RequestMapping(value="/delete/{Id}", method = RequestMethod.GET)
   public String deleteWorker(@PathVariable("Id")Long workerId, Model model) {
	   repository.deleteById(workerId);
       return "redirect:../workerlist";
}
}
