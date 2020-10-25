/**
 * 
 */
package com.immfly.flightmanagment.repository;

import java.util.List;
import com.immfly.flightmanagment.model.FlightData;

/**
 * @author akramkohansal
 *
 */
public interface FlightExternalRepository {

    public List<FlightData> getFlightsByTailNumber(String tailNumber);
}
