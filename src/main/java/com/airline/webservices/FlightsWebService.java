package com.airline.webservices;

import java.util.List;

import javax.ejb.EJB;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.airline.models.Flight;
import com.airline.service.FlightService;

@Path("/flights")
public class FlightsWebService {

	private static final Response RESPONSE_OK = Response.ok().build();

	@PersistenceContext(unitName = "airline")
	private EntityManager em;

	@EJB
	private FlightService fs;

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Flight> getFlights() {

		List<Flight> fList = fs.getAllFlights();
		return fList;

	}

}
