package pay2park.model.merchant;

import pay2park.model.entityFromDB.ParkingLot;
import pay2park.model.entityFromDB.PriceTicket;

import java.util.ArrayList;
import java.util.List;

public class ParkingLotGetData {

    public Integer id;
    public String name;
    public Integer numberSlot;
    public Integer numberSlotRemaining;
    public String address;
    public Integer status;
    public Double lat;
    public Double lng;
    public String timeOpen;
    public String timeClose;
    public String phone;
    public List<PriceWithVehicle> priceTable;

    public ParkingLotGetData(ParkingLot parkingLot, List<PriceTicket> priceTickets) {
        this.id = parkingLot.getId();
        this.name = parkingLot.getParkingLotName();
        this.numberSlot = parkingLot.getNumberSlot();
        this.numberSlotRemaining = parkingLot.getNumberSlotRemaining();
        this.address = parkingLot.getStreet() + ", " +  parkingLot.getWard() + ", " + parkingLot.getDistrict() + ", " + parkingLot.getCity();
        this.status = parkingLot.getStatus();
        this.lat = parkingLot.getLat();
        this.lng = parkingLot.getLng();
        this.timeOpen = parkingLot.getTimeOpen();
        this.timeClose = parkingLot.getTimeClose();
        this.phone = parkingLot.getPhoneNumber();

        this.priceTable = new ArrayList<>();
        for (PriceTicket priceTicket : priceTickets) {
            // add priceWithVehicle
            boolean isCreated = false;
            for (PriceWithVehicle priceWithVehicle : this.priceTable) {
                if (priceWithVehicle.vehicleTypeId == priceTicket.getVehicleType().getId()) {
                    isCreated = true;
                    break;
                }
            }
            if (!isCreated) {
                this.priceTable.add(new PriceWithVehicle(priceTicket.getVehicleType().getId(), new ArrayList<>()));
            }

            // add priceItem
            for (PriceWithVehicle priceWithVehicle : this.priceTable) {
                if (priceWithVehicle.vehicleTypeId == priceTicket.getVehicleType().getId()) {
                    priceWithVehicle.prices.add(new PriceItem(priceTicket));
                    break;
                }
            }
        }

    }
}
