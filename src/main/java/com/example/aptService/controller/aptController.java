package com.example.aptService.controller;

import com.example.aptService.controller.port.out.ResidentialData;
import com.example.aptService.service.SearchService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/apt")
@RequiredArgsConstructor
public class aptController {

    private final SearchService searchService;

    @GetMapping("/search")
    public List<ResidentialData> search(
            @RequestParam String umdNm,
            @RequestParam(required = false) Integer buildYearMin,
            @RequestParam(required = false) Integer excluUseArMin,
            @RequestParam(required = false) Integer excluUseArMax,
            @RequestParam(required = false) Integer dealAmountMin,
            @RequestParam(required = false) Integer dealAmountMax
    ) {
        Map<String, Integer> conditions = new HashMap<>();

        if (buildYearMin != null) {
            conditions.put("buildYearMin", buildYearMin);
        }else {
            conditions.put("buildYearMin", 1900);
        }
        if (excluUseArMin != null) {
            conditions.put("excluUseArMin", excluUseArMin);
        }else {
            conditions.put("excluUseArMin", 0);
        }
        if (excluUseArMax != null) {
            conditions.put("excluUseArMax", excluUseArMax);
        }else {
            conditions.put("excluUseArMax", 900000000);
        }
        if (dealAmountMin != null) {
            conditions.put("dealAmountMin", dealAmountMin);
        }else {
            conditions.put("dealAmountMin", 0);
        }
        if (dealAmountMax != null) {
            conditions.put("dealAmountMax", dealAmountMax);
        }else {
            conditions.put("dealAmountMax", 900000000);
        }


        return searchService.searchResidential(umdNm, conditions);
    }
}
