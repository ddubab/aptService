package com.example.aptService.domain;

import jakarta.persistence.*;

@Entity
@Table(name = "residential")
public class Residential {
    @Id
    @Column(name = "train_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String umdNm;
    private String excluUseAr;
    private String buildYear;
    private String dealAmount;
    private String aptName;
    private String floor;
    private String aptDong;
    private String dealYear;
    private String dealMonth;
    private String dealDay;
    private String jibun;
    private String landLeaseholdGbn;




}
