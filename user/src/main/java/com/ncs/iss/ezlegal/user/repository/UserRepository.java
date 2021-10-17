package com.ncs.iss.ezlegal.user.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.ncs.iss.ezlegal.user.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
	
	@Query("From User where ID = :userId")
	User getUserByUserId(@Param("userId") int userId);
	
	@Query("From User where SESSION_ID = :sessionId")
	User getUserBySession(@Param("sessionId") String sessionId);
	
	@Query("From User where EMAIL = :email")
	User getUserByEmail(@Param("email") String email);
	
	@Query("From User where ID = :userId AND SESSION_ID = :sessionId")
	User getUserByIdAndSession(@Param("userId") int userId, @Param("sessionId") String sessionId);
	
	@Query("From User where EMAIL = :email AND PASSWORD = :password")
	User getUserByEmailAndPassword(@Param("email") String email, @Param("password") String password);
}
