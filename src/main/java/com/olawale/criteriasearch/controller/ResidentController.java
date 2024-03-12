package com.olawale.criteriasearch.controller;

import com.olawale.criteriasearch.dto.request.AddResidentReq;
import com.olawale.criteriasearch.entity.Resident;
import com.olawale.criteriasearch.service.ResidentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/residents")
public class ResidentController {

    private final ResidentService service;

    @PostMapping
    public ResponseEntity<String> addResident(@RequestBody AddResidentReq resident){
        return new ResponseEntity<>(service.addResident(resident), HttpStatus.CREATED);
    }

    @GetMapping("/residents")
    public List<Resident> getResidentsByCriteria(@RequestParam(required = false) String firstName,
                                                 @RequestParam(required = false) String lastName,
                                                 @RequestParam(required = false) String email) {
        return service.findAllResident(firstName, lastName, email);
    }
}
