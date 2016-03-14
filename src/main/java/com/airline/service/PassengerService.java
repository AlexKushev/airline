package com.airline.service;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import com.airline.models.Passenger;

/**
 * Session Bean implementation class PassengerService
 */
@Stateless
@LocalBean
public class PassengerService {

	@PersistenceContext(unitName = "airline")
	private EntityManager em;

	public PassengerService() {
	}

	public boolean addNewPassenger(Passenger passenger) {
		String passengerEmail = passenger.getEmail();
		boolean isOk = false;
		try {
			em.createNamedQuery("Passenger.findByEmail", Passenger.class)
							.setParameter("email", passengerEmail).getSingleResult();
		} catch (NoResultException ex){
			em.persist(passenger);
			isOk = true;
		}
		
		return isOk;
	}

	public List<Passenger> getAllPassenger() {

		TypedQuery<Passenger> pQuery = em.createNamedQuery("Passenger.getAll", Passenger.class);
		List<Passenger> pList = pQuery.getResultList();

		return pList;

	}

	public Passenger checkUserLoginInformation(String email, String password) {

		TypedQuery<Passenger> pQuery = em.createNamedQuery("Passenger.getByEmailAndPassword", Passenger.class);
		pQuery.setParameter("email", email);
		pQuery.setParameter("password", password);
		Passenger passenger;
		try {
			passenger = pQuery.getSingleResult();
		} catch (Exception e) {
			return null;
		}

		return passenger;
	}

}
