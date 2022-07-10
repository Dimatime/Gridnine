package com.gridnine.testing.filter;

import com.gridnine.testing.flight.Flight;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

public class MoreTwoHoursGroundTime implements FlightFilter {

    @Override
    public boolean check(Flight flight) {

        long groundTime = 0;

        for (int i = 0; i < flight.getSegments().size()-1; i++) {

            LocalDateTime arr = flight.getSegments().get(i).getArrivalDate();
            LocalDateTime dep = flight.getSegments().get(i+1).getDepartureDate();

            groundTime += arr.until(dep, ChronoUnit.HOURS);

        }
        return groundTime >= 2;
    }
}
