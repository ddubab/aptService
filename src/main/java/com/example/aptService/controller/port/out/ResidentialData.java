package com.example.aptService.controller.port.out;

import com.example.aptService.domain.Residential;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class ResidentialData {

    Long residentialId;
    String umdNm;
    Long excluUseAr;
    int buildYear;
    Long dealAmount;
    String residentialName;
    int floor;
    String aptDong;
    int dealYear;
    int dealMonth;
    int dealDay;
    String jibun;
    String landLeaseholdGbn;

    ResidentialData to(Residential residential) {
        return ResidentialData.builder()
                .aptDong(residential.getAptDong())
                .umdNm(residential.getUmdNm())
                .residentialName(residential.getAptName())
                .dealYear(residential.getDealYear())
                .dealMonth(residential.getDealMonth())
                .dealDay(residential.getDealDay())
                .jibun(residential.getJibun())
                .landLeaseholdGbn(residential.getLandLeaseholdGbn())
                .floor(residential.getFloor())
                .excluUseAr(residential.getExcluUseAr())
                .residentialId(residential.getResidentialId())
                .buildYear(residential.getBuildYear())
                .dealAmount(residential.getDealAmount()).build();
    }

}
