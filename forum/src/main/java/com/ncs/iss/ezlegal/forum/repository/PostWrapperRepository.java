package com.ncs.iss.ezlegal.forum.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.ncs.iss.ezlegal.forum.model.PostWrapper;

@Repository
public interface PostWrapperRepository extends JpaRepository<PostWrapper, Long> {
	
	@Query(value =    "SELECT "
					+ "P.ID AS [POST_ID],"
					+ "F.ID AS [FORUM_ID],"
					+ "F.TITLE AS [POST_SUBJECT],"
					+ "P.CONTENT AS [POST_CONTENT],"
					+ "P.CREATED_DATE AS [POST_CREATED_DATE],"
					+ "P.CREATED_BY AS [POST_CREATED_BY_ID],"
					+ "[POST_CREATED_BY_NAME] = (SELECT FIRST_NAME+' '+LAST_NAME FROM TB_USER WHERE ID = P.CREATED_BY),"
					+ "[POST_COUNT] = (SELECT COUNT(1) FROM TB_POST WHERE [CREATED_BY] = P.CREATED_BY),"
					+ "[POST_RATING] = (SELECT ISNULL(AVG(RATING),0) FROM TB_POST_RATING WHERE [POST_ID] = P.ID),"
					+ "[USER_RATING] = (SELECT ISNULL(AVG(RATING),0) FROM TB_USER_RATING WHERE [FOR_USER_ID] = P.CREATED_BY)"
					+ "FROM TB_FORUM F "
					+ "INNER JOIN TB_POST P ON F.ID = P.FORUM_ID "
					+ "WHERE P.ID = :postId", nativeQuery = true)
	PostWrapper getPostWrapperByPostId(@Param("postId") long postId);
	
	@Query(value =    "SELECT "
					+ "P.ID AS [POST_ID],"
					+ "F.ID AS [FORUM_ID],"
					+ "F.TITLE AS [POST_SUBJECT],"
					+ "P.CONTENT AS [POST_CONTENT],"
					+ "P.CREATED_DATE AS [POST_CREATED_DATE],"
					+ "P.CREATED_BY AS [POST_CREATED_BY_ID],"
					+ "[POST_CREATED_BY_NAME] = (SELECT FIRST_NAME+' '+LAST_NAME FROM TB_USER WHERE ID = P.CREATED_BY),"
					+ "[POST_COUNT] = (SELECT COUNT(1) FROM TB_POST WHERE [CREATED_BY] = P.CREATED_BY),"
					+ "[POST_RATING] = (SELECT ISNULL(AVG(RATING),0) FROM TB_POST_RATING WHERE [POST_ID] = P.ID),"
					+ "[USER_RATING] = (SELECT ISNULL(AVG(RATING),0) FROM TB_USER_RATING WHERE [FOR_USER_ID] = P.CREATED_BY)"
					+ "FROM TB_FORUM F "
					+ "INNER JOIN TB_POST P ON F.ID = P.FORUM_ID "
					+ "WHERE F.ID = :forumId", nativeQuery = true)
	List<PostWrapper> getPostWrapperByForumId(@Param("forumId") long forumId);
	
	@Query(value =    "SELECT "
					+ "P.ID AS [POST_ID],"
					+ "F.ID AS [FORUM_ID],"
					+ "F.TITLE AS [POST_SUBJECT],"
					+ "P.CONTENT AS [POST_CONTENT],"
					+ "P.CREATED_DATE AS [POST_CREATED_DATE],"
					+ "P.CREATED_BY AS [POST_CREATED_BY_ID],"
					+ "[POST_CREATED_BY_NAME] = (SELECT FIRST_NAME+' '+LAST_NAME FROM TB_USER WHERE ID = P.CREATED_BY),"
					+ "[POST_COUNT] = (SELECT COUNT(1) FROM TB_POST WHERE [CREATED_BY] = P.CREATED_BY),"
					+ "[POST_RATING] = (SELECT ISNULL(AVG(RATING),0) FROM TB_POST_RATING WHERE [POST_ID] = P.ID),"
					+ "[USER_RATING] = (SELECT ISNULL(AVG(RATING),0) FROM TB_USER_RATING WHERE [FOR_USER_ID] = P.CREATED_BY)"
					+ "FROM TB_FORUM F "
					+ "INNER JOIN TB_POST P ON F.ID = P.FORUM_ID "
					+ "WHERE F.ID = :forumId AND P.CONTENT LIKE %:searchTerm%", nativeQuery = true)
	List<PostWrapper> getPostWrapperByForumIdAndContent(@Param("forumId") long forumId, @Param("searchTerm") String searchTerm);
	
	@Query(value =    "SELECT "
					+ "P.ID AS [POST_ID],"
					+ "F.ID AS [FORUM_ID],"
					+ "F.TITLE AS [POST_SUBJECT],"
					+ "P.CONTENT AS [POST_CONTENT],"
					+ "P.CREATED_DATE AS [POST_CREATED_DATE],"
					+ "P.CREATED_BY AS [POST_CREATED_BY_ID],"
					+ "[POST_CREATED_BY_NAME] = (SELECT FIRST_NAME+' '+LAST_NAME FROM TB_USER WHERE ID = P.CREATED_BY),"
					+ "[POST_COUNT] = (SELECT COUNT(1) FROM TB_POST WHERE [CREATED_BY] = P.CREATED_BY),"
					+ "[POST_RATING] = (SELECT ISNULL(AVG(RATING),0) FROM TB_POST_RATING WHERE [POST_ID] = P.ID),"
					+ "[USER_RATING] = (SELECT ISNULL(AVG(RATING),0) FROM TB_USER_RATING WHERE [FOR_USER_ID] = P.CREATED_BY)"
					+ "FROM TB_FORUM F "
					+ "INNER JOIN TB_POST P ON F.ID = P.FORUM_ID "
					+ "ORDER BY F.ID,P.CREATED_DATE", nativeQuery = true)
	List<PostWrapper> getPostWrapperOrderByIdAsc();
	
}
