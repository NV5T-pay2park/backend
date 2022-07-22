package pay2park.model.entityFromDB;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "vehicle_types")
public class VehicleType {
    @Id
    @Column(name = "vehicle_type_id", nullable = false)
    private Integer id;

    @Column(name = "vehicle_type_name", nullable = false, length = 50)
    private String vehicleTypeName;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getVehicleTypeName() {
        return vehicleTypeName;
    }

    public void setVehicleTypeName(String vehicleTypeName) {
        this.vehicleTypeName = vehicleTypeName;
    }

}