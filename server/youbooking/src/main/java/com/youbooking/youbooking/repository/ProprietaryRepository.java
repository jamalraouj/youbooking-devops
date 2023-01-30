package com.youbooking.youbooking.repository;

import com.youbooking.youbooking.entity.Proprietary;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProprietaryRepository extends JpaRepository<Proprietary , Long> {
    Proprietary findByEmail(String name);
}
