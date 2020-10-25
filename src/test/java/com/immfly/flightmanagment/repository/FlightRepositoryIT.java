/**
 * 
 */
package com.immfly.flightmanagment.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import com.immfly.flightmanagment.FlightmanagmentApplication;
import com.immfly.flightmanagment.config.TestRedisConfiguration;
import com.immfly.flightmanagment.model.FlightData;
import com.immfly.flightmanagment.model.FlightNode;
import com.immfly.flightmanagment.repository.FlightManagementRepository;

/**
 * @author akramkohansal
 *
 */
@SpringBootTest(classes = {FlightmanagmentApplication.class, TestRedisConfiguration.class})
public class FlightRepositoryIT {
    
    @Autowired
    FlightManagementRepository flightRepository;
    
    @Test
    public void testSaveAndGet() {
        FlightData data = new FlightData();
        data.setAirline("IBB");
        data.setAirlineIata("NT");
        data.setBlocked(false);
        data.setDiverted(false);
        
        data.setCancelled(false);
        data.setCodeShares("IBE123");
        data.setFaFlightID("IBB653-1581399936-airline-0136");
        data.setFlightNumber("653");
        data.setIdent("IBB653");
        data.setTailNumber("EC-MYT");
        data.setType("Form_Airline");
        
        
        FlightNode destination = new FlightNode();
        destination.setAirportName("La Gomera");
        destination.setAlternayeIdent("GMZ");
        destination.setCity("La Gomera");
        destination.setCode("GCGM");
        data.setDestination(destination);
        FlightNode origin = new FlightNode();
        origin.setAirportName("Tenerife North (Los Rodeos)");
        origin.setAlternayeIdent("TFN");
        origin.setCity("Tenerife");
        origin.setCode("GCXO");
        data.setOrigin(origin);
        flightRepository.save(data);
        FlightData  data2 = flightRepository.getByTailAndFlightNumber(data.getTailNumber(), data.getFlightNumber());
        
        assertEquals(data2.getAirline(), "IBB");
    }
    
}
