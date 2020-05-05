package com.assignment.boggle.cache;


import java.util.Map;

/**
 * Cache implementation to store and retrieve score from ui
 * NOTE : Only limited key values are stored as this will be in InMemory
 */
public interface Cache {

    /**
     *  Adds key value to cache
     * @param key
     * @param value
     */
    void add(String key, int value);

    /**
     * Remove object with given key
     * @param key
     */
    void remove(String key);

    /**
     * retrieve object with given key
     * @param key
     * @return
     */
    int get(String key);

    /**
     * Clear Every thing in the InMemory
     */
    void clear();

    /**
     *  gives total size of the cache
     * @return
     */
    long size();

    /**
     * get all the element in the cache
     * @return
     */
    Map<String, Integer> getAll();
}
