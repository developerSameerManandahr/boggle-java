package com.assignment.boggle.cache;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CacheTest {
    private final Cache cache = new InMemoryCache();

    @Test
    public void should_be_able_to_add_entries() {
        cache.add("xyz", 10);
        assertEquals(cache.get("xyz"), 10);
        cache.clear();
    }

    @Test
    public void should_only_be_able_to_add_limited_data() {
        // Add 6 entries
        initializeCacheData();
        cache.add("6", 6);

        // limit of cache is set to 5 so only 5 data are saved
        assertEquals(cache.size(), 5);
        cache.clear();
    }

    @Test
    public void should_remove_lowest_value_after_limit_is_reached() {
        initializeCacheData();
        assertTrue(cache.getAll().containsKey("1"));
        cache.add("6", 6);
        // After limit is reached it will remove entry with lowest calue
        assertFalse(cache.getAll().containsKey("1"));
        cache.clear();
    }

    @Test
    public void should_clear_cache(){
        initializeCacheData();
        assertEquals(cache.size(), 5);
        cache.clear();
        assertEquals(cache.size(), 0);
    }

    private void initializeCacheData() {
        cache.add("1", 1);
        cache.add("2", 2);
        cache.add("3", 3);
        cache.add("4", 4);
        cache.add("5", 5);
    }
}
