package com.example.aptService.data;

import com.example.aptService.domain.Residential;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
@NoArgsConstructor //todo : 왜 json 객체를 맵핑해줄 때 기본 생성자가 필요할까?
public class ApartmentItem {
    @JsonProperty("umdNm")
    private String umdNm;

    @JsonProperty("excluUseAr")
    private Long excluUseAr;

    @JsonProperty("buildYear")
    private int buildYear;

    @JsonProperty("dealAmount")
    private String dealAmount;

    @JsonProperty("aptNm")
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

    public static Residential toTable(ApartmentItem apartmentItem) {
        Long newDealAmount = exchangeValue(apartmentItem.getDealAmount());
        return Residential.builder()
                .aptDong(apartmentItem.getAptDong())
                .aptName(apartmentItem.getAptName())
                .buildYear(apartmentItem.getBuildYear())
                .dealMonth(apartmentItem.getDealMonth())
                .dealAmount(newDealAmount)
                .dealDay(apartmentItem.getDealDay())
                .dealYear(apartmentItem.getDealYear())
                .floor(apartmentItem.getFloor())
                .jibun(apartmentItem.getJibun())
                .landLeaseholdGbn(apartmentItem.getLandLeaseholdGbn())
                .umdNm(apartmentItem.getUmdNm())
                .excluUseAr(apartmentItem.getExcluUseAr()).
                build();
    }

    private static Long exchangeValue(String dealAmount) {
        if (dealAmount.contains(",")) {
            dealAmount = dealAmount.replace(",","");
        }
        return Long.parseLong(dealAmount);
    }
}
