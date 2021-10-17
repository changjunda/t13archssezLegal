package com.ncs.iss.ezlegal.forum.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.ncs.iss.ezlegal.forum.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
	
	@Query("From User where ID = :userId")
	User getUserByUserId(@Param("userId") int userId);
	
	@Query("From User where SESSION_ID = :sessionId")
	User getUserBySession(@Param("sessionId") String sessionId);
	
}
