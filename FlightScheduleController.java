package com.pankaj.flightschedule.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pankaj.flightschedule.model.FlightSchedule;
import com.pankaj.flightschedule.model.Flights;
import com.pankaj.flightschedule.service.FlightScheduleService;

@RequestMapping(value = "booking")
@RestController
@CrossOrigin
public class FlightScheduleController {
	@Autowired
	FlightScheduleService flightScheduleService;
	
	@GetMapping("{source}/{destination}")
	public List<Flights> getBooking(@PathVariable("source") String source,@PathVariable("destination") String destination) {
		return flightScheduleService.getFlightSchedule(source, destination);
	}

}
