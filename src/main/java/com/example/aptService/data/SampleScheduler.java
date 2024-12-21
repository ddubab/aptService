package com.example.aptService.data;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.HashSet;
import java.util.Set;

@Slf4j
@Component
@RequiredArgsConstructor
public class SampleScheduler {
    private final openAPIClient openAPIClient;

    @Scheduled(fixedRate = 1000000)
    public void fixedRate() throws MalformedURLException, IOException {

        Set<String> codeSet = new HashSet<>();
        String filePath = "src/main/java/com/example/aptService/data/areaCode.txt";  // 파일 경로 설정

        // 파일 읽기
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                codeSet.add(line.trim());  // 각 줄을 읽어 Set에 추가
            }
        } catch (IOException e) {
            e.printStackTrace();
        }


        // For문을 사용하여 Set 순회
        for (String code : codeSet) {
            System.out.println("Code: " + code);
            openAPIClient.getData(code, "202411");
        }
        log.info("fixedRate Scheduler");
    }
}