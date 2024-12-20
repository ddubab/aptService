package com.example.aptService.data;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.net.MalformedURLException;

@RestController("/data")
@RequiredArgsConstructor
public class testController {
    private final openAPIClient openAPIClient;

    @GetMapping("/get")
    public void testGetData() throws MalformedURLException, IOException {
        openAPIClient.testGetData(String LAWD_CD, String DEAL_YWD);
    }
}
