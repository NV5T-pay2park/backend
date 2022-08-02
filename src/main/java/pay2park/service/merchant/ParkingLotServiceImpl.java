package pay2park.service.merchant;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pay2park.model.entityFromDB.*;
import pay2park.model.merchant.*;
import pay2park.repository.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ParkingLotServiceImpl implements ParkingLotService {

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

    @Autowired
    MerchantEmployeeRepository merchantEmployeeRepository;

    @Override
    public List<ParkingLotListData> list(Integer merchantId) {
        List<ParkingLot> parkingLots = parkingLotRepository.findByMerchantId(merchantId);

        List<ParkingLotListData> parkingLotList = new ArrayList<>();

        for (ParkingLot parkingLot : parkingLots) {
            if (parkingLot.getStatus() == 0)
                continue;
            List<ParkingLotImage> parkingLotImageList = parkingLotImageRepository.getAllImageByParkingLot(parkingLot);
            if (parkingLotImageList.size() > 0) {
                parkingLotList.add(new ParkingLotListData(parkingLot, parkingLotImageList.get(0)));
            } else {
                parkingLotList.add(new ParkingLotListData(parkingLot));
            }
        }

        return parkingLotList;
    }

    @Override
    public ParkingLotCreateResponseData create(ParkingLotCreateData parkingLotCreateData) {
        try {
            ParkingLot parkingLot = new ParkingLot();
            parkingLot.setParkingLotName(parkingLotCreateData.parkingLotName);
            parkingLot.setNumberSlot(parkingLotCreateData.numberSlot);
            parkingLot.setNumberSlotRemaining(parkingLotCreateData.numberSlot);
            parkingLot.setStreet(parkingLotCreateData.street);
            parkingLot.setWard(parkingLotCreateData.ward);
            parkingLot.setDistrict(parkingLotCreateData.district);
            parkingLot.setCity(parkingLotCreateData.city);
            parkingLot.setStatus(1); // actived

            Optional<Merchant> merchantOptional = merchantRepository.findById(parkingLotCreateData.merchantId);

            if (!merchantOptional.isPresent())
                return new ParkingLotCreateResponseData(false, "Invalid merchantId");
            parkingLot.setMerchant(merchantOptional.get());

            parkingLot.setLat(parkingLotCreateData.lat);
            parkingLot.setLng(parkingLotCreateData.lng);
            parkingLot.setTimeOpen(parkingLotCreateData.timeOpen);
            parkingLot.setTimeClose(parkingLotCreateData.timeClose);
            parkingLot.setPhoneNumber(parkingLotCreateData.phoneNumber);

            parkingLotRepository.save(parkingLot);


            for (PriceWithVehicle priceWithVehicle : parkingLotCreateData.priceTable) {
                Optional<VehicleType> vehicleTypeOptional = vehicleTypeRepository.findById(priceWithVehicle.vehicleTypeId);
                if (!vehicleTypeOptional.isPresent()) {
                    return new ParkingLotCreateResponseData(false, "Invalid vehicleTypeId");
                }
                VehicleType vehicleType = vehicleTypeOptional.get();

                for (PriceItem priceItem : priceWithVehicle.prices) {
                    priceTicketRepository.save(new PriceTicket(parkingLot, vehicleType, priceItem));
                }
            }

            return new ParkingLotCreateResponseData(true, "Success", parkingLot.getId());
        } catch (Exception e) {
            return new ParkingLotCreateResponseData(false, "Exception");
        }
    }

    @Override
    public boolean delete(Integer parkingLotId) {
        try {
            Optional<ParkingLot> parkingLotOptional = parkingLotRepository.findById(parkingLotId);
            if (!parkingLotOptional.isPresent()) {
                return false;
            }
            ParkingLot parkingLot = parkingLotOptional.get();

            parkingLot.setStatus(0);

            parkingLotRepository.save(parkingLot);

            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public boolean update(ParkingLotUpdateData parkingLotUpdateData) {
        try {
            Optional<ParkingLot> parkingLotOptional = parkingLotRepository.findById(parkingLotUpdateData.parkingLotId);
            if (!parkingLotOptional.isPresent()) {
                return false;
            }
            ParkingLot parkingLot = parkingLotOptional.get();

            parkingLot.setParkingLotName(parkingLotUpdateData.parkingLotName);
            Integer numberSlot = parkingLotUpdateData.numberSlot - parkingLot.getNumberSlot();
            parkingLot.change(numberSlot);
            parkingLot.setStreet(parkingLotUpdateData.street);
            parkingLot.setWard(parkingLotUpdateData.ward);
            parkingLot.setDistrict(parkingLotUpdateData.district);
            parkingLot.setCity(parkingLotUpdateData.city);
            parkingLot.setStatus(parkingLotUpdateData.status);
            parkingLot.setLat(parkingLotUpdateData.lat);
            parkingLot.setLng(parkingLotUpdateData.lng);
            parkingLot.setTimeOpen(parkingLotUpdateData.timeOpen);
            parkingLot.setTimeClose(parkingLotUpdateData.timeClose);
            parkingLot.setPhoneNumber(parkingLotUpdateData.phoneNumber);

            parkingLotRepository.save(parkingLot);

            List<PriceTicket> priceTickets = priceTicketRepository.findByParkingLotId(parkingLot);
            for (PriceTicket priceTicket : priceTickets) {
                priceTicketRepository.delete(priceTicket);
            }

            for (PriceWithVehicle priceWithVehicle : parkingLotUpdateData.priceTable) {
                Optional<VehicleType> vehicleTypeOptional = vehicleTypeRepository.findById(priceWithVehicle.vehicleTypeId);
                if (!vehicleTypeOptional.isPresent()) {
                    return false;
                }
                VehicleType vehicleType = vehicleTypeOptional.get();

                for (PriceItem priceItem : priceWithVehicle.prices) {
                    priceTicketRepository.save(new PriceTicket(parkingLot, vehicleType, priceItem));
                }
            }

            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public ParkingLotGetData getParkingLot(Integer parkingLotId) {
        Optional<ParkingLot> parkingLotOptional = parkingLotRepository.findById(parkingLotId);
        if (!parkingLotOptional.isPresent()) {
            System.out.println("Not found paking lot!!!");
            return null;
        }

        ParkingLot parkingLot = parkingLotOptional.get();

        List<PriceTicket> priceTickets = priceTicketRepository.getPriceTicketByParkingLotId(parkingLot);

        ParkingLotGetData data = new ParkingLotGetData(parkingLot, priceTickets);

        return data;
    }

    @Override
    public Integer getByEmployeeId(Integer employeeId) {
        Optional<MerchantEmployee> merchantEmployeeOptional = merchantEmployeeRepository.findById(employeeId);
        if (!merchantEmployeeOptional.isPresent()) {
            System.out.println("Not found paking lot!!!");
            return null;
        }

        MerchantEmployee merchantEmployee = merchantEmployeeOptional.get();

        return merchantEmployee.getParkingLot().getId();
    }

}
