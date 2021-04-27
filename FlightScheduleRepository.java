package com.pankaj.flightschedule.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.pankaj.flightschedule.model.FlightSchedule;

@Repository
public interface FlightScheduleRepository extends JpaRepository<FlightSchedule, Integer>{

	@Query("from FlightSchedule flightSchedule where flightSchedule.departureAirport=:departureAirport or flightSchedule.arrivalAirport=:arrivalAirport")
	public List<FlightSchedule> getFlightSchedule(String departureAirport,String arrivalAirport);

	
}
