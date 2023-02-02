package pay2park.controller.checkinout;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import net.minidev.json.JSONObject;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import pay2park.Pay2parkBackendApplication;
import pay2park.controller.ResponseObject2JSON;
import pay2park.model.ResponseObject;
import pay2park.model.checkinout.CheckInData;
import pay2park.model.checkinout.CheckInInformation;
import pay2park.model.entityFromDB.EndUser;
import pay2park.model.entityFromDB.ParkingLot;
import pay2park.model.entityFromDB.VehicleType;
import pay2park.model.parking.VehicleData;
import pay2park.model.ticket.ResponseTicketData;
import pay2park.repository.EndUserRepository;
import pay2park.repository.ParkingLotRepository;
import pay2park.repository.VehicleTypeRepository;
import pay2park.service.checkinout.CheckInService;

import java.nio.charset.StandardCharsets;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;



@AutoConfigureMockMvc
@ActiveProfiles("testMockCheckInService")
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
    private VehicleTypeRepository vehicleTypeRepository;
    @Autowired
    private MockMvc mockMvc;

    private ObjectMapper mapper;
    private CheckInData checkInData;
    private VehicleData vehicleData;

    @BeforeEach
    void setUp() {
        mapper = new ObjectMapper();
        checkInData = new CheckInData(4, 15);
        vehicleData = new VehicleData(1, "54C1-19832");
    }

    @Test
    void checkIn()  {
        // GIVEN
        JSONObject reqJson = new JSONObject();
        reqJson.put("endUserID", checkInData.getEndUserID());
        reqJson.put("parkingLotID", checkInData.getParkingLotID());

        EndUser endUser = endUserRepository.findById(checkInData.getEndUserID()).get();
        ParkingLot parkingLot = parkingLotRepository.findById(checkInData.getParkingLotID()).get();
        VehicleType vehicleType = vehicleTypeRepository.findById(vehicleData.getVehicleTypeID()).get();

        ResponseTicketData ticketData = new ResponseTicketData(
                2208011123501533L,
                "01/08/2022 11:23:50",
                null,
                vehicleData.getLicensePlate(),
                vehicleType.getVehicleTypeName(),
                endUser.getId(),
                endUser.getFirstName() + " " + endUser.getLastName(),
                parkingLot.getId(),
                parkingLot.getParkingLotName(),
                false,
                null
        );

        ResponseObject res = new ResponseObject(HttpStatus.OK, "Success", ticketData);
        JSONObject expected = ResponseObject2JSON.cast(res);

        // WHEN
        Mockito.when(checkInService.checkIn(checkInData)).thenReturn(res);

        String actual;
        try {
            byte[] actualBytes = mockMvc.perform( MockMvcRequestBuilders
                            .post("/api/checkIn/")
                            .content(String.valueOf(reqJson))
                            .contentType(MediaType.APPLICATION_JSON)
                            .accept(MediaType.APPLICATION_JSON))
                    .andExpect(status().isOk())
                    .andReturn().getResponse().getContentAsByteArray();
            actual = new String(actualBytes, StandardCharsets.UTF_8);
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
        CheckInInformation reqObj = new CheckInInformation(checkInData, vehicleData);
        JSONObject req = new JSONObject();
        req.put("checkInData", reqObj.getCheckInData());
        req.put("vehicleData", reqObj.getVehicleData());

        ResponseObject expectedRes = new ResponseObject(HttpStatus.OK, "Success", vehicleData);
        JSONObject expected = ResponseObject2JSON.cast(expectedRes);

        // WHEN
        Mockito.when(checkInService.getResponseFromCheckInDataAndVehicleData(checkInData, vehicleData))
                .thenReturn(expectedRes);

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
