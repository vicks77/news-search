//package com.sapient.newsreport.serviceImpl;
//
//public class BucketNews {
//
//    public Map<String, List<Article>> groupArticlesByDate(List<Article> articles, int N, String interval) {
//        Map<String, List<Article>> groupedArticles = new HashMap<>();
//
//        for (Article article : articles) {
//            LocalDateTime publishedAt = article.getPublishedAt(); // Parse the article's published date
//            String bucketKey = calculateBucket(publishedAt, N, interval); // Use a method to calculate the bucket
//
//            groupedArticles.putIfAbsent(bucketKey, new ArrayList<>());
//            groupedArticles.get(bucketKey).add(article);
//        }
//
//        return groupedArticles;
//    }
//
//    private String calculateBucket(LocalDateTime publishedAt, int N, String interval) {
//        // Logic to create bucket keys based on N and interval
//        // For example, "Last 12 hours", "Last 7 days", etc.
//    }
//
//}
