package com.example.pay2parkbackend.repositories;

import com.example.pay2parkbackend.model.VehicleType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VehicleTypeRepository extends JpaRepository<VehicleType, Long> {
}
