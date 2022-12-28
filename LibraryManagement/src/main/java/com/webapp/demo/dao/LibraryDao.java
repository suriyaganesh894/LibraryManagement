package com.webapp.demo.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.webapp.demo.library.Library;

import jakarta.transaction.Transactional;

public interface LibraryDao extends JpaRepository<Library, Integer> {
	
	@Query(value="select * from library where genre=?1",nativeQuery = true)
	List<Library> getByType(String type);
	
	@Modifying
	@Transactional
	@Query(value="delete from library where book_id=?1",nativeQuery = true)
	void delete(String id);
	
	@Modifying
	@Transactional
	@Query(value="update library set book_name=?2 where book_id=?1",nativeQuery = true)
	void update(String id,String name);
	 
	
}
