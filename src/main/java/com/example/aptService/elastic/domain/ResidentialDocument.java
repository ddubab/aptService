package com.example.aptService.elastic.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;


@Document(indexName = "residential")
public class ResidentialDocument {
    @Id
    private String id;
    @Field(type = FieldType.Long, index = false, docValues = false)
    private Long residential_id;
    @Field(type = FieldType.Keyword)
    private String buildYear;
    @Field(type = FieldType.Text)
    private String dealAmount;
    @Field(type = FieldType.Text)
    private String excluUseAr;
    @Field(type = FieldType.Text)
    private String umdNm;

}
