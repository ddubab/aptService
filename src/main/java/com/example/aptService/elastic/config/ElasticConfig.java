package com.example.aptService.elastic.config;

import co.elastic.clients.transport.TransportOptions;
import org.apache.http.HttpHost;
import org.apache.tomcat.util.http.parser.HttpHeaderParser;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.elasticsearch.client.ClientConfiguration;
import org.springframework.data.elasticsearch.client.elc.ElasticsearchConfiguration;
import org.springframework.data.elasticsearch.client.elc.ReactiveElasticsearchConfiguration;
import org.springframework.data.elasticsearch.repository.config.EnableElasticsearchRepositories;
import org.springframework.data.elasticsearch.support.HttpHeaders;

import java.util.List;

@Configuration
public class ElasticConfig extends ElasticsearchConfiguration {
    @Value("${spring.elasticsearch.uris}")
    private String esHost;

    @Override
    public ClientConfiguration clientConfiguration() {
        HttpHeaders httpHeaders = new org.springframework.data.elasticsearch.support.HttpHeaders();
        httpHeaders.add("Authorization", "ApiKey MExMMHo1TUJuZ2JsREc5ZTAwVno6WXNzX1hrV0JSMEdPY2hlRlRYNEpFQQ==");
        return ClientConfiguration.builder()
                .connectedTo(esHost)
                .build();
    }


}
