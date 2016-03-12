package com.airline.utils;

import java.util.Date;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.airline.enums.Gender;
import com.airline.models.Passenger;
import com.airline.service.PassengerService;

@Stateless
public class DatabaseUtils {

	@PersistenceContext(unitName = "airline")
	private EntityManager em;

	@EJB
	private PassengerService ps;

	private static Passenger[] PASSENGERS = {
			new Passenger("Alex", "Kushev", new Date(), Gender.Male, "alex@abv.bg", "123"),
			new Passenger("Ivan", "Ivanov", new Date(), Gender.Male, "ivanov@abv.bg", "123") };

	public void addTestDataToDB() {
		deleteData();
		addTestPassengers();
	}

	private void deleteData() {
		em.createQuery("DELETE FROM Passenger").executeUpdate();
	}

	private void addTestPassengers() {
		for (Passenger p : PASSENGERS) {
			ps.addNewPassenger(p);
		}
	}

}
