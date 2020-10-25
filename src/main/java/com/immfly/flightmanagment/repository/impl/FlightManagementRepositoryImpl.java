/**
 * 
 */
package com.immfly.flightmanagment.repository.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;
import com.immfly.flightmanagment.model.FlightData;
import com.immfly.flightmanagment.repository.FlightManagementRepository;

/**
 * @author akramkohansal
 *
 */
@Repository
public class FlightManagementRepositoryImpl implements FlightManagementRepository{

    private static final String FLIGHT_REDIS_KEY_STRING = "Flights";
    
    private RedisTemplate<String, FlightData> redisTemplate;
    private HashOperations<String, String, FlightData> hashOperations; 
    
    @Autowired
    public FlightManagementRepositoryImpl(RedisTemplate<String, FlightData> redisTemplate) {
        this.redisTemplate = redisTemplate;
        hashOperations = redisTemplate.opsForHash();
    }
    @Override
    public FlightData getByTailAndFlightNumber(String tailNumber, String flightNumber) {
        return (FlightData) hashOperations.get(FLIGHT_REDIS_KEY_STRING, tailNumber+"-"+flightNumber);
    }
    @Override
    public void save(FlightData flightData) {
        if(flightData != null) {
            hashOperations.put(FLIGHT_REDIS_KEY_STRING, flightData.getTailNumber().concat("-"+ flightData.getFlightNumber()) ,flightData);
        }
    }
}
