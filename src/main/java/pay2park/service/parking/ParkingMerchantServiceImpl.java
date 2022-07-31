package pay2park.service.parking;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pay2park.model.entityFromDB.*;
import pay2park.model.parking.*;
import pay2park.repository.*;

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

    @Autowired
    PriceTicketRepository priceTicketRepository;

    @Autowired
    VehicleTypeRepository vehicleTypeRepository;

    @Override
    public List<ParkingMerchantListData> list(Integer merchantId) {
        List<ParkingLot> parkingLots = parkingLotRepository.findByMerchantId(merchantId);

        List<ParkingMerchantListData> parkingMerchantList = new ArrayList<>();

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
        try {
            ParkingLot parkingLot = new ParkingLot();

            parkingLot.setParkingLotName(parkingMerchantCreateData.parkingLotName);
            parkingLot.setNumberSlot(parkingMerchantCreateData.numberSlot);
            parkingLot.setNumberSlotRemaining(parkingMerchantCreateData.numberSlot);
            parkingLot.setStreet(parkingMerchantCreateData.street);
            parkingLot.setWard(parkingMerchantCreateData.ward);
            parkingLot.setDistrict(parkingMerchantCreateData.district);
            parkingLot.setCity(parkingMerchantCreateData.city);
            parkingLot.setStatus(1); // actived

            Optional<Merchant> merchantOptional = merchantRepository.findById(parkingMerchantCreateData.merchantId);
            if (merchantOptional.isPresent())
                return false;
            parkingLot.setMerchant(merchantOptional.get());

            parkingLot.setLat(parkingMerchantCreateData.lat);
            parkingLot.setLng(parkingMerchantCreateData.lng);
            parkingLot.setTimeOpen(parkingMerchantCreateData.timeOpen);
            parkingLot.setTimeClose(parkingMerchantCreateData.timeClose);
            parkingLot.setPhoneNumber(parkingMerchantCreateData.phoneNumber);

            parkingLotRepository.save(parkingLot);


            for (PriceWithVehicle priceWithVehicle : parkingMerchantCreateData.priceTable) {
                Optional<VehicleType> vehicleTypeOptional = vehicleTypeRepository.findById(priceWithVehicle.vehicleTypeId);
                if (!vehicleTypeOptional.isPresent()) {
                    return false;
                }
                VehicleType vehicleType = vehicleTypeOptional.get();

                for (PriceItem priceItem : priceWithVehicle.prices) {

                    PriceTicket priceTicket = new PriceTicket();

                    priceTicket.setParkingLot(parkingLot);
                    priceTicket.setVehicleType(vehicleType);
                    priceTicket.setPeriodTime(priceItem.periodTime);
                    priceTicket.setPrice(priceItem.price);
                    priceTicket.setUnit(priceItem.unit);

                    priceTicketRepository.save(priceTicket);
                }
            }

            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public boolean delete(Integer parkingLotId) {
        try {
            Optional<ParkingLot> parkingLotOptional = parkingLotRepository.findById(parkingLotId);

            if (!parkingLotOptional.isPresent())
                return false;

            parkingLotRepository.delete(parkingLotOptional.get());

            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public boolean update(ParkingMerchantUpdateData parkingMerchantUpdateData) {
        try {
            Optional<ParkingLot> parkingLotOptional = parkingLotRepository.findById(parkingMerchantUpdateData.parkingLotId);
            if (!parkingLotOptional.isPresent()) {
                return false;
            }
            ParkingLot parkingLot = parkingLotOptional.get();

            parkingLot.setParkingLotName(parkingMerchantUpdateData.parkingLotName);
            parkingLot.setNumberSlot(parkingMerchantUpdateData.numberSlot);
            parkingLot.setNumberSlotRemaining(parkingMerchantUpdateData.numberSlot);
            parkingLot.setStreet(parkingMerchantUpdateData.street);
            parkingLot.setWard(parkingMerchantUpdateData.ward);
            parkingLot.setDistrict(parkingMerchantUpdateData.district);
            parkingLot.setCity(parkingMerchantUpdateData.city);
            parkingLot.setStatus(parkingMerchantUpdateData.status);
            parkingLot.setLat(parkingMerchantUpdateData.lat);
            parkingLot.setLng(parkingMerchantUpdateData.lng);
            parkingLot.setTimeOpen(parkingMerchantUpdateData.timeOpen);
            parkingLot.setTimeClose(parkingMerchantUpdateData.timeClose);
            parkingLot.setPhoneNumber(parkingMerchantUpdateData.phoneNumber);

            parkingLotRepository.save(parkingLot);

            List<PriceTicket> priceTickets = priceTicketRepository.findByParkingLotId(parkingLot);
            for (PriceTicket priceTicket : priceTickets) {
                priceTicketRepository.delete(priceTicket);
            }

            for (PriceWithVehicle priceWithVehicle : parkingMerchantUpdateData.priceTable) {
                Optional<VehicleType> vehicleTypeOptional = vehicleTypeRepository.findById(priceWithVehicle.vehicleTypeId);
                if (!vehicleTypeOptional.isPresent()) {
                    return false;
                }
                VehicleType vehicleType = vehicleTypeOptional.get();

                for (PriceItem priceItem : priceWithVehicle.prices) {
                    PriceTicket priceTicket = new PriceTicket();

                    priceTicket.setParkingLot(parkingLot);
                    priceTicket.setVehicleType(vehicleType);
                    priceTicket.setPeriodTime(priceItem.periodTime);
                    priceTicket.setPrice(priceItem.price);
                    priceTicket.setUnit(priceItem.unit);

                    priceTicketRepository.save(priceTicket);
                }
            }

            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public ParkingMerchantGetData getParkingLot(Integer parkingLotId) {
        Optional<ParkingLot> parkingLotOptional = parkingLotRepository.findById(parkingLotId);
        if (!parkingLotOptional.isPresent()) {
            System.out.println("Not found paking lot!!!");
            return null;
        }

        ParkingLot parkingLot = parkingLotOptional.get();

        List<PriceTicket> priceTickets = priceTicketRepository.getPriceTicketByParkingLotId(parkingLot);

        ParkingMerchantGetData data = new ParkingMerchantGetData(parkingLot, priceTickets);

        return data;
    }

}
