package pay2park.model;

import org.hibernate.Hibernate;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class PriceTicketId implements Serializable {
    private static final long serialVersionUID = -5782542905617921565L;
    @Column(name = "parking_lot_id", nullable = false)
    private Long parkingLotId;

    @Column(name = "vehicle_type_id", nullable = false)
    private Long vehicleTypeId;

    @Column(name = "period_time", nullable = false)
    private Long periodTime;

    public Long getParkingLotId() {
        return parkingLotId;
    }

    public void setParkingLotId(Long parkingLotId) {
        this.parkingLotId = parkingLotId;
    }

    public Long getVehicleTypeId() {
        return vehicleTypeId;
    }

    public void setVehicleTypeId(Long vehicleTypeId) {
        this.vehicleTypeId = vehicleTypeId;
    }

    public Long getPeriodTime() {
        return periodTime;
    }

    public void setPeriodTime(Long periodTime) {
        this.periodTime = periodTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        PriceTicketId entity = (PriceTicketId) o;
        return Objects.equals(this.vehicleTypeId, entity.vehicleTypeId) &&
                Objects.equals(this.periodTime, entity.periodTime) &&
                Objects.equals(this.parkingLotId, entity.parkingLotId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(vehicleTypeId, periodTime, parkingLotId);
    }

}