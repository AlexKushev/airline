package com.airline.webservices;

import java.net.HttpURLConnection;
import java.util.List;

import javax.ejb.EJB;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

import com.airline.models.Passenger;
import com.airline.service.PassengerService;

@Path("/passenger")
public class PassengersWebService {

	private static final Response RESPONSE_OK = Response.ok().build();

	@PersistenceContext(unitName = "airline")
	private EntityManager em;

	@EJB
	private PassengerService ps;

	@Context
	private UriInfo uriInfo;

	public PassengersWebService() {

	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Passenger> getPassengers() {

		List<Passenger> pList = ps.getAllPassenger();

		return pList;

	}

	@Path("/login")
	@POST
	@Consumes("application/json")
	public Response loginPassenger(Passenger passenger) {
		boolean isPassengerValid = ps.checkUserLoginInformation(passenger.getEmail(), passenger.getPassword());
		if (!isPassengerValid) {
			return Response.status(HttpURLConnection.HTTP_UNAUTHORIZED).build();
		}

		return RESPONSE_OK;
	}

}
