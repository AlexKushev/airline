package com.airline.service;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.ejb.Singleton;
import javax.ejb.Startup;

import com.airline.utils.DatabaseUtils;

@Singleton
@Startup
public class TestDataInserter {

	@EJB
	private DatabaseUtils db;

	@PostConstruct
	public void init() {
		db.addTestDataToDB();
	}

}
