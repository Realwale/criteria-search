package com.olawale.criteriasearch.service.impl;

import com.olawale.criteriasearch.dto.request.AddResidentReq;
import com.olawale.criteriasearch.entity.Resident;
import com.olawale.criteriasearch.repository.ResidentCriteriaSearchRepo;
import com.olawale.criteriasearch.repository.ResidentRepository;
import com.olawale.criteriasearch.service.ResidentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ResidentServiceImpl implements ResidentService {

    private final ResidentRepository residentRepository;
    private final ResidentCriteriaSearchRepo searchRepo;


    @Override
    public String addResident(AddResidentReq resident) {
        if (residentRepository.existsByEmail(resident.getEmail())){
        throw new RuntimeException("Resident already exists with email " + resident.getEmail());
    }

        Resident newResident = Resident.builder()
                .email(resident.getEmail())
                .firstName(resident.getFirstName())
                .lastName(resident.getLastName())
                .phone(resident.getPhone())
                .password(resident.getPassword())
                .build();

        residentRepository.save(newResident);

        return "New resident added successfully";
    }

    @Override
    public List<Resident> findAllResident(String firstName, String lastName, String email){
        return searchRepo.findAll(firstName, lastName, email);
    }
}
