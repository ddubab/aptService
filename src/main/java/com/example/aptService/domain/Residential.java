package com.example.aptService.domain;

import com.example.aptService.controller.port.out.ResidentialData;
import com.example.aptService.data.ApartmentItem;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "residential")
@Builder
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Residential {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "residential_id")
    private Long residentialId;
    private String umdNm;
    private Long excluUseAr;
    private int buildYear;
    private Long dealAmount;
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
                .buildYear(apartmentItem.getBuildYear())
                .dealMonth(apartmentItem.getDealMonth())
                .dealAmount(Long.parseLong(apartmentItem.getDealAmount()))
                .dealDay(apartmentItem.getDealDay())
                .dealYear(apartmentItem.getDealYear())
                .floor(apartmentItem.getFloor())
                .jibun(apartmentItem.getJibun())
                .landLeaseholdGbn(apartmentItem.getLandLeaseholdGbn())
                .umdNm(apartmentItem.getUmdNm())
                .excluUseAr(apartmentItem.getExcluUseAr()).
                build();
    }

    public static ResidentialData from(Residential residential) {
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
