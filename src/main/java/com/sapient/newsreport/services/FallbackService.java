package com.sapient.newsreport.services;

import com.sapient.newsreport.dto.NewsArticle;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Collections;

@Service
public class FallbackService {

    public List<NewsArticle> getFallbackNews(String keyword) {
        // In case of API failure, return some predefined or cached results
        return Collections.emptyList();
    }
}
