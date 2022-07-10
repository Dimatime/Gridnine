package com.gridnine.testing.filter;

import com.gridnine.testing.flight.Flight;
import com.gridnine.testing.flight.Segment;

import java.time.LocalDateTime;

public class DepartingInPast implements FlightFilter {

    @Override
    public boolean check(Flight flight) {
        for (Segment seg : flight.getSegments()) {
            if (seg.getDepartureDate().isBefore(LocalDateTime.now())) {
                return true;
            }
        }
        return false;
    }
}
