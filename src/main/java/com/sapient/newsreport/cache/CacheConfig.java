//package com.sapient.newsreport.cache;
//
//import org.springframework.cache.annotation.EnableCaching;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
//import java.io.File;
//import java.time.Duration;
//
//@Configuration
//@EnableCaching
//public class CacheConfig {
//
//    @Bean
//    public org.ehcache.CacheManager cacheManager() {
//        // Define where the cache data will be persisted
//        File persistenceLocation = new File(System.getProperty("user.home"), "my-cache-data");
//
//        // Build the CacheManager with disk persistence configuration
//        CacheManagerBuilder<org.ehcache.CacheManager> cacheManagerBuilder = CacheManagerBuilder.newCacheManagerBuilder()
//            .with(new CacheManagerPersistenceConfiguration(persistenceLocation)) // Path for persistence
//            .withCache("newsCache",
//                CacheConfigurationBuilder.newCacheConfigurationBuilder(
//                    String.class, Object.class,
//                    ResourcePoolsBuilder.newResourcePoolsBuilder()
//                        .heap(100, EntryUnit.ENTRIES)     // Heap size
//                        .disk(500, MemoryUnit.MB, true)) // Disk size with persistence
//                .withExpiry(ExpiryPolicyBuilder.timeToLiveExpiration(Duration.ofMinutes(10))));
//
//        // Build and initialize the cache manager
//        org.ehcache.CacheManager cacheManager = cacheManagerBuilder.build(true);
//
//        return cacheManager;
//    }
//}
