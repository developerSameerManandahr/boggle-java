package com.assignment.boggle.cache;

import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;

public class InMemoryCache implements Cache {

    // max size of the cache
    private static final int MAX_SIZE_OF_CACHE = 5;

    private final ConcurrentHashMap<String, Integer> cache = new ConcurrentHashMap<>();

    @Override
    public void add(String key, int value) {
        if (cache.size() >= MAX_SIZE_OF_CACHE) {
            Optional<Map.Entry<String, Integer>> cacheObject = cache.entrySet().stream().min(Map.Entry.comparingByValue());
            cacheObject.map(Map.Entry::getKey).ifPresent(cache::remove);
        }
        cache.put(key, value);
    }

    @Override
    public void remove(String key) {
        cache.remove(key);
    }

    @Override
    public int get(String key) {
        return Optional.ofNullable(cache.get(key)).orElse(null);
    }

    @Override
    public void clear() {
        cache.clear();
    }

    @Override
    public long size() {
        return cache.size();
    }

    public Map<String, Integer> getAll() {
        return cache;
    }
}
