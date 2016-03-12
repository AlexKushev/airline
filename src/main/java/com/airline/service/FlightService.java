package com.airline.service;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import com.airline.models.Flight;

/**
 * Session Bean implementation class FlightService
 */
@Stateless
@LocalBean
public class FlightService {

	/**
	 * Default constructor.
	 */
	public FlightService() {
		// TODO Auto-generated constructor stub
	}

	@PersistenceContext(unitName = "airline")
	private EntityManager em;

	public void addNewFlight(Flight flight) {
		em.persist(flight);
	}

	public List<Flight> getAllFlights() {

		TypedQuery<Flight> fQuery = em.createNamedQuery("Flight.getAll", Flight.class);
		List<Flight> fList = (List<Flight>) fQuery.getResultList();

		return fList;

	}

}
