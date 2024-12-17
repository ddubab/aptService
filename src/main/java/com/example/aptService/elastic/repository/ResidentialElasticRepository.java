package com.example.aptService.elastic.repository;

import com.example.aptService.elastic.domain.ResidentialDocument;
import org.springframework.data.elasticsearch.core.SearchHit;
import org.springframework.data.elasticsearch.core.SearchHits;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import java.util.List;

public interface ResidentialElasticRepository extends ElasticsearchRepository<ResidentialDocument, String> {
    List<ResidentialDocument> findByBuildYear(String buildYear);
}
