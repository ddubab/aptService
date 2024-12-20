package com.example.aptService.data;

import com.example.aptService.domain.Residential;
import com.example.aptService.elastic.domain.ResidentialDocument;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
@Builder
public class ApartmentItem {
    @JsonProperty("umdNm")
    private String umdNm;

    @JsonProperty("excluUseAr")
    private String excluUseAr;

    @JsonProperty("buildYear")
    private int buildYear;

    @JsonProperty("dealAmount")
    private String dealAmount;

    @JsonProperty("aptName")
    private String aptName;

    @JsonProperty("floor")
    private int floor;

    @JsonProperty("aptDong")
    private String aptDong;

    @JsonProperty("dealYear")
    private int dealYear;

    @JsonProperty("dealMonth")
    private int dealMonth;

    @JsonProperty("dealDay")
    private int dealDay;

    @JsonProperty("jibun")
    private String jibun;

    @JsonProperty("landLeaseholdGbn")
    private String landLeaseholdGbn;

    //todo : 이름 고민
    public Residential toTable(ApartmentItem apartmentItem) {
        return Residential.builder()
                .aptDong(apartmentItem.getAptDong())
                .aptName(apartmentItem.getAptName())
                .residential_id(1L)
                .buildYear(apartmentItem.getBuildYear())
                .dealMonth(apartmentItem.getDealMonth())
                .dealAmount(apartmentItem.getDealAmount())
                .dealDay(apartmentItem.getDealDay())
                .dealYear(apartmentItem.getDealYear())
                .floor(apartmentItem.getFloor())
                .jibun(apartmentItem.getJibun())
                .landLeaseholdGbn(apartmentItem.getLandLeaseholdGbn())
                .umdNm(apartmentItem.getUmdNm())
                .excluUseAr(apartmentItem.getExcluUseAr()).
                build();
    }

    public ResidentialDocument toDocument(ApartmentItem item) {
        return ResidentialDocument.builder()
                .residential_id(1L)
                .buildYear(item.getBuildYear())
                .dealAmount(item.getDealAmount())
                .excluUseAr(item.getExcluUseAr())
                .umdNm(item.getUmdNm()).build();
    }
}
