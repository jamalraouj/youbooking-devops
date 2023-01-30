package com.youbooking.youbooking.service;

import com.youbooking.youbooking.entity.Proprietary;
import com.youbooking.youbooking.repository.ProprietaryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProprietaryService implements IService<Proprietary , Long> {
    @Autowired
    ProprietaryRepository proprietaryRepository;
    @Override
    public Proprietary add(Proprietary proprietary) {
        return null;
    }

    @Override
    public boolean delete(Long i) {
        return false;
    }

    @Override
    public Proprietary findOneById(Long i) {
        return null;
    }

    @Override
    public Proprietary update(Proprietary proprietary) {
        return null;
    }

    @Override
    public List<Proprietary> findAll() {
        return proprietaryRepository.findAll();
    }
}
