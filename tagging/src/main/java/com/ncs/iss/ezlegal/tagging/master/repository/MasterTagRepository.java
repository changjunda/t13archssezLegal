package com.ncs.iss.ezlegal.tagging.master.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.ncs.iss.ezlegal.tagging.master.model.MasterTag;

@Repository
public interface MasterTagRepository extends JpaRepository<MasterTag, Long> {
	
	@Query("From MasterTag where TAG_NAME = :tagName")
	MasterTag getTagByTagName(@Param("tagName") String tagName);
	
	@Query("From MasterTag")
	List<MasterTag> getTag();
	
}
