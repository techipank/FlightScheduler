package com.pankaj.flightschedule.serviceImpl;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pankaj.flightschedule.model.FlightSchedule;
import com.pankaj.flightschedule.model.Flights;
import com.pankaj.flightschedule.repository.FlightScheduleRepository;
import com.pankaj.flightschedule.service.FlightScheduleService;

@Service
public class FlightScheduleServiceImpl implements FlightScheduleService {

	@Autowired
	FlightScheduleRepository flightScheduleRepository; 
	
	@Override
	public List<Flights> getFlightSchedule(String departureAirport, String arrivalAirport) {
		List<FlightSchedule> scheduledFlights=flightScheduleRepository.getFlightSchedule(departureAirport, arrivalAirport);
		List<FlightSchedule> departureFlights=scheduledFlights.stream().filter(schedule -> schedule.getDepartureAirport().equalsIgnoreCase(departureAirport)).collect(Collectors.toList());
		List<FlightSchedule> arrivalFlights=scheduledFlights.stream().filter(schedule -> schedule.getArrivalAirport().equalsIgnoreCase(arrivalAirport)).collect(Collectors.toList());
		List<Flights> flightsList=new ArrayList<>();
		for (int i = 0; i < departureFlights.size(); i++) {
			for (int j = 0; j < arrivalFlights.size(); j++) {
				LocalDateTime arrivalTime=departureFlights.get(i).getArrivalTime().toLocalDateTime();
				LocalDateTime departureTime =arrivalFlights.get(j).getDepartureTime().toLocalDateTime();
				
				int difference=(int) ChronoUnit.MINUTES.between(arrivalTime, departureTime);
				if(difference<0) {
					difference=(int) ChronoUnit.MINUTES.between(arrivalTime, departureTime.plusDays(1));
				}
				
				if(difference>=120 && difference<=480) {
					Flights flights=new Flights();
					flights.setSourceFlights(departureFlights.get(i));
					flights.setConnectingFlights(arrivalFlights.get(j));
					flightsList.add(flights);
				}
			}
		}
		return flightsList;
		
		
	}

}
