package pay2park.service.parking;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pay2park.model.entityFromDB.Merchant;
import pay2park.model.entityFromDB.ParkingLot;
import pay2park.model.entityFromDB.ParkingLotImage;
import pay2park.model.parking.parkingMerchantCreate.ParkingMerchantCreateData;
import pay2park.model.parking.ParkingMerchantListData;
import pay2park.repository.MerchantRepository;
import pay2park.repository.ParkingLotImageRepository;
import pay2park.repository.ParkingLotRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ParkingMerchantServiceImpl implements ParkingMerchantService{

    @Autowired
    ParkingLotRepository parkingLotRepository;

    @Autowired
    ParkingLotImageRepository parkingLotImageRepository;

    @Autowired
    MerchantRepository merchantRepository;


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
    public boolean create(ParkingMerchantCreateData parkingMerchantCreateData) {
        ParkingLot parkingLot = new ParkingLot();
        parkingLot.setParkingLotName(parkingMerchantCreateData.parkingLotName);
        parkingLot.setNumberSlot(parkingMerchantCreateData.numberSlot);
        parkingLot.setNumberSlotRemaining(parkingMerchantCreateData.numberSlot);
        parkingLot.setStreet(parkingMerchantCreateData.street);
        parkingLot.setWard(parkingMerchantCreateData.ward);
        parkingLot.setDistrict(parkingMerchantCreateData.district);
        parkingLot.setCity(parkingMerchantCreateData.city);
        parkingLot.setStatus(1); // actived
        Optional<Merchant> merchant = merchantRepository.findById(parkingMerchantCreateData.merchantId);
        parkingLot.setMerchant(merchant);
        parkingLot.setLat(parkingMerchantCreateData.lat);
        parkingLot.setIng(parkingMerchantCreateData.lng);
        parkingLot.setTimeOpen(0);
        parkingLot.setTimeClose(0);
        parkingLot.setPhoneNumber(parkingMerchantCreateData.phoneNumber);

        try {
            parkingLotRepository.save(parkingLot);
            // price ticket handling
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
