package pay2park.service.checkinout;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import pay2park.Pay2parkBackendApplication;
import pay2park.model.checkinout.CheckInData;
import pay2park.model.checkinout.PreCheckOutData;
import pay2park.model.entityFromDB.VehicleType;
import pay2park.model.parking.VehicleData;
import pay2park.repository.TicketsRepository;
import pay2park.repository.VehicleTypeRepository;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@SpringBootTest(classes = Pay2parkBackendApplication.class)
class CheckInServiceImplTest {
    @Mock
    TicketsRepository ticketsRepository;
    @Mock
    VehicleTypeRepository vehicleTypeRepository;
    @BeforeEach
    void setMockOutput() throws IOException {
        when(vehicleTypeRepository.existsById(1)).thenReturn(true);
    }

    @InjectMocks
    CheckInServiceImpl checkInServiceImpl = new CheckInServiceImpl();
    @DisplayName("Test invalid information")
    @Test
    void testCheckInDataIsInValid() {
        VehicleData vehicleData = null;
        assertEquals(false, checkInServiceImpl.isValidInformationCheckIn(vehicleData));

    }
    @DisplayName("Test valid information")
    @Test
    void testCheckInDataIsValid1() {

        VehicleData vehicleData = new VehicleData();
        vehicleData.setVehicleTypeID(1);
        vehicleData.setLicensePlate("AB");
        assertEquals(true, checkInServiceImpl.isValidInformationCheckIn(vehicleData));

    }

    @DisplayName("Test invalid information - license plate")
    @Test
    void testCheckInDataIsInValid1() {

        VehicleData vehicleData = new VehicleData();
        vehicleData.setVehicleTypeID(1);
        vehicleData.setLicensePlate("");
        assertEquals(false, checkInServiceImpl.isValidInformationCheckIn(vehicleData));

    }

}