package com.ncs.iss.ezlegal.user.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.ncs.iss.ezlegal.user.model.Session;

@Repository
public interface SessionRepository extends JpaRepository<Session, Long> {
	
	@Query("From Session where SESSION_ID = :sessionId")
	Session getBySession(@Param("sessionId") String sessionId);
	
}
