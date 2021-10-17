package com.ncs.iss.ezlegal.tagging.forum.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.ncs.iss.ezlegal.tagging.forum.model.ForumTag;

@Repository
public interface ForumTagRepository extends JpaRepository<ForumTag, Long> {
	
	@Query("From ForumTag where FORUM_ID = :forumId AND TAG_ID = :tagId AND USER_ID = :userId")
	ForumTag getTagByForumIdAndTagIdAndTagName(@Param("forumId") long forumId, @Param("tagId") long tagId, @Param("userId") int userId);
	
	@Query("From ForumTag WHERE FORUM_ID = :forumId")
	List<ForumTag> getAllByForumId(@Param("forumId") long forumId);
	
}
