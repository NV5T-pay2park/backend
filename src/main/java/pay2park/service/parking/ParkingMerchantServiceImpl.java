package pay2park.service.parking;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pay2park.model.entityFromDB.ParkingLot;
import pay2park.model.entityFromDB.ParkingLotImage;
import pay2park.model.parking.ParkingMerchantListData;
import pay2park.repository.ParkingLotImageRepository;
import pay2park.repository.ParkingLotRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class ParkingMerchantServiceImpl implements ParkingMerchantService{

    @Autowired
    ParkingLotRepository parkingLotRepository;

    @Autowired
    ParkingLotImageRepository parkingLotImageRepository;

    @Override
    public List<ParkingMerchantListData> list(int merchantId) {
        List<ParkingLot> parkingLots = parkingLotRepository.findByMerchantId(merchantId);

        List<ParkingMerchantListData> parkingMerchantList = new ArrayList<ParkingMerchantListData>();

        for (ParkingLot parkingLot : parkingLots) {
            List<ParkingLotImage> parkingLotImageList = parkingLotImageRepository.getAllImageByParkingLot(parkingLot);
            if (parkingLotImageList.size() > 0) {
                parkingMerchantList.add(new ParkingMerchantListData(parkingLot, parkingLotImageList.get(0)));
            } else {
                parkingMerchantList.add(new ParkingMerchantListData(parkingLot));
            }
        }

        return parkingMerchantList;
    }

    @Override
    public boolean create(int merchantId) {
        return false;
    }
}
