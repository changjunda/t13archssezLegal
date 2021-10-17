package com.ncs.iss.ezlegal.forum.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.ncs.iss.ezlegal.forum.model.ForumTagWrapper;

@Repository
public interface ForumTagWrapperRepository extends JpaRepository<ForumTagWrapper, Long> {
	
	@Query(value =    "SELECT "
					+ "FT.ID AS [ID],"
					+ "FT.FORUM_ID AS [FORUM_ID],"
					+ "FT.TAG_ID AS [TAG_ID],"
					+ "MT.TAG_NAME AS [TAG_NAME],"
					+ "MT.TAG_DESCRIPTION AS [TAG_DESCRIPTION]"
					+ "FROM TB_FORUM_TAG FT "
					+ "INNER JOIN TB_MASTER_TAG MT ON FT.TAG_ID = MT.ID "
					+ "WHERE FT.FORUM_ID = :forumId", nativeQuery = true)
	List<ForumTagWrapper> getForumTagWrapperByForumId(@Param("forumId") long forumId);
	
}
