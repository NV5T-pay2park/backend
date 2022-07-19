package com.example.pay2parkbackend.repositories;

import com.example.pay2parkbackend.model.EndUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EndUserRepository extends JpaRepository<EndUser, Long> {
}
