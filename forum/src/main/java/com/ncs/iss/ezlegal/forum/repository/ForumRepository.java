package com.ncs.iss.ezlegal.forum.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.ncs.iss.ezlegal.forum.model.Forum;

@Repository
public interface ForumRepository extends JpaRepository<Forum, Long> {
	
	@Query("From Forum where ID = :forumId")
	Forum getForumByForumId(@Param("forumId") long forumId);
	
	@Query("From Forum")
	List<Forum> getAll();
	
	@Query("From Forum WHERE TITLE LIKE %:title%")
	List<Forum> getAllByTitle(@Param("title") String title);
	
}
