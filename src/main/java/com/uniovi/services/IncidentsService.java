package com.uniovi.services;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.uniovi.entitites.Incident;
import com.uniovi.entitites.IncidentStates;
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
	public Optional<Incident> getIncident(ObjectId id) {
		return incidentsRepository.findById(id);
	}

	public List<Incident> getIncidentsOfOperator(String email) {
		return incidentsRepository.findIncidentsOf(email);
	}

	public void deleteAll() {
		incidentsRepository.deleteAll();
	}

	/**
	 * This method changes the state of the incident defined by its id
	 *
	 * @param id
	 *            the id of the incident
	 * @param string
	 *            the new state
	 */
	public void changeIncidentState(ObjectId id, String stateIn) {
		Incident incident = incidentsRepository.findById(id.toString());
		if (incident != null) {
			try {
				IncidentStates state = IncidentStates.valueOf(stateIn);
				incident.setState(state);
				incidentsRepository.save(incident);
			} catch (Exception e) {
				return;
			}
		} else {
			return;
		}
	}

}
