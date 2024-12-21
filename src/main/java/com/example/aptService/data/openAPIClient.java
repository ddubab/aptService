package com.example.aptService.data;

import com.example.aptService.domain.Residential;
import com.example.aptService.elastic.domain.ResidentialDocument;
import com.example.aptService.elastic.repository.ResidentialElasticRepository;
import com.example.aptService.repository.ResidentialRepository;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.json.XML;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@Component
public class openAPIClient {
    private final String apiUrl;
    private final String serviceKey;

    private final ResidentialRepository residentialRepository;
    private final ResidentialElasticRepository residentialElasticRepository;

    public openAPIClient(@Value("${spring.openAPI.apiUrl}") String apiUrl,
                         @Value("${spring.openAPI.serviceKey}") String serviceKey,
                         ResidentialRepository residentialRepository,
                         ResidentialElasticRepository residentialElasticRepository) {
        this.apiUrl = apiUrl;
        this.serviceKey = serviceKey;
        this.residentialRepository = residentialRepository;
        this.residentialElasticRepository = residentialElasticRepository;
    }

    void getData(String LAWD_CD, String DEAL_YWD) throws MalformedURLException, IOException {
        HttpURLConnection urlConnection = null;
        InputStream stream = null;


        String requestUrl = apiUrl + "serviceKey=" + serviceKey + "&LAWD_CD=" + LAWD_CD + "&DEAL_YMD=" + DEAL_YWD;
        System.out.println(requestUrl);

        try {
            URL url = new URL(requestUrl);

            urlConnection = (HttpURLConnection) url.openConnection();
            stream = getNetworkConnection(urlConnection);
            String result = readStreamToString(stream);
            log.info(result);

            String result2 = XML.toJSONObject(result).toString();

            ObjectMapper objectMapper = new ObjectMapper();
            JsonNode rootNode = objectMapper.readTree(result2);

            JsonNode itemsNode = rootNode.path("response").path("body").path("items").path("item");

            List<ApartmentItem> itemList = new ArrayList<>();
            for (JsonNode itemNode : itemsNode) {
                ApartmentItem item = objectMapper.treeToValue(itemNode, ApartmentItem.class);
                itemList.add(item);
            }

            for (ApartmentItem item : itemList) {
                Residential residential = ApartmentItem.toTable(item);
                Residential savedResidential = residentialRepository.save(residential);
                System.out.println(savedResidential.getResidentialId());

                ResidentialDocument residentialDocument = ResidentialDocument.to(savedResidential);
                residentialElasticRepository.save(residentialDocument);
            }

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
