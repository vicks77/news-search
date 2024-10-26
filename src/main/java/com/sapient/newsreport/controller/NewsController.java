package com.sapient.newsreport.controller;

import com.sapient.newsreport.services.NewsService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/news")
@CrossOrigin(origins = "http://localhost:3000")
public class NewsController {

    private final NewsService newsService;

    public NewsController(NewsService newsService) {
        this.newsService = newsService;
    }

    @GetMapping("/search")
    public ResponseEntity<String> searchNews(@RequestParam String keyword,
                                             @RequestParam(defaultValue = "12") int N,
                                             @RequestParam(defaultValue = "hours") String interval) {
        String result = newsService.getNewsForKeyword(keyword, N, interval);
        return ResponseEntity.ok(result);
    }
}
