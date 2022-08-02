package pay2park.controller.checkinout;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import net.minidev.json.JSONObject;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import pay2park.IntegrationTest;
import pay2park.Pay2parkBackendApplication;
import pay2park.controller.ResponseObject2JSON;
import pay2park.model.ResponseObject;
import pay2park.model.checkinout.CheckInData;
import pay2park.model.checkinout.CheckInInformation;
import pay2park.model.entityFromDB.EndUser;
import pay2park.model.entityFromDB.ParkingLot;
import pay2park.model.parking.VehicleData;
import pay2park.repository.EndUserRepository;
import pay2park.repository.ParkingLotRepository;
import pay2park.service.checkinout.CheckInService;

import java.sql.Array;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@AutoConfigureMockMvc
@ActiveProfiles("test")
@SpringBootTest(classes = Pay2parkBackendApplication.class)
@Timeout(3)
class CheckInControllerTest {
    @Autowired
    private CheckInService checkInService;
    @Autowired
    private EndUserRepository endUserRepository;
    @Autowired
    private ParkingLotRepository parkingLotRepository;
    @Autowired
    private MockMvc mockMvc;

    private ObjectMapper mapper;

    @BeforeEach
    void setUp() {
        mapper = new ObjectMapper();
    }

    @Test
    void checkIn()  {
        // GIVEN
        int endUserID = 4;
        int parkingLotID = 15;
        CheckInData req = new CheckInData(endUserID, parkingLotID);
        JSONObject reqJson = new JSONObject();
        reqJson.put("endUserID", req.getEndUserID());
        reqJson.put("parkingLotID", req.getParkingLotID());
        VehicleData vehicleData = new VehicleData(1, "54C1-19832");

        EndUser endUser = endUserRepository.findById(endUserID).get();
        ParkingLot parkingLot = parkingLotRepository.findById(parkingLotID).get();
        JSONObject expected = new JSONObject();
        expected.put("endUserID", req.getEndUserID());
        expected.put("parkingLotID", req.getParkingLotID());
        expected.put("endUserName", endUser.getFirstName() + " " + endUser.getLastName());
        expected.put("parkingLotName", parkingLot.getParkingLotName());

        // WHEN
        Mockito.when(checkInService.checkIn(req))
                .thenReturn();

        String actual;
        try {
            byte[] actualBytes = mockMvc.perform( MockMvcRequestBuilders
                            .post("/api/checkIn/")
                            .content(String.valueOf(reqJson))
                            .contentType(MediaType.APPLICATION_JSON)
                            .accept(MediaType.APPLICATION_JSON))
                    .andExpect(status().isOk())
                    .andReturn().getResponse().getContentAsByteArray();
            actual = Arrays.toString(actualBytes);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        // THEN
        try {
            assertEquals(mapper.readTree(String.valueOf(expected)), mapper.readTree(actual));
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    void getInformationCheckInData() {
        // GIVEN
        CheckInData checkInData = new CheckInData(4, 15);
        VehicleData vehicleData = new VehicleData(1, "54C1-19832");
        CheckInInformation reqObj = new CheckInInformation(checkInData, vehicleData);
        JSONObject req = new JSONObject();
        req.put("checkInData", reqObj.getCheckInData());
        req.put("vehicleData", reqObj.getVehicleData());

        ResponseObject expectedRes = checkInService.getResponseFromCheckInDataAndVehicleData(checkInData, vehicleData);
        JSONObject expected = ResponseObject2JSON.cast(expectedRes);

        // WHEN
        String actual;
        try {
            actual = mockMvc.perform( MockMvcRequestBuilders
                            .post("/api/sendInformationCheckIn")
                            .content(String.valueOf(req))
                            .contentType(MediaType.APPLICATION_JSON)
                            .accept(MediaType.APPLICATION_JSON))
                    .andExpect(status().isOk())
                    .andReturn().getResponse().getContentAsString();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        // THEN
        try {
            assertEquals(mapper.readTree(String.valueOf(expected)), mapper.readTree(actual));
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }
}
