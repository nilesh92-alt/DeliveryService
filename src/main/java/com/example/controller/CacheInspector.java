package com.example.controller;

import com.github.benmanes.caffeine.cache.Cache;
import org.springframework.cache.CacheManager;
import org.springframework.cache.caffeine.CaffeineCache;
import org.springframework.stereotype.Service;

@Service
public class CacheInspector {

    private final CacheManager cacheManager;

    public CacheInspector(CacheManager cacheManager) {
        this.cacheManager = cacheManager;
    }

    public void printCacheEntries() {

        CaffeineCache caffeineCache =
                (CaffeineCache) cacheManager.getCache("ratelimit");

        Cache<Object, Object> nativeCache = caffeineCache.getNativeCache();

//        nativeCache.asMap().forEach((k, v) ->
//                System.out.println("Key = " + k + " Value = " + v));
    }
}