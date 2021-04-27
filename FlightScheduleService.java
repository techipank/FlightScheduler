package com.pankaj.flightschedule.service;

import java.util.List;

import com.pankaj.flightschedule.model.Flights;

public interface FlightScheduleService {
	
	public List<Flights> getFlightSchedule(String departureAirport,String arrivalAirport);

}
