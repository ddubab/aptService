package com.example.aptService.data;

import com.fasterxml.jackson.core.JacksonException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

@RequiredArgsConstructor
public class ApartmentItemDeserializer extends JsonDeserializer<ApartmentItems> {

    public ApartmentItemDeserializer() {
        this.objectMapper = new ObjectMapper();
    }
    //Todo : deserializer를 사용하면 왜 기본 생성자가 있어야 할까?
    private final ObjectMapper objectMapper;

    @Override
    public ApartmentItems deserialize(JsonParser p, DeserializationContext ctxt) throws IOException, JacksonException {
        JsonNode node = p.getCodec().readTree(p);
        JsonNode itemNode = node.findValue("item");

        List<ApartmentItem> items = Arrays.stream(objectMapper.treeToValue(itemNode, ApartmentItem[].class)).toList();

        return new ApartmentItems(items);
    }


}