package com.spring.allinone.travel.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.spring.allinone.travel.model.Travel;

@Repository
public interface TravelRepository extends CrudRepository<Travel, Long>{

}
