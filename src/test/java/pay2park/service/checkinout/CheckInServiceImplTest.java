package pay2park.service.checkinout;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import pay2park.Pay2parkBackendApplication;
import pay2park.model.checkinout.CheckInData;
import pay2park.model.entityFromDB.ParkingLot;
import pay2park.model.parking.VehicleData;
import pay2park.repository.*;
import pay2park.service.websocket.Socket;

import java.io.IOException;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

//@SpringBootTest(classes = Pay2parkBackendApplication.class)
//class CheckInServiceImplTest {
//    @Mock
//    TicketsRepository ticketsRepository;
//    @Mock
//    VehicleTypeRepository vehicleTypeRepository;
//    @Mock
//    ParkingLotRepository parkingLotRepository;
//    @Mock
//    EndUserRepository endUserRepository;
//    @Mock
//    PendingTicketRepository pendingTicketRepository;
//    @Mock
//    Socket socket;
//    @BeforeEach
//    void setMockOutput() throws IOException {
//        when(vehicleTypeRepository.existsById(1)).thenReturn(true);
//        when(vehicleTypeRepository.existsById(2)).thenReturn(true);
//
//    }
//
//    @InjectMocks
//    CheckInServiceImpl checkInServiceImpl = new CheckInServiceImpl();
//    @DisplayName("Test number slot remaining")
//    @Test
//    void testCheckInNumberSlot() {
//        ParkingLot parkingLot = new ParkingLot();
//        parkingLot.setId(1);
//        parkingLot.setNumberSlotRemaining(0);
//        when(parkingLotRepository.findById(1)).thenReturn(Optional.of(parkingLot));
//        VehicleData vehicleData = new VehicleData();
//        vehicleData.setVehicleTypeID(1);
//        vehicleData.setLicensePlate("");
//        CheckInData checkInData = new CheckInData();
//        checkInData.setEndUserID(1);
//        checkInData.setParkingLotID(1);
//        assertEquals("Sold out", checkInServiceImpl.checkIn(checkInData).getMessage());
//    }
//
//    @DisplayName("Data is not valid")
//    @Test
//    void testCheckDataIsNotValid() {
//        ParkingLot parkingLot = new ParkingLot();
//        parkingLot.setId(1);
//        parkingLot.setNumberSlotRemaining(10);
//        when(parkingLotRepository.findById(1)).thenReturn(Optional.of(parkingLot));
//        VehicleData vehicleData = new VehicleData();
//        vehicleData.setVehicleTypeID(1);
//        vehicleData.setLicensePlate("AB");
//        CheckInData checkInData = new CheckInData();
//        checkInData.setEndUserID(1);
//        checkInData.setParkingLotID(1);
//        when(endUserRepository.existsById(1)).thenReturn(true);
//        assertEquals("Data is not valid", checkInServiceImpl.checkIn(checkInData).getMessage());
//    }
//
//    @DisplayName("ticket was created before")
//    @Test
//    void testCheckInTicketCreatedBefore() {
//        ParkingLot parkingLot = new ParkingLot();
//        parkingLot.setId(1);
//        parkingLot.setNumberSlotRemaining(10);
//        when(parkingLotRepository.findById(1)).thenReturn(Optional.of(parkingLot));
//        VehicleData vehicleData = new VehicleData();
//        vehicleData.setVehicleTypeID(1);
//        vehicleData.setLicensePlate("AB");
//        CheckInData checkInData = new CheckInData();
//        checkInData.setEndUserID(1);
//        checkInData.setParkingLotID(1);
//        when(endUserRepository.existsById(1)).thenReturn(true);
//        when(parkingLotRepository.existsById(1)).thenReturn(true);
//        when(pendingTicketRepository.addPendingTicket(checkInData)).thenReturn(false);
//        assertEquals("This user already in queue", checkInServiceImpl.checkIn(checkInData).getMessage());
//    }

//    @DisplayName("valid data")
//    @Test
//    void testCheckInValidData() {
//        ParkingLot parkingLot = new ParkingLot();
//        parkingLot.setId(1);
//        parkingLot.setNumberSlotRemaining(10);
//        when(parkingLotRepository.findById(1)).thenReturn(Optional.of(parkingLot));
//        VehicleData vehicleData = new VehicleData();
//        vehicleData.setVehicleTypeID(1);
//        vehicleData.setLicensePlate("AB");
//        CheckInData checkInData = new CheckInData();
//        checkInData.setEndUserID(1);
//        checkInData.setParkingLotID(1);
//        when(endUserRepository.existsById(1)).thenReturn(true);
//        when(parkingLotRepository.existsById(1)).thenReturn(true);
//        when(pendingTicketRepository.addPendingTicket(checkInData)).thenReturn(true);
//        when(vehicleTypeRepository.existsById(1)).thenReturn(true);
//        when(pendingTicketRepository.isPendingTicket(checkInData)).thenReturn(false);
//        List<Ticket> ticketList = new ArrayList<>();
//        Ticket ticket = new Ticket();
//        ticketList.add(ticket);
//        EndUser endUser = new EndUser();
//        endUser.setId(1);
//
//        when(ticketsRepository.getTicketByEndUserIDAndParkingLot(endUser, parkingLot, "sb")).thenReturn(ticketList);
//
//        assertEquals("Data is not valid", checkInServiceImpl.checkIn(checkInData).getMessage());
//    }

 /*   @DisplayName("get information data")
    @Test
    void getInformationData(){
        CheckInData checkInData = new CheckInData();
        checkInData.setEndUserID(1);
        checkInData.setParkingLotID(1);
        VehicleData vehicleData1 = new VehicleData();
        vehicleData1.setVehicleTypeID(2);
        vehicleData1.setLicensePlate("sb");
        assertEquals("Success", checkInServiceImpl.getInformationByCheckInDataAndVehicleData(checkInData, vehicleData1).getMessage());
    }

    @DisplayName("information checkin")
    @Test
    void informationCheckin(){

        VehicleData vehicleData1 = new VehicleData();
        vehicleData1.setVehicleTypeID(2);
        vehicleData1.setLicensePlate("sb");
        when(vehicleTypeRepository.existsById(2)).thenReturn(true);
        assertEquals(true, checkInServiceImpl.isValidInformationCheckInData(vehicleData1));
    }



}*/