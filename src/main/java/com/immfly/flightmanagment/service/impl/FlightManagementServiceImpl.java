/**
 * 
 */
package com.immfly.flightmanagment.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.immfly.flightmanagment.model.FlightData;
import com.immfly.flightmanagment.repository.FlightExternalRepository;
import com.immfly.flightmanagment.repository.FlightManagementRepository;
import com.immfly.flightmanagment.service.FlightManagementService;

/**
 * @author akramkohansal
 *
 */
@Service
public class FlightManagementServiceImpl implements FlightManagementService{

    private FlightManagementRepository flightRepository;
    
    private FlightExternalRepository flightExternalRepository;
    /**
     * 
     * @param flightRepository
     * @param flightExternalRepository
     */
    @Autowired
    public FlightManagementServiceImpl(FlightManagementRepository flightRepository, FlightExternalRepository flightExternalRepository) {
        super();
        this.flightRepository = flightRepository;
        this.flightExternalRepository = flightExternalRepository;
    }
    /**
     * 
     */
    @Override
    public void save(List<FlightData> datas) {
        
        datas.forEach(d -> System.out.println(d.getTailNumber()));
        datas.forEach(d -> System.out.println(d.getFlightNumber()));
       datas.forEach(d -> flightRepository.save(d));
        
    }

    
    @Override
    public FlightData getFlightByTailAndNumber(String tailNumber, String flightNumber) {
        return flightRepository.getByTailAndFlightNumber(tailNumber, flightNumber);
    }

    @Override
    public void loadFlightsBasedontailNumberAndPersist(String tailNumber) {
        System.out.println(tailNumber);
        try {
            List<FlightData> datas = flightExternalRepository.getFlightsByTailNumber(tailNumber);
            save(datas);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    
}
