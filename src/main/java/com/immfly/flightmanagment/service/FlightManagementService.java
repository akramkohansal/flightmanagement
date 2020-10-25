/**
 * 
 */
package com.immfly.flightmanagment.service;

import java.util.List;
import com.immfly.flightmanagment.model.FlightData;

/**
 * @author akramkohansal
 *
 */
public interface FlightManagementService {

    public void loadFlightsBasedontailNumberAndPersist(String tailNumber);
    
    public void save(List<FlightData> datas);
    
    public FlightData getFlightByTailAndNumber(String tailNumber, String flightNumber);
}
