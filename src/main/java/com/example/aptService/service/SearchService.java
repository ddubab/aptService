package com.example.aptService.service;

import com.example.aptService.controller.port.out.ResidentialData;

import java.util.List;
import java.util.Map;


public interface SearchService {

    public List<ResidentialData> searchResidential(String umdNm, Map<String, Integer> conditions);





}
