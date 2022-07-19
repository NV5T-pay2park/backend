package com.example.pay2parkbackend.repositories;

import com.example.pay2parkbackend.model.ParkingLot;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ParkingLotRepository extends JpaRepository<ParkingLot, Long> {
}
