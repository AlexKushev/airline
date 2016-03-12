package com.airline.models;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

import com.airline.enums.FlightDestination;

/**
 * Entity implementation class for Entity: Flight
 *
 */
@Entity
@NamedQueries({ @NamedQuery(name = "Flight.getAll", query = "SELECT f FROM Flight f") })
public class Flight implements Serializable {

	@Transient
	private static final long serialVersionUID = 1L;

	public Flight() {
		super();
	}

	public Flight(FlightDestination destinationFrom, FlightDestination destinationTo, Integer flightPrice, Date date) {
		super();
		this.destinationFrom = destinationFrom;
		this.destinationTo = destinationTo;
		this.flightPrice = flightPrice;
		this.date = date;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;

	@Enumerated(EnumType.STRING)
	private FlightDestination destinationFrom;

	@Enumerated(EnumType.STRING)
	private FlightDestination destinationTo;

	private Integer flightPrice;

	@Temporal(TemporalType.DATE)
	private Date date;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public FlightDestination getDestinationFrom() {
		return destinationFrom;
	}

	public void setDestinationFrom(FlightDestination destinationFrom) {
		this.destinationFrom = destinationFrom;
	}

	public FlightDestination getDestinationTo() {
		return destinationTo;
	}

	public void setDestinationTo(FlightDestination destinationTo) {
		this.destinationTo = destinationTo;
	}

	public Integer getFlightPrice() {
		return flightPrice;
	}

	public void setFlightPrice(Integer flightPrice) {
		this.flightPrice = flightPrice;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	@Override
	public String toString() {
		return "Flight [id=" + id + ", destinationFrom=" + destinationFrom + ", destinationTo=" + destinationTo
				+ ", flightPrice=" + flightPrice + ", date=" + date + "]";
	}

}
