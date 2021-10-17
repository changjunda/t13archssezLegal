package com.ncs.iss.ezlegal.user.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.ncs.iss.ezlegal.user.model.UserTagWrapper;

@Repository
public interface UserTagWrapperRepository extends JpaRepository<UserTagWrapper, Long> {
	
	@Query(value =    "SELECT "
					+ "UT.ID AS [ID],"
					+ "UT.USER_ID AS [USER_ID],"
					+ "UT.TAG_ID AS [TAG_ID],"
					+ "MT.TAG_NAME AS [TAG_NAME],"
					+ "MT.TAG_DESCRIPTION AS [TAG_DESCRIPTION]"
					+ "FROM TB_USER_TAG UT "
					+ "INNER JOIN TB_MASTER_TAG MT ON UT.TAG_ID = MT.ID "
					+ "WHERE UT.USER_ID = :userId", nativeQuery = true)
	List<UserTagWrapper> getUserTagWrapperByUserId(@Param("userId") int userId);
	
	@Query(value = "SELECT ISNULL(AVG(RATING),0) FROM TB_USER_RATING WHERE FOR_USER_ID = :userId", nativeQuery = true)
	int getUserRating(@Param("userId") int userId);

}
