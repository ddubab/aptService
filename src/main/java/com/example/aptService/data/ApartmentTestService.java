package com.example.aptService.data;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;

@Service
public class ApartmentTestService {

    public ApartmentItems parsingJsonObject(String json) {
        ApartmentItems items = null;
        try {
            ObjectMapper mapper = new ObjectMapper();
            items = mapper.readValue(json, ApartmentItems.class);
        } catch(Exception e) {
            e.printStackTrace();
        }
        return items;
    }
}
