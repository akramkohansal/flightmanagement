/**
 * 
 */
package com.immfly.flightmanagment.repository.mock.impl;

import java.util.ArrayList;
import java.util.List;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;
import com.immfly.flightmanagment.model.FlightData;
import com.immfly.flightmanagment.model.FlightNode;
import com.immfly.flightmanagment.repository.FlightExternalRepository;

/**
 * @author akramkohansal
 * create and return mock data instead of external service 
 */
@Repository
@Profile("mock-client")
public class MockFlightExternalRepositoryImpl implements FlightExternalRepository{

    @Override
    public List<FlightData> getFlightsByTailNumber(String tailNumber) {
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
        data.setTailNumber(tailNumber);
        data.setType("Form_Airline");
        
        
        FlightNode origin = new FlightNode();
        origin.setAirportName("Tenerife North (Los Rodeos)");
        origin.setAlternayeIdent("TFN");
        origin.setCity("Tenerife");
        origin.setCode("GCXO");
        data.setOrigin(origin);

        FlightNode destination = new FlightNode();
        destination.setAirportName("La Gomera");
        destination.setAlternayeIdent("GMZ");
        destination.setCity("La Gomera");
        destination.setCode("GCGM");
        data.setDestination(destination);
        
        FlightData data2 = new FlightData();
        data2.setAirline("IBB");
        data2.setAirlineIata("NT");
        data2.setBlocked(false);
        data2.setDiverted(false);
        
        data2.setCancelled(false);
        data2.setCodeShares("IBE123");
        data2.setFaFlightID("IBB653-1581399936-airline-0137");
        data2.setFlightNumber("654");
        data2.setIdent("IBB653");
        data2.setTailNumber(tailNumber);
        data2.setType("Form_Airline");
        data2.setOrigin(origin);
        
        FlightNode destination2 = new FlightNode();
        destination2.setAirportName("El Prat de Llobregat");
        destination2.setAlternayeIdent("GMZ");
        destination2.setCity("Barcelona");
        destination2.setCode("BCN");
        data2.setDestination(destination2);
        
        List<FlightData> datas = new ArrayList<>();
        datas.add(data);
        datas.add(data2);
        return datas;
    }

}
