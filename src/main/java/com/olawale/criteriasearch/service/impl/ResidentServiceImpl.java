package com.olawale.criteriasearch.service.impl;

import com.olawale.criteriasearch.entity.Resident;
import com.olawale.criteriasearch.repository.ResidentRepository;
import com.olawale.criteriasearch.service.ResidentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ResidentServiceImpl implements ResidentService {

    private ResidentRepository residentRepository;


    @Override
    public String addResident(Resident resident) {

        Resident checkResident = residentRepository.findByEmail(resident.getEmail())
                .orElseThrow(()-> new RuntimeException("Resident already exists with email "+ resident.getEmail()));

        Resident newResident = Resident.builder()
                .email(checkResident.getEmail())
                .firstName(checkResident.getFirstName())
                .lastName(checkResident.getLastName())
                .phone(checkResident.getPhone())
                .build();

        residentRepository.save(newResident);

        return "New resident added successfully";
    }
}
