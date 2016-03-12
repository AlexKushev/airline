package com.airline.service;

import java.io.Serializable;

import javax.enterprise.context.SessionScoped;

import com.airline.models.Passenger;

@SessionScoped
public class UserContext implements Serializable {

	private static final long serialVersionUID = -3115541536412732994L;

	private Passenger currentPassenger;

	public Passenger getCurrentPassenger() {
		return currentPassenger;
	}

	public void setCurrentPassenger(Passenger currentPassenger) {
		this.currentPassenger = currentPassenger;
	}

}
