package com.example.aptService.elastic.repository;

import com.example.aptService.elastic.domain.ResidentialDocument;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.data.elasticsearch.repository.config.EnableElasticsearchRepositories;
import org.springframework.data.util.Streamable;
import org.springframework.stereotype.Repository;

import java.util.List;
@EnableElasticsearchRepositories
public interface ResidentialElasticRepository extends ElasticsearchRepository<ResidentialDocument, String> {
    List<ResidentialDocument> findByUmdNm(String UmdNm);
    Streamable<ResidentialDocument> findByDealAmountBetween(int min, int max);
    Streamable<ResidentialDocument> findByExcluUseArBetween(int min, int max);
    Streamable<ResidentialDocument> findByBuildYearBetween(int minYear);

    List<ResidentialDocument> findByUmdNmAndDealAmountBetweenAndExcluUseArBetweenAndBuildYearGreaterThanEqual(String umdNm,
                                                                                                                       int amountMin, int amoutMax,
                                                                                                                       int areaMin, int areaMax,
                                                                                                                       int minYear);


}