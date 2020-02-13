package com.spring.allinone.travel.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.spring.allinone.travel.model.Travel;

@RepositoryRestResource(collectionResourceRel= "travel", path="travel")
public interface TravelRepositoryRestResource extends PagingAndSortingRepository<Travel, Long>{
	
	@Query("select t from Travel t where t.destination =:destination")
	List<Travel> findByDestination(@Param("destination") String destination);

}

//http://localhost:2020/travels