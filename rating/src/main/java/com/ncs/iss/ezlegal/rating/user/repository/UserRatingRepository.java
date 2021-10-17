package com.ncs.iss.ezlegal.rating.user.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.ncs.iss.ezlegal.rating.user.model.UserRating;

@Repository
public interface UserRatingRepository extends JpaRepository<UserRating, Long> {
	
	@Query("From UserRating where FOR_USER_ID = :forUserId AND BY_USER_ID = :byUserId")
	UserRating getUserRatingByUser(@Param("forUserId") int forUserId, @Param("byUserId") int byUserId);
	
	@Query(value = "SELECT ISNULL(AVG(RATING),0.0) FROM TB_USER_RATING WHERE FOR_USER_ID = :forUserId", nativeQuery=true)
	public double getAverageUserRating(@Param("forUserId") int forUserId);
	
}
