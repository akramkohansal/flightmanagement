/**
 * 
 */
package com.immfly.flightmanagment.repository;

import com.immfly.flightmanagment.model.FlightData;

/**
 * @author akramkohansal
 *
 */
public interface FlightManagementRepository {

    public FlightData getByTailAndFlightNumber(String tailNumber, String flightNumber);
   
    public void save(FlightData flightData);
   
}
