package com.sapient.newsreport.services;

import com.sapient.newsreport.config.NewsApiConfig;
import com.sapient.newsreport.utils.DateManipulation;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDate;

@Service
public class NewsService {

    private final String apiUrl = "https://newsapi.org/v2/everything";
    private final NewsApiConfig config;
    private final RestTemplate restTemplate;

    public NewsService(NewsApiConfig config, RestTemplateBuilder restTemplateBuilder) {
        this.config = config;
        this.restTemplate = restTemplateBuilder.build();
    }


    @Cacheable(value = "newsCache", key = "#keyword + '_' + #N + '_' + #interval", unless = "#result == null")

    public String getNewsForKeyword(String keyword, int N, String interval) {
        System.out.println("No cache ");
        LocalDate fromDate=LocalDate.now();
        LocalDate toDate= DateManipulation.dateRange(interval);
      //  String url=apiUrl
      String url = String.format("%s?q=%s&from=%s&to=%s&apiKey=%s", apiUrl,keyword,fromDate,toDate, config.getApiKey());
        ResponseEntity<String> response = restTemplate.getForEntity(url, String.class);
        
        // Parse and bucket results based on date interval
        return response.getBody();
    }
}
