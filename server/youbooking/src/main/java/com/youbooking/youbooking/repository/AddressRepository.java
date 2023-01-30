package com.youbooking.youbooking.repository;

import com.youbooking.youbooking.entity.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository extends JpaRepository<Address,Long> {
}
