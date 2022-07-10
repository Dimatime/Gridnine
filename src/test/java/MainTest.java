import com.gridnine.testing.filter.*;
import com.gridnine.testing.flight.Flight;
import com.gridnine.testing.flight.FlightBuilder;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Collectors;

class MainTest {

    private static List<Flight> flights = FlightBuilder.createFlights();

    @ParameterizedTest
    @MethodSource("sources")
    void testsFilters(FlightFilter flightFilter, List<Flight> expectedList){
        List<Flight> actual = flights.stream().filter(flightFilter::check)
                .collect(Collectors.toList());
        Assertions.assertEquals(expectedList,actual);

    }

    private static List<Arguments> sources() {
        return List.of(
                Arguments.of(FlightFilterInitialization.filters.get("DepartingInPast"), List.of(flights.get(2))),
                Arguments.of(FlightFilterInitialization.filters.get("ArrivesBeforeDeparts"), List.of(flights.get(3))),
                Arguments.of(FlightFilterInitialization.filters.get("MoreTwoHoursGroundTime"), List.of(flights.get(4),flights.get(5)))
        );
    }


}
