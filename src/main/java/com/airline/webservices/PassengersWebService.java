package com.airline.webservices;

import java.net.HttpURLConnection;
import java.util.List;

import javax.ejb.EJB;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.airline.models.Passenger;
import com.airline.service.PassengerContextService;
import com.airline.service.PassengerService;

@Path("/passenger")
public class PassengersWebService {

	private static final Response RESPONSE_OK = Response.ok().build();

	@PersistenceContext(unitName = "airline")
	private EntityManager em;

	@EJB
	private PassengerService ps;

	@Inject
	private PassengerContextService context;

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
		Passenger checkedPassenger = ps.checkUserLoginInformation(passenger.getEmail(), passenger.getPassword());
		if (checkedPassenger == null) {
			return Response.status(HttpURLConnection.HTTP_UNAUTHORIZED).build();
		}

		context.setCurrentPassenger(checkedPassenger);
		return RESPONSE_OK;
	}

	@Path("/current")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Passenger getUser() {
		if (context.getCurrentPassenger() == null) {
			return null;
		}

		return context.getCurrentPassenger();
	}

}
