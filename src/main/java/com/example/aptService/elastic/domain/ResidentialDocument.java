package com.example.aptService.elastic.domain;

import com.example.aptService.data.ApartmentItem;
import com.example.aptService.domain.Residential;
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
    @Field(type = FieldType.Long)
    private int buildYear;
    @Field(type = FieldType.Long)
    private Long dealAmount;
    @Field(type = FieldType.Long)
    private Long excluUseAr;
    @Field(type = FieldType.Keyword)
    private String umdNm;

    public static ResidentialDocument to(Residential item) {
        return ResidentialDocument.builder()
                .residential_id(item.getResidentialId())
                .buildYear(item.getBuildYear())
                .dealAmount(item.getDealAmount())
                .excluUseAr(item.getExcluUseAr())
                .umdNm(item.getUmdNm()).build();
    }


}
