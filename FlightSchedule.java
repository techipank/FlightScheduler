package com.pankaj.flightschedule.model;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "flight_schedule")
@Getter
@Setter
@NoArgsConstructor
public class FlightSchedule {

	@Id
	@GeneratedValue
	@Column(name = "id")
	private Long id;
	
	@Column(name = "flight_no")
	private String flightNo;
	
	@Column(name = "departure_airport")
	private String departureAirport;
	
	@Column(name = "arrival_airport")
	private String arrivalAirport;
	
	@Column(name = "departure_time")
	private Timestamp departureTime;
	
	@Column(name = "arrival_time")
	private Timestamp arrivalTime;

	@Override
	public String toString() {
		return "FlightSchedule [id=" + id + ", flightNo=" + flightNo + ", departureAirport=" + departureAirport
				+ ", arrivalAirport=" + arrivalAirport + ", departureTime=" + departureTime + ", arrivalTime="
				+ arrivalTime + "]";
	}
	
	
}
