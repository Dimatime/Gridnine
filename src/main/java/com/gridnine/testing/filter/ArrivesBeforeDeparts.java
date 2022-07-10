package com.gridnine.testing.filter;

import com.gridnine.testing.flight.Flight;
import com.gridnine.testing.flight.Segment;

import java.time.LocalDateTime;

public class ArrivesBeforeDeparts implements FlightFilter {

    @Override
    public boolean check(Flight flight) {

        for (Segment seg: flight.getSegments()) {
            LocalDateTime dep = seg.getDepartureDate();
            LocalDateTime arr = seg.getArrivalDate();

            if (arr.isBefore(dep))
                 return true;
        }

        return false;
    }
}
