package com.gridnine.testing.filter;

import java.util.HashMap;
import java.util.Map;

public class FlightFilterInitialization {

    public static Map<String, FlightFilter> filters = new HashMap<>();

    static {
        filters.put("DepartingInPast", new DepartingInPast());
        filters.put("ArrivesBeforeDeparts", new ArrivesBeforeDeparts());
        filters.put("MoreTwoHoursGroundTime", new MoreTwoHoursGroundTime());
    }

}
