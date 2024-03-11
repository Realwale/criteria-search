package com.olawale.criteriasearch.service;

import com.olawale.criteriasearch.dto.request.AddResidentReq;
import com.olawale.criteriasearch.dto.request.SearchRequest;
import com.olawale.criteriasearch.entity.Resident;

import java.util.List;

public interface ResidentService {

    String addResident(AddResidentReq resident);

    List<Resident> findAllResident(SearchRequest request);
}
