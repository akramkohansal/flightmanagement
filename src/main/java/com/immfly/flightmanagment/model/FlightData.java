package com.immfly.flightmanagment.model;

import java.io.Serializable;
import com.fasterxml.jackson.annotation.JsonProperty;

public class FlightData implements Serializable{

	/**
     * 
     */
    private static final long serialVersionUID = 1L;
    @JsonProperty("ident")
    private String ident;
    
    @JsonProperty("faFlightID")
    private String faFlightID;
    
    @JsonProperty("airline")
	private String airline;
    
    @JsonProperty("airline_iata")
	private String airlineIata;
    
    @JsonProperty("flightnumber")
	private String flightNumber;
    @JsonProperty("tailnumber")
	private String tailNumber;
    @JsonProperty("type")
	private String type;
    @JsonProperty("codeshares")
	private String codeShares;
    @JsonProperty("blocked")
	private boolean blocked;
    @JsonProperty("diverted")
	private boolean diverted;
    @JsonProperty("cancelled")
	private boolean cancelled;
    @JsonProperty("origin")
	private FlightNode origin;
    @JsonProperty("destination")
    private FlightNode destination;
	
    public String getIdent() {
        return ident;
    }
    public void setIdent(String ident) {
        this.ident = ident;
    }
    public String getFaFlightID() {
        return faFlightID;
    }
    public void setFaFlightID(String faFlightID) {
        this.faFlightID = faFlightID;
    }
    public String getAirline() {
        return airline;
    }
    public void setAirline(String airline) {
        this.airline = airline;
    }
    public String getAirlineIata() {
        return airlineIata;
    }
    public void setAirlineIata(String airlineIata) {
        this.airlineIata = airlineIata;
    }
    public String getFlightNumber() {
        return flightNumber;
    }
    public void setFlightNumber(String flightNumber) {
        this.flightNumber = flightNumber;
    }
    public String getTailNumber() {
        return tailNumber;
    }
    public void setTailNumber(String tailNumber) {
        this.tailNumber = tailNumber;
    }
    public String getType() {
        return type;
    }
    public void setType(String type) {
        this.type = type;
    }
    public String getCodeShares() {
        return codeShares;
    }
    public void setCodeShares(String codeShares) {
        this.codeShares = codeShares;
    }
    public boolean isBlocked() {
        return blocked;
    }
    public void setBlocked(boolean blocked) {
        this.blocked = blocked;
    }
    public boolean isDiverted() {
        return diverted;
    }
    public void setDiverted(boolean diverted) {
        this.diverted = diverted;
    }
    public boolean isCancelled() {
        return cancelled;
    }
    public void setCancelled(boolean cancelled) {
        this.cancelled = cancelled;
    }
    public FlightNode getOrigin() {
        return origin;
    }
    public void setOrigin(FlightNode origin) {
        this.origin = origin;
    }
    public FlightNode getDestination() {
        return destination;
    }
    public void setDestination(FlightNode destination) {
        this.destination = destination;
    }
	 
}
