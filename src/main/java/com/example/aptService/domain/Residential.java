package com.example.aptService.domain;

import com.example.aptService.data.ApartmentItem;
import jakarta.persistence.*;
import lombok.Builder;

@Entity
@Table(name = "residential")
@Builder
public class Residential {
    @Id
    @Column(name = "residential_id")
    private Long residential_id;
    private String umdNm;
    private String excluUseAr;
    private int buildYear;
    private String dealAmount;
    private String aptName;
    private int floor;
    private String aptDong;
    private int dealYear;
    private int dealMonth;
    private int dealDay;
    private String jibun;
    private String landLeaseholdGbn;


    public Residential to(ApartmentItem apartmentItem) {
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



}
