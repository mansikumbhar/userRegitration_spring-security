package com.userRegistration.Repository;

//import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.userRegistration.Entity.User;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {
	
	
	@Query("select u from User u where u.username = :username")
	public  User getUserByUsername(@Param("username") String username);

}
