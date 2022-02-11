package com.userRegistration.service;

import java.util.List;


import com.userRegistration.Entity.Registration;

public interface RegistrationService {
	public void saveRegistration(Registration registration);
	
	public List<Registration> getAllRegistrations();
	
	public void deleteRegistartionByID(long emp_id);
	
	public Registration findRegistrationById(long id);

}
