package com.gridnine.testing;

import com.gridnine.testing.filter.FlightFilterInitialization;
import com.gridnine.testing.flight.Flight;
import com.gridnine.testing.flight.FlightBuilder;

import java.util.List;

public class Main {

    public static void main(String[] args) {

        List<Flight> flights = FlightBuilder.createFlights();

        flights.stream().filter(FlightFilterInitialization.filters.get("MoreTwoHoursGroundTime")::check)
                .forEach(System.out::println);

    }

}
