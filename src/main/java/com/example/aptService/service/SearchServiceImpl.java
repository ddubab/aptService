package com.example.aptService.service;

import com.example.aptService.controller.port.out.ResidentialData;
import com.example.aptService.domain.Residential;
import com.example.aptService.elastic.domain.ResidentialDocument;
import com.example.aptService.elastic.repository.ResidentialElasticRepository;
import com.example.aptService.repository.ResidentialRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
public class SearchServiceImpl implements SearchService{
    private final ResidentialElasticRepository residentialElasticRepository;
    private final ResidentialRepository residentialRepository;
    @Override
    public List<ResidentialData> searchResidential(String umdNm, Map<String, Integer> conditions) {


        List<ResidentialDocument> residentialDocuments = residentialElasticRepository.findByUmdNmAndDealAmountBetweenAndExcluUseArBetweenAndBuildYearGreaterThanEqual(
                umdNm, conditions.get("dealAmountMin"), conditions.get("dealAmountMax"), conditions.get("excluUseArMin"),
                conditions.get("excluUseArMax"), conditions.get("buildYearMin")
        );

        log.info("엘라스틱 검색 완료");

        List<Long> ids = residentialDocuments.stream()
                .map(ResidentialDocument::getResidential_id)
                .collect(Collectors.toList());

        List<Residential> residentialList = residentialRepository.findAllByResidentialIdIn(ids);
        log.info("디비 검색 완료");

        return residentialList.stream().map(Residential::from).collect(Collectors.toList());
    }
}
