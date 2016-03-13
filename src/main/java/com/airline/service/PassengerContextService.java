package com.airline.service;

import java.io.Serializable;

import javax.enterprise.context.SessionScoped;

import com.airline.models.Passenger;

@SessionScoped
public class PassengerContextService implements Serializable {

	private static final long serialVersionUID = -3374684462905174572L;

	private Passenger currentPassenger;

	public Passenger getCurrentPassenger() {
		return this.currentPassenger;
	}

	public void setCurrentPassenger(Passenger passenger) {
		this.currentPassenger = passenger;
	}

}
