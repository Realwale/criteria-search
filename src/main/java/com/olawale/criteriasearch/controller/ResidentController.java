package com.olawale.criteriasearch.controller;

import com.olawale.criteriasearch.entity.Resident;
import com.olawale.criteriasearch.service.ResidentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/residents")
public class ResidentController {

    private final ResidentService service;

    @PostMapping
    public ResponseEntity<String> addResident(@RequestBody Resident resident){
        return new ResponseEntity<>(service.addResident(resident), HttpStatus.CREATED);
    }
}
