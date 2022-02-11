package com.userRegistration.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.userRegistration.Entity.Registration;
import com.userRegistration.Repository.RegistrationRepository;


@Service
public class RegistrationServiceImpl implements RegistrationService {

	@Autowired
	private RegistrationRepository registrationRepo;
	
	public void saveRegistration(Registration registration) {
		
			registrationRepo.save(registration);
	}

	@Override
	public List<Registration> getAllRegistrations() {
		List<Registration> registration = registrationRepo.findAll();
		return registration;
		
	}

	

	@Override
	public void deleteRegistartionByID(long emp_id) {
		registrationRepo.deleteById(emp_id);
		
	}
	
	

	@Override
	public Registration  findRegistrationById(long emp_id) {
		Optional<Registration> findData = registrationRepo.findById(emp_id);
		Registration registration = findData.get();
		return registration;
	}

}
