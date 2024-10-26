//package com.sapient.newsreport.services;
//import com.sapient.newsreport.dto.NewsArticle;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//import org.springframework.web.client.RestTemplate;
//import java.time.LocalDateTime;
//import java.util.List;
//
//@Service
//public class NewsServiceNew {
//
//    private static final String NEWS_API_KEY = "your_newsapi_key_here";
//    private static final String NEWS_API_URL = "https://newsapi.org/v2/everything?q={keyword}&apiKey={apiKey}";
//
//    @Autowired
//    private CacheClass newsRepository;
//
//    @Autowired
//    private FallbackService fallbackService;
//
//    public List<NewsArticle> getNews(String keyword, LocalDateTime start, LocalDateTime end, boolean isOffline) {
//        if (isOffline) {
//            // Return news from the local database in offline mode
//            return newsRepository.findByKeywordAndPublishedAtBetween(keyword, start, end);
//        }
//
//        // Try fetching news from NewsAPI
//        try {
//            RestTemplate restTemplate = new RestTemplate();
//            String url = NEWS_API_URL.replace("{keyword}", keyword).replace("{apiKey}", NEWS_API_KEY);
//            NewsApiResponse response = restTemplate.getForObject(url, NewsApiResponse.class);
//
//            // Save to database for offline access
//            List<NewsArticle> articles = response.getArticles();
//            newsRepository.saveAll(articles);
//
//            return articles;
//        } catch (Exception e) {
//            // If API is unavailable, use fallback
//            return fallbackService.getFallbackNews(keyword);
//        }
//    }
//}
