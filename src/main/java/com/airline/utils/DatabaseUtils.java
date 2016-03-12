package com.airline.utils;

import java.util.Date;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.airline.enums.FlightDestination;
import com.airline.enums.Gender;
import com.airline.models.Flight;
import com.airline.models.Passenger;
import com.airline.service.FlightService;
import com.airline.service.PassengerService;

@Stateless
public class DatabaseUtils {

	@PersistenceContext(unitName = "airline")
	private EntityManager em;

	@EJB
	private PassengerService ps;
	
	@EJB
	private FlightService fs;

	private static Passenger[] PASSENGERS = {
			new Passenger("Alex", "Kushev", new Date(), Gender.Male, "alex@abv.bg", "123"),
			new Passenger("Ivan", "Ivanov", new Date(), Gender.Male, "ivanov@abv.bg", "123") };

	private static Flight[] FLIGHTS = {
			new Flight(FlightDestination.BARCELONA, FlightDestination.SOFIA, 300, new Date()),
			new Flight(FlightDestination.BERLIN, FlightDestination.ROME, 235, new Date()) };

	public void addTestDataToDB() {
		deleteData();
		addTestPassengers();
		addTestFlights();
	}

	private void deleteData() {
		em.createQuery("DELETE FROM Passenger").executeUpdate();
		em.createQuery("DELETE FROM Flight").executeUpdate();
	}

	private void addTestPassengers() {
		for (Passenger p : PASSENGERS) {
			ps.addNewPassenger(p);
		}
	}

	private void addTestFlights() {
		for (Flight f : FLIGHTS) {
			fs.addNewFlight(f);
		}
	}

}
