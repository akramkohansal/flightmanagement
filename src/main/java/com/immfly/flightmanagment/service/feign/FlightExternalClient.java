package com.immfly.flightmanagment.service.feign;

import java.util.List;
import javax.websocket.server.PathParam;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.immfly.flightmanagment.model.FlightData;
import com.immfly.flightmanagment.service.feign.config.FeignConfig;

@FeignClient(value = "flightClient", configuration = FeignConfig.class, url="${external.flight_information_tail.url}")
public interface FlightExternalClient {

	@RequestMapping(value = "/v1/flight-information-tail/{tailNumber}", method = RequestMethod.GET)
	public List<FlightData> getFlightsByTail(@PathParam("tailNumber") String tailNumber);
}
