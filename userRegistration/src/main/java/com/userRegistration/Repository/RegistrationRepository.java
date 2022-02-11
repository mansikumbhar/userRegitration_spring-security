package com.userRegistration.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.userRegistration.Entity.Registration;

@Repository
public interface RegistrationRepository extends JpaRepository<Registration, Long> {
	
	
}
