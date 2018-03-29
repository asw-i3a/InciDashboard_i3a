package com.uniovi.services;

import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.uniovi.entitites.Incident;
import com.uniovi.repository.IncidentsRepository;

@Service
public class IncidentsService {

	@Autowired
	private IncidentsRepository incidentsRepository;

	public void addIncident(Incident incident) {
		incidentsRepository.save(incident);
	}

	public void deleteIncident(Incident inci) {
		incidentsRepository.delete(inci);
	}

	public List<Incident> getAllIncidents() {
		return incidentsRepository.findAll();
	}

	public Page<Incident> listAllIncidents(Pageable pageable){
		Page<Incident> incidents = new PageImpl<Incident>(new LinkedList<Incident>());
		incidents = this.incidentsRepository.findAll(pageable);
		return incidents;
	}
}
