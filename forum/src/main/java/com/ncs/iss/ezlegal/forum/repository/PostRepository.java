package com.ncs.iss.ezlegal.forum.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.ncs.iss.ezlegal.forum.model.Post;

@Repository
public interface PostRepository extends JpaRepository<Post, Long> {
	
	@Query("From Post where ID = :postId")
	Post getPostById(@Param("postId") long postId);
	
}
