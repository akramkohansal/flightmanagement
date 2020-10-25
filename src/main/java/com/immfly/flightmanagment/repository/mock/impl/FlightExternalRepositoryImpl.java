/**
 * 
 */
package com.immfly.flightmanagment.repository.mock.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;
import com.immfly.flightmanagment.model.FlightData;
import com.immfly.flightmanagment.repository.FlightExternalRepository;
import com.immfly.flightmanagment.service.feign.FlightExternalClient;

/**
 * @author akramkohansal
 * 
 * Implementation to call Feign client
 */
@Repository
@Profile("!mock-client")
public class FlightExternalRepositoryImpl implements FlightExternalRepository{

    
    FlightExternalClient flightExternalClient;
    
    @Autowired
    public FlightExternalRepositoryImpl(FlightExternalClient flightExternalClient) {
        super();
        this.flightExternalClient = flightExternalClient;
    }


    @Override
    public List<FlightData> getFlightsByTailNumber(String tailNumber) {
        
        return flightExternalClient.getFlightsByTail( tailNumber);
    }

}
