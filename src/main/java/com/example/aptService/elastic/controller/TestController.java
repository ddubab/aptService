package com.example.aptService.elastic.controller;

import com.example.aptService.elastic.domain.ResidentialDocument;
import lombok.RequiredArgsConstructor;
import org.springframework.data.elasticsearch.core.ElasticsearchOperations;
import org.springframework.data.elasticsearch.core.SearchHits;
import org.springframework.data.elasticsearch.core.query.Criteria;
import org.springframework.data.elasticsearch.core.query.CriteriaQuery;
import org.springframework.data.elasticsearch.core.query.Query;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController("/")
@RequiredArgsConstructor
public class TestController {
    private final ElasticsearchOperations elasticsearchOperations;

    @PostMapping("residential")
    public String save(@RequestBody ResidentialDocument person) {
        ResidentialDocument savedEntity = elasticsearchOperations.save(person);
        return savedEntity.getId();
    }

    @GetMapping("/residential/{id}")
    public ResidentialDocument findById(@PathVariable("id")  Long id) {
        ResidentialDocument person = elasticsearchOperations.get(id.toString(), ResidentialDocument.class);
        return person;
    }

    Criteria criteria = new Criteria("buildYear").is(2020);
    Query query = new CriteriaQuery(criteria);

    @GetMapping("/resi")
    public SearchHits findByBuildYear() {
        SearchHits person = elasticsearchOperations.search(query, ResidentialDocument.class);
        return person;
    }
}
