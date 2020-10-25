/**
 * 
 */
package com.immfly.flightmanagment.service;


import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;
import java.util.ArrayList;
import java.util.List;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import static org.mockito.ArgumentMatchers.any;
import com.immfly.flightmanagment.model.FlightData;
import com.immfly.flightmanagment.model.FlightNode;
import com.immfly.flightmanagment.repository.FlightExternalRepository;
import com.immfly.flightmanagment.repository.FlightManagementRepository;
import com.immfly.flightmanagment.service.impl.FlightManagementServiceImpl;

/**
 * @author akramkohansal
 *
 */
public class FlightManagementServiceTest {

    @Mock
    private FlightManagementRepository flightRepository;
    @Mock
    private FlightExternalRepository flightExternalRepository;
    
    @InjectMocks
    FlightManagementServiceImpl service = new FlightManagementServiceImpl(flightRepository, flightExternalRepository); 
    
    private FlightData buildFlightData() {
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
        return data;
    }
    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
    }
    
    @Test
    public void testGetFlightByTailAndNumber_ok() {
        FlightData sampleData = buildFlightData();
        when(flightRepository.getByTailAndFlightNumber("EC-MYT", "653")).thenReturn(sampleData);
        FlightData flightData = service.getFlightByTailAndNumber("EC-MYT", "653");
        
        assertNotNull(flightData);
        assertEquals(flightData.getAirline(), sampleData.getAirline());
    }
    @Test
    public void testSaveFlight() {
        List<FlightData> list = new ArrayList<>();
        list.add(buildFlightData());
        doNothing().when(flightRepository).save(any(FlightData.class));
        
        service.save(list);
    }
}
