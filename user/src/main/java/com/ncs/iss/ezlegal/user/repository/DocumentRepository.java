package com.ncs.iss.ezlegal.user.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.ncs.iss.ezlegal.user.model.Document;

@Repository
public interface DocumentRepository extends JpaRepository<Document, Long> {
	
	@Query("From Document where USER_ID = :userId")
	Document getDocumentByUserId(@Param("userId") int userId);
	
	@Query("From Document where ID = :Id")
	Document getDocumentById(@Param("Id") int Id);
}
