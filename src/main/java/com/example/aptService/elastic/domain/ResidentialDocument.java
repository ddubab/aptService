package com.example.aptService.elastic.domain;

import com.example.aptService.data.ApartmentItem;
import lombok.Builder;
import lombok.Getter;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;


@Document(indexName = "residential")
@Getter
@Builder
public class ResidentialDocument {
    @Id
    private String id;
    @Field(type = FieldType.Long, index = false, docValues = false)
    private Long residential_id;
    @Field(type = FieldType.Keyword)
    private int buildYear;
    @Field(type = FieldType.Text)
    private String dealAmount;
    @Field(type = FieldType.Text)
    private String excluUseAr;
    @Field(type = FieldType.Text)
    private String umdNm;

    public ResidentialDocument to(ApartmentItem item) {
        return ResidentialDocument.builder()
                .residential_id(1L)
                .buildYear(item.getBuildYear())
                .dealAmount(item.getDealAmount())
                .excluUseAr(item.getExcluUseAr())
                .umdNm(item.getUmdNm()).build();
    }


}
