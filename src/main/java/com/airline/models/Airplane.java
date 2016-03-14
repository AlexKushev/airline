package com.airline.models;

import java.io.Serializable;
import javax.persistence.*;

import com.owlike.genson.annotation.JsonIgnore;

/**
 * Entity implementation class for Entity: Airplane
 *
 */
@Entity

public class Airplane implements Serializable {

	private static final long serialVersionUID = 1L;

	public Airplane() {
		super();
	}

	public Airplane(String planeModel, Integer seatingCapacity) {
		super();
		this.planeModel = planeModel;
		this.seatingCapacity = seatingCapacity;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;

	private String planeModel;

	private Integer seatingCapacity;

	@OneToOne(mappedBy = "airplaneDetail")
	private Flight flight;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getPlaneModel() {
		return planeModel;
	}

	public void setPlaneModel(String planeModel) {
		this.planeModel = planeModel;
	}

	public Integer getSeatingCapacity() {
		return seatingCapacity;
	}

	public void setSeatingCapacity(Integer seatingCapacity) {
		this.seatingCapacity = seatingCapacity;
	}

	@JsonIgnore
	public Flight getFlight() {
		return flight;
	}

	public void setFlight(Flight flight) {
		this.flight = flight;
	}

	@Override
	public String toString() {
		return "Airplane [id=" + id + ", planeModel=" + planeModel + ", seatingCapacity=" + seatingCapacity + "]";
	}

}
