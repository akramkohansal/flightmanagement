package com.immfly.flightmanagment.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.immfly.flightmanagment.model.FlightData;
import com.immfly.flightmanagment.service.FlightManagementService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;



@Controller
@RequestMapping
@Api(value = "Flights", tags = "The Flight Management API")
public class FlightManagementController {
	
	
    private FlightManagementService flightManagementService;
    
    
    @Autowired
	public FlightManagementController(FlightManagementService flightManagementService) {
        super();
        this.flightManagementService = flightManagementService;
    }


    @ApiOperation(value = "return flight info filter by tail number and flight number",
			nickname = "FlightInformation")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Flight Data", response = FlightData.class),
            @ApiResponse(code = 204, message = "No Data"),
            @ApiResponse(code = 401, message = "Unauthorize"),
            @ApiResponse(code = 403, message = "Forbidden access")
            })
    @RequestMapping(value = "/private/v1/flight-information/{tail-number}/{flight-number}",
            produces = {"application/json; charset=UTF-8"},
            method = RequestMethod.GET)
	public ResponseEntity<FlightData> getFlightofTailByNumber(@PathVariable("tail-number") String tailNumber, @PathVariable("flight-number") String flightNumber){
        FlightData data = flightManagementService.getFlightByTailAndNumber(tailNumber, flightNumber);
        if(data == null) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
		 return new ResponseEntity<>(data, HttpStatus.OK);
	}

    @ApiOperation(value = "fetch flights by tailNumber from external service and cached them",
            nickname = "ExternalFlightInformation")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Ok"),
            @ApiResponse(code = 401, message = "Unauthorize"),
            @ApiResponse(code = 403, message = "Forbidden access")
            })
    @RequestMapping(value = "/private/v1/external-flight-information/{tail-number}",
            produces = {"application/json; charset=UTF-8"},
            method = RequestMethod.GET)
    public ResponseEntity<FlightData> getExternalFlightsByTailNumber(@PathVariable("tail-number") String tailNumber){
        
        flightManagementService.loadFlightsBasedontailNumberAndPersist(tailNumber);
       
         return new ResponseEntity<>(HttpStatus.OK);
    }
}
