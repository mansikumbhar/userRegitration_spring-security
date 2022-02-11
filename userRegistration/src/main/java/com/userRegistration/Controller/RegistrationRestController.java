package com.userRegistration.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.userRegistration.Entity.Registration;
import com.userRegistration.Repository.RegistrationRepository;


@RestController
@RequestMapping("/secure")
public class RegistrationRestController {
	
	@Autowired
	private RegistrationRepository registrationRepo;
	
	@GetMapping
	public List<Registration> getregistration(){
		List<Registration>registration=registrationRepo.findAll();
		return registration;
		
	}
	
	@PostMapping
	public void saveRegistration(@RequestBody Registration registration) {
		registrationRepo.save(registration);
	}
	
	@PutMapping
	public void updateRegistration(@RequestBody Registration registration) {
		registrationRepo.save(registration);
	}
	
	@DeleteMapping("delete/{emp_id}")
	public void deleteRegistration(@PathVariable long emp_id) {
		registrationRepo.deleteById(emp_id);
	}
}
