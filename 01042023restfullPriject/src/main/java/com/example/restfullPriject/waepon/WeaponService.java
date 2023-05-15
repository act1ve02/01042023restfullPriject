package com.example.restfullPriject.waepon;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WeaponService {

    private final WeaponRepository repository;
    @Autowired

    public WeaponService(WeaponRepository repository) {
        this.repository = repository;
    }
}
