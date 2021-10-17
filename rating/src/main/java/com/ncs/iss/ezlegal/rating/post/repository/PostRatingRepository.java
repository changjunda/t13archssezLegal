package com.ncs.iss.ezlegal.rating.post.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.ncs.iss.ezlegal.rating.post.model.PostRating;

@Repository
public interface PostRatingRepository extends JpaRepository<PostRating, Long> {
	
	@Query("From PostRating where POST_ID = :postId AND BY_USER_ID = :byUserId")
	PostRating getPostRatingByIdAndUser(@Param("postId") long postId, @Param("byUserId") long byUserId);
	
	@Query(value = "SELECT ISNULL(AVG(RATING),0.0) FROM TB_POST_RATING WHERE POST_ID = :postId", nativeQuery=true)
	public double getAveragePostRating(@Param("postId") int postId);
	
}
