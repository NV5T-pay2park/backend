package pay2park.repository;

import org.springframework.stereotype.Repository;
import pay2park.model.checkinout.CheckInData;
import pay2park.model.parking.VehicleData;

import java.util.concurrent.ConcurrentHashMap;
/* repository store current pending ticket (waiting for enter licence plate)
* */

@Repository
public class PendingTicketRepository {
    private static final ConcurrentHashMap<CheckInData, VehicleData> pendingTicket = new ConcurrentHashMap<>();

    public boolean addPendingTicket(CheckInData checkInData) {
        // already have this pending ticket
        if (pendingTicket.containsKey(checkInData)) {
            return false;
        }
        pendingTicket.put(checkInData, new VehicleData(-1, null));
        return true;
    }

    public void removePendingTicket(CheckInData checkInData) {
        pendingTicket.remove(checkInData);
    }

    public void setPendingTicketInformation(CheckInData checkInData, VehicleData vehicleData) {
        pendingTicket.put(checkInData, vehicleData);
    }

    public boolean isPendingTicket(CheckInData checkInData) {
        return pendingTicket.containsKey(checkInData) && pendingTicket.get(checkInData).getVehicleTypeID() == -1;
    }

    public VehicleData getPendingTicketInformation(CheckInData checkInData) {
        return pendingTicket.get(checkInData);
    }

}
