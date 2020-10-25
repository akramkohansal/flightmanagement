/**
 * 
 */
package com.immfly.flightmanagment.controoler;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.immfly.flightmanagment.FlightmanagmentApplication;
import com.immfly.flightmanagment.config.TestRedisConfiguration;
import com.immfly.flightmanagment.model.FlightData;
import com.immfly.flightmanagment.model.FlightNode;
import com.immfly.flightmanagment.repository.FlightExternalRepository;
import com.immfly.flightmanagment.repository.FlightManagementRepository;
import com.immfly.flightmanagment.service.FlightManagementService;
import com.immfly.flightmanagment.service.impl.FlightManagementServiceImpl;

/**
 * @author akramkohansal
 *
 */
@SpringBootTest(classes = {FlightmanagmentApplication.class, TestRedisConfiguration.class})
@AutoConfigureMockMvc
@ActiveProfiles("mock-client")
public class FlightManagementControllerIT {

    @Autowired
    private MockMvc mvc;
    
    @org.junit.jupiter.api.Test
    @WithMockUser(username = "user1", password = "pwd", roles = "ADMIN")
    public void whenGetFlightByTailAndNumber_thenReturn200() throws Exception {
        mvc.perform(get("/private/v1/external-flight-information/{tail-number}","EC-MYT2")).
        andExpect(status().isOk()).andReturn();
        mvc.perform(get("/private/v1/flight-information/{tail-number}/{flight-number}","EC-MYT2","653")).
        andExpect(status().isOk()).andReturn();
       
    }
    @org.junit.jupiter.api.Test
    public void whenGetFlightByTailAndNumber_thenReturn401() throws Exception {
        mvc.perform(get("/private/v1/flight-information/{tail-number}/{flight-number}","EC-MYT","653")).
        andExpect(status().isUnauthorized()).andReturn();
    }
    
    @org.junit.jupiter.api.Test
    @WithMockUser(username = "user1", password = "pwd", roles = "USER")
    public void whenGetFlightByTailAndNumber_thenReturnForbidden() throws Exception {
        
        mvc.perform(get("/private/v1/flight-information/{tail-number}/{flight-number}","EC-MYT","653")).
        andExpect(status().isForbidden()).andReturn();
    }
    @org.junit.jupiter.api.Test
    @WithMockUser(username = "user1", password = "pwd", roles = "ADMIN")
    public void whenGetFlightByTailAndNumber_thenReturnNoContent() throws Exception {
        //when(service.getFlightByTailAndNumber("ECMYT", "6531")).thenReturn(null);
        
        mvc.perform(get("/private/v1/flight-information/{tail-number}/{flight-number}","ECMYT","6531")).
        andExpect(status().isNoContent()).andReturn();
        
    }
    
   
}
