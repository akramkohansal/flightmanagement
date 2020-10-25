package com.immfly.flightmanagment.model;

import java.io.Serializable;
import com.fasterxml.jackson.annotation.JsonProperty;

public class FlightNode implements Serializable{

	/**
     * 
     */
    private static final long serialVersionUID = 739099627340871746L;
    
    @JsonProperty("code")
    private String code;
    @JsonProperty("city")
	private String city;
    @JsonProperty("alternate_ident")
	private String alternayeIdent;
    @JsonProperty("airport_name")
	private String airportName;
	
    public String getCode() {
        return code;
    }
    public void setCode(String code) {
        this.code = code;
    }
    public String getCity() {
        return city;
    }
    public void setCity(String city) {
        this.city = city;
    }
    public String getAlternayeIdent() {
        return alternayeIdent;
    }
    public void setAlternayeIdent(String alternayeIdent) {
        this.alternayeIdent = alternayeIdent;
    }
    public String getAirportName() {
        return airportName;
    }
    public void setAirportName(String airportName) {
        this.airportName = airportName;
    }
	
	
}
