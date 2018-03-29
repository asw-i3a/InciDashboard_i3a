package com.uniovi.repository;

import org.bson.types.ObjectId;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.uniovi.entitites.Incident;

@Repository
public interface IncidentsRepository extends MongoRepository<Incident, ObjectId> {

	
	public Page<Incident> findAll(Pageable page);

}
