//package pay2park.service.parking;
//
//import org.aspectj.lang.annotation.Before;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.DisplayName;
//import org.junit.jupiter.api.Test;
//import org.junit.runner.RunWith;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.MockitoAnnotations;
//import org.mockito.junit.MockitoJUnitRunner;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.mock.mockito.MockBean;
//import pay2park.model.checkinout.PreCheckOutData;
//import pay2park.model.entityFromDB.ParkingLot;
//import pay2park.model.parking.ParkingListData;
//import pay2park.repository.ParkingLotRepository;
//
//import java.io.IOException;
//import java.util.ArrayList;
//import java.util.List;
//
//import static org.junit.jupiter.api.Assertions.*;
//
//import static org.mockito.Mockito.when;
//@RunWith(MockitoJUnitRunner.class)
//class ParkingServiceImplTest {
////    List<ParkingLot> rawData = parkingLotRepository.findAll();
////    List<ParkingListData> parkingList = new ArrayList<ParkingListData>();
////
////        for (ParkingLot parkingLot : rawData) {
////        parkingList.add(new ParkingListData(parkingLot, 0.0, 0));
////    }
////        return parkingList;
//    @Autowired
//    ParkingLotRepository parkingLotRepository;
//    @InjectMocks
//    ParkingServiceImpl parkingServiceImpl = new ParkingServiceImpl();
//
//    @Before("")
//    public void setUp() throws Exception {
//        MockitoAnnotations.initMocks(this);
//    }
//    @DisplayName("Test get all parking")
//    @Test
//    void testGetAllParking() {
////        List<ParkingLot> parkingLotList = new ArrayList<>();
////        ParkingLot parkingLot = new ParkingLot();
////        parkingLotList.add(parkingLot);
////        when(parkingLotRepository.findAll()).thenReturn(parkingLotList);
////        assertEquals(1, parkingServiceImpl.getAllParking().size());
//    }
//}