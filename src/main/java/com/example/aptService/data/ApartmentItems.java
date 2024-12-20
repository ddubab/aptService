package com.example.aptService.data;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.List;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
@AllArgsConstructor
@JsonDeserialize(using = ApartmentItemDeserializer.class)
public class ApartmentItems {
    @JsonProperty("item")
    private List<ApartmentItem> apartmentItems;

}