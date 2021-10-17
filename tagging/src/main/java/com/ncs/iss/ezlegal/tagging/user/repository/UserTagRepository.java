package com.ncs.iss.ezlegal.tagging.user.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.ncs.iss.ezlegal.tagging.user.model.UserTag;

@Repository
public interface UserTagRepository extends JpaRepository<UserTag, Long> {
	
	@Query("From UserTag where TAG_ID = :tagId AND USER_ID = :userId")
	UserTag getTagByTagIdAndTagName(@Param("tagId") long tagId, @Param("userId") int userId);
	
	@Query("From UserTag WHERE USER_ID = :userId")
	List<UserTag> getAllByUserId(@Param("userId") int userId);
	
}
