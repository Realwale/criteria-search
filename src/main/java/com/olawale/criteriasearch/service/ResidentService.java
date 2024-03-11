package com.olawale.criteriasearch.service;

import com.olawale.criteriasearch.dto.request.AddResidentReq;
import com.olawale.criteriasearch.entity.Resident;

public interface ResidentService {

    String addResident(AddResidentReq resident);
}
