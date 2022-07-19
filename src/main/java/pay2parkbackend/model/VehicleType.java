package com.example.pay2parkbackend.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "vehicle_types")
public class VehicleType {
    @Id
    @Column(name = "vehicle_type_id", nullable = false)
    private Long id;

    @Column(name = "vehicle_type_name", nullable = false, length = 50)
    private String vehicleTypeName;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getVehicleTypeName() {
        return vehicleTypeName;
    }

    public void setVehicleTypeName(String vehicleTypeName) {
        this.vehicleTypeName = vehicleTypeName;
    }

}