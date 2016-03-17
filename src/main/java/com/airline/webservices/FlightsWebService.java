package com.airline.webservices;

import java.util.List;
import java.util.NoSuchElementException;

import javax.ejb.EJB;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.airline.models.Flight;
import com.airline.service.FlightService;

@Path("/flights")
public class FlightsWebService {

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

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("{flightId}")
	public Flight getFlightById(@PathParam("flightId") Integer flightId) {
		Flight flight = fs.getFlightById(flightId);
		if (flight == null) {
			throw new NoSuchElementException("The flight with id " + flightId + " was not found.");
		}
		return flight;
	}

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response addNewFlight(Flight flight) {
		fs.addNewFlight(flight);
		return Response.ok().build();
	}

}
