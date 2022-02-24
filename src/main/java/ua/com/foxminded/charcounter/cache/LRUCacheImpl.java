package ua.com.foxminded.charcounter.cache;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;

public class LRUCacheImpl implements LRUCache {
    private Map<String, Map<Character, Integer>> cache;

    public LRUCacheImpl(int cacheSize) {
        this.cache = new LinkedHashMap<String, Map<Character, Integer>>(cacheSize, 0.66f, true) {
            private static final long serialVersionUID = -5956805087517522201L;

            @Override
            protected boolean removeEldestEntry(Map.Entry<String, Map<Character, Integer>> eldest) {
                return size() > cacheSize;
            }

        };
    }

    private void makeMoreRelevant(String key) {
        Map<Character, Integer> copyCalue = cache.get(key);
        cache.remove(key);
        cache.put(key, copyCalue);
    }

    private Map<Character, Integer> makeMoreRelevant(String key,
                                                     Map<Character, Integer> newValue) {
        cache.remove(key);
        return cache.put(key, newValue);
    }

    @Override
    public Map<Character, Integer> get(String key) {
        if (!cache.containsKey(key)) {
            return Collections.emptyMap();
        }
        makeMoreRelevant(key);
        return cache.get(key);

    }

    @Override
    public String getAll() {
        return cache.toString();
    }

    @Override
    public Map<Character, Integer> put(String key,
                                       Map<Character, Integer> value) {
        if (cache.containsKey(key)) {
            return makeMoreRelevant(key, value);
        }
        return cache.put(key, value);
    }

    @Override
    public boolean putAll(Map<String, Map<Character, Integer>> cache) {
        this.cache.putAll(cache);
        return cache.keySet()
                    .containsAll(cache.keySet());
    }

    @Override
    public Map<Character, Integer> remove(String key) {
        return cache.remove(key);
    }

    @Override
    public boolean remove(String key,
                          Map<Character, Integer> value) {
        return cache.remove(key, value);
    }

    @Override
    public boolean removeAll() {
        cache.clear();
        return cache.isEmpty();
    }

    @Override
    public boolean containsKey(String key) {
        return cache.containsKey(key);
    }

}
