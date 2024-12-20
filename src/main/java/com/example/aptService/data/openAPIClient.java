package com.example.aptService.data;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.catalina.connector.Request;
import org.apache.http.entity.ContentType;
import org.json.XML;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.beans.XMLDecoder;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

@Slf4j
@Service
@RequiredArgsConstructor
public class openAPIClient {
    private final ApartmentTestService apartmentTestService;
    @Value("${spring.openAPI.apiUrl}")
    private final String apiUrl;
    @Value("${spring.openAPI.serviceKey}")
    private final String serviceKey;

//    // JSON 응답을 객체로 변환
//    ObjectMapper mapper = new ObjectMapper();
//    List<Apartment> apartments = Arrays.asList(mapper.readValue(response, Apartment[].class));
//
//    // 데이터 출력
//        apartments.forEach(apartment -> {
//        System.out.println("Name: " + apartment.getName());
//        System.out.println("Location: " + apartment.getLocation());
//        System.out.println("Price: " + apartment.getPrice());
//        System.out.println("----------");
//    });

    void testGetData(String LAWD_CD, String DEAL_YWD) throws MalformedURLException, IOException {
        HttpURLConnection urlConnection = null;
        InputStream stream = null;


        String requestUrl = apiUrl + "serviceKey=" + serviceKey + "&LAWD_CD=" + LAWD_CD + "&DEAL_YMD=" + DEAL_YMD;
        System.out.println(requestUrl);

        try {
            URL url = new URL(requestUrl);

            urlConnection = (HttpURLConnection) url.openConnection();
            stream = getNetworkConnection(urlConnection);
            String result = readStreamToString(stream);
            log.info(result);

            System.out.println(XML.toJSONObject(result));
            System.out.println(XML.toJSONObject(result).toString());

            String result2 = XML.toJSONObject(result).toString();

            System.out.println(apartmentTestService.parsingJsonObject(result2));

            if (stream != null) stream.close();
        } catch(IOException e) {
            e.printStackTrace();
        } finally {
            if (urlConnection != null) {
                urlConnection.disconnect();
            }
        }

    }
    private InputStream getNetworkConnection(HttpURLConnection urlConnection) throws IOException {
        urlConnection.setConnectTimeout(3000);
        urlConnection.setReadTimeout(3000);
        urlConnection.setRequestMethod("GET");
        urlConnection.setDoInput(true);

        if(urlConnection.getResponseCode() != HttpURLConnection.HTTP_OK) {
            throw new IOException("HTTP error code : " + urlConnection.getResponseCode());
        }

        return urlConnection.getInputStream();
    }

    /* InputStream을 전달받아 문자열로 변환 후 반환 */
    private String readStreamToString(InputStream stream) throws IOException{
        StringBuilder result = new StringBuilder();

        BufferedReader br = new BufferedReader(new InputStreamReader(stream, "UTF-8"));

        String readLine;
        while((readLine = br.readLine()) != null) {
            result.append(readLine + "\n\r");
        }

        br.close();

        return result.toString();
    }
}
