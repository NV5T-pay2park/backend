package pay2park.model.entityFromDB;

import org.hibernate.Hibernate;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class PriceTicketId implements Serializable {
    private static final long serialVersionUID = -9048580056216540742L;
    @Column(name = "parking_lot_id", nullable = false)
    private Long parkingLotId;
    @Column(name = "vehicle_type_id", nullable = false)
    private Integer vehicleTypeId;
    @Column(name = "period_time", nullable = false)
    private Integer periodTime;

    public Integer getPeriodTime() {
        return periodTime;
    }

    public void setPeriodTime(Integer periodTime) {
        this.periodTime = periodTime;
    }

    public Integer getVehicleTypeId() {
        return vehicleTypeId;
    }

    public void setVehicleTypeId(Integer vehicleTypeId) {
        this.vehicleTypeId = vehicleTypeId;
    }

    public Long getParkingLotId() {
        return parkingLotId;
    }

    public void setParkingLotId(Long parkingLotId) {
        this.parkingLotId = parkingLotId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(vehicleTypeId, periodTime, parkingLotId);
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
}